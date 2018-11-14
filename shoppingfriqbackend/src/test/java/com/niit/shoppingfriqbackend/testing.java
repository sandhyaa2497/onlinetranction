//package com.niit.shoppingfriqbackend;
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//
//import com.niit.dao.CustomerDao;
//
//import com.niit.model.Userdetails;
//
//public class testing {
//public static void main(String[] args) {
//		
//		@SuppressWarnings("resource")
//		AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext();
//		config.scan("com.niit.*");
//		config.refresh();
//		Userdetails user=(Userdetails)config.getBean("userdetails");
//		
//		CustomerDao userDao=(CustomerDao)config.getBean("userDao");
//		
//		
//		user.setAddress("banglore");
//		user.setEmail("abc@gmail.com");
//		
//		user.setPassword("123");
//		user.setPhno("988266988");
//        
//       userDao.adduser(user);
//		
//		
//	}
//}
