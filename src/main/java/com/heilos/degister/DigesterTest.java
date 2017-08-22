package com.heilos.degister;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

public class DigesterTest {
	public static void main(String[] args) throws IOException {
		File xml = new File("/home/haojy/github/learns/src/main/java/com/heilos/degister/student.xml");
		Digester digester = new Digester();
		digester.addObjectCreate("student", "com.heilos.degister.Student");
		digester.addSetProperties("student");
		digester.addObjectCreate("student/subjects", "com.heilos.degister.Subjects");
		digester.addSetProperties("student/subjects");
		digester.addSetNext("student/subjects", "add");
		Student student = null;
		try {
			student = (Student) digester.parse(xml);
		} catch (SAXException e) {
			System.out.println("parse with mistakes!");
		}
		Iterator it = student.getList().iterator();
		while (it.hasNext()) {

		}
	}
}
