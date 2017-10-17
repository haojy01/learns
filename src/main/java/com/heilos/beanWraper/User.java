package com.heilos.beanWraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

public class User {

	private String userName;
	private String userAge;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public static void main(String[] args) {

		User user = new User();
		BeanWrapper wraper = PropertyAccessorFactory.forBeanPropertyAccess(user);
		PropertyValue pv = new PropertyValue("userName", "haojiuyuan");
		wraper.setPropertyValue(pv);
		System.out.println(user.getUserName());
	}
}
