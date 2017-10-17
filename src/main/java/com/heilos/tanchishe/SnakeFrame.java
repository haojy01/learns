package com.heilos.tanchishe;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SnakeFrame extends Frame {
	private static final long serialVersionUID = 1L;
	// 方格的宽度和长度
	public static final int BLOCK_WIDTH = 15;
	public static final int BLOCK_HEIGHT = 15;
	// 界面的方格的行数和列数
	public static final int ROW = 40;
	public static final int COL = 40;

	Snake snake = new Snake(this);

	public static void main(String[] args) {
		SnakeFrame snakeFrame = new SnakeFrame();
		snakeFrame.launch();
	}

	public void launch() {

		this.setTitle("Snake");
		this.setSize(ROW * BLOCK_HEIGHT, COL * BLOCK_WIDTH);
		this.setLocation(300, 400);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setResizable(false);
		this.setVisible(true);
		new Thread(new MyPaintThread()).start();
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		/*
		 * 将界面画成由ROW*COL的方格构成,两个for循环即可解决
		 */
		for (int i = 0; i < ROW; i++) {
			g.drawLine(0, i * BLOCK_HEIGHT, COL * BLOCK_WIDTH, i * BLOCK_HEIGHT);
		}
		for (int i = 0; i < COL; i++) {
			g.drawLine(i * BLOCK_WIDTH, 0, i * BLOCK_WIDTH, ROW * BLOCK_HEIGHT);
		}
		g.setColor(c);
		snake.draw(g);
	}

	// 重画
	private class MyPaintThread implements Runnable {
		@Override
		public void run() {
			// 每隔50ms重画一次
			while (true) {
				repaint();// 会自动调用paint方法
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean b_gameOver = false;

	public void gameOver() {
		b_gameOver = true;
	}

	// 闪朔
	private Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (b_gameOver) {
			g.drawString("游戏结束！！！", ROW / 2 * BLOCK_HEIGHT, COL / 2 * BLOCK_WIDTH);
		}
		if (offScreenImage == null) {
			offScreenImage = this.createImage(ROW * BLOCK_HEIGHT, COL * BLOCK_WIDTH);
		}
		Graphics offg = offScreenImage.getGraphics();
		// 先将内容画在虚拟画布上
		paint(offg);
		// 然后将虚拟画布上的内容一起画在画布上
		g.drawImage(offScreenImage, 0, 0, null);

	}
}