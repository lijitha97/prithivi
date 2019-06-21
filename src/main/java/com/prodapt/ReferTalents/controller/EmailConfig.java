//package com.prodapt.ReferTalents.controller;
//
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//
//
//@Configuration
//public class EmailConfig {
//	@Value("${spring.mail.host}")
//	private String host;
//
//	@Value("${spring.mail.port}")
//	private int port;
//	
//	@Value("${spring.mail.password}")
//	private String password;
//	
//	@Value("${spring.mail.username}")
//	private String username;
//
//	@Bean(name = "emailconfig")
//	public JavaMailSenderImpl mailSenderImpl() {
//		JavaMailSenderImpl impl = new JavaMailSenderImpl();
//		impl.setHost(host);
//		impl.setPort(port);
//		impl.setPassword(password);
//		impl.setUsername(username);
//		Properties mailprops = new Properties();
//		impl.setJavaMailProperties(mailprops);
//		return impl;
//	}
//
//
//}
