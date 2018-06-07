package com.niit.test;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDao;



public class apptest {

	private static AnnotationConfigApplicationContext context;
	
	
	static UserDao userDao;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.dao");
		context.scan("com.niit.model.User");
		context.scan("com.niit.configuration");
		context.scan("com.niit");
		context.refresh();
		userDao=(UserDao) context.getBean("userDAO");
		
	}
	@Test
	 public void printBeans() {
	        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
	    }
}