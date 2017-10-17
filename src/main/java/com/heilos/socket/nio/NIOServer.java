package com.heilos.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {
	public static void main(String[] args) throws IOException {
		//创建ServerSocketChannel监听8080端口
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress(8080));
		//设置为非阻塞
		ssc.configureBlocking(false);
		//为ssc注册选择器
		Selector selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		//创建处理器
		Handler handler = new Handler();
		while (true) {
			//等待请求,每次等待阻塞3s,超过3s后线程继续向下运行,如果传入0或者不传入参数将一直阻塞
			if (selector.select(3000) == 0) {
				System.out.println("等待请求超时.");
				continue;
			}
			System.out.println("处理请求.....");
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				try {
					//接收到连接请求时,
					SelectionKey key = iterator.next();
					if (key.isAcceptable()) {
						handler.handleAccept(key);
					}
					//读数据
					if (key.isReadable()) {
						handler.handleRead(key);
					}
				} catch (IOException e) {
					iterator.remove();
					continue;
				}
				//处理完后,从待处理的selectionkey迭代器中移除当前所使用的key
				iterator.remove();
			}
		}
	}

	private static class Handler {
		private int bufferSize = 1024;
		private String localCharset = "UTF-8";

		public void handleAccept(SelectionKey key) throws IOException {
			ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
			SocketChannel sc = ssc.accept();
			sc.configureBlocking(false);
			sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
		}

		public void handleRead(SelectionKey key) throws IOException {
			//获取channel
			SocketChannel sc = (SocketChannel) key.channel();
			//获取buffer并且重置
			ByteBuffer buffer = (ByteBuffer) key.attachment();
			buffer.clear();
			if (sc.read(buffer) == -1) {
				sc.close();
			} else {
				//将buffer转换为读状态
				buffer.flip();
				// 将buffer从接收到的值按localCharest格式编码后保存到receivedString
				String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
				System.out.println("recevied from client :" + receivedString);
				//返回数据给客户端
				String sendString = "recevied data :" + receivedString;
				buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
				sc.write(buffer);
				sc.close();
			}
		}
	}
}
