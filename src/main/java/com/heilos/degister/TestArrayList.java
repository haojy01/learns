package com.heilos.degister;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
	/*	ArrayList<String> a = new ArrayList<String>();
		a.add("A");
		a.add("B");
		for (int i = 0; i < a.size(); i++) {
			if ("A".equals(a.get(i))) {
				a.remove(a.get(i));
			}
		}

		System.out.println(a);
		for (String atr : a) {
			if ("A".equals(atr)) {
				a.remove(atr);
			}
		}
		System.out.println(a);*/

		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");

	/*	for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if (s.equals("B")) {
				list.add("abc");
			}
			System.out.println(list.size());
		}
		System.out.println(list);*/

		for (String s : list) {
			/*if (s.equals("B")) {
			}*/
			list.add("abcdef");
		}

		// foreach循环等效于迭代器
		/*Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			if (s.equals("B")) {
				iterator.remove();
			}
		}
		System.out.println(list);*/

	}
}
