package com.heilos.tanchishe;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Snake {

	private Node head = null;
	private Node tail = null;
	private SnakeFrame sf;
	// 初始化是蛇的位置
	private Node node = new Node(3, 4, Direction.D);
	private int size = 0;

	public Snake(SnakeFrame sf) {
		head = node;
		tail = node;
		size++;
		this.sf = sf;
	}

	public void draw(Graphics g) {
		if (head == null) {
			return;
		}
		move();
		for (Node node = head; node != null; node = node.next) {
			node.draw(g);
		}
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_LEFT:
			if (head.getDir() != Direction.R) {
				head.setDir(Direction.L);
			}
			break;
		case KeyEvent.VK_UP:
			if (head.getDir() != Direction.D) {
				head.setDir(Direction.U);
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (head.getDir() != Direction.L) {
				head.setDir(Direction.R);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (head.getDir() != Direction.U) {
				head.setDir(Direction.D);
			}
			break;
		}
	}

	public void move() {
		addNodeInHead();
		deleteNodeInTail();
	}

	private void deleteNodeInTail() {
		Node node = tail.getPre();
		tail = null;
		node.next = null;
		tail = node;
	}

	private void addNodeInHead() {
		Node node = null;
		switch (head.getDir()) {
		case L:
			node = new Node(head.getRow(), head.getCol() - 1, head.getDir());
			break;
		case U:
			node = new Node(head.getRow() - 1, head.getCol(), head.getDir());
			break;
		case R:
			node = new Node(head.getRow(), head.getCol() + 1, head.getDir());
			break;
		case D:
			node = new Node(head.getRow() + 1, head.getCol(), head.getDir());
			break;
		}

		node.next = head;
		head.setPre(node);
		head = node;
	}

	private void checkDead() {
		// 头结点的边界检查
		if (head.getRow() < 2 || head.getRow() > SnakeFrame.ROW || head.getCol() < 0
				|| head.getCol() > SnakeFrame.COL) {
			this.sf.gameOver();
		}

		// 头结点与其它结点相撞也是死忙
		for (Node node = head.next; node != null; node = node.next) {
			if (head.getRow() == node.getRow() && head.getCol() == node.getCol()) {
				this.sf.gameOver();
			}
		}
	}

}