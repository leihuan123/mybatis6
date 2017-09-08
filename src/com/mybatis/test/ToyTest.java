package mybatis.test;


import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mybatis.pojo.Toy;
import mybatis.service.toyService;


public class ToyTest {
private toyService service;
@Before
public void init(){
	ApplicationContext txc=new ClassPathXmlApplicationContext("applicationContext.xml");
    service=txc.getBean("toyService",toyService.class);
}
@Test
public void tes1(){
	Toy to=new Toy();
	to.setId(11);
	to.setName("GTR战神");
	to.setPrice(1999999d);
	
	int a=0;
	a =service.addtoy(to);
	if (a>0) {
		System.out.println("添加OK");
	}else {
		System.out.println("添加失败");
	}
}

@Test
public void tes2(){
	Toy to=new Toy();	
	to=service.findById(48);
	
		System.out.println(to.getName()+":"+to.getPrice());
	
}

@Test
public void tes3(){
	Toy to=new Toy();	
	to=service.findById(42);
	
		System.out.println(to.getName()+":"+to.getPrice());
	
}
@Test
public void tes4(){
	Toy to=service.findById(48);
	to.setPrice(1999999d);
	to.setName("GTR战神");
	//to.setSaleDate(new Date());
	System.out.println(to.getSaleDate());
 int a=0;
 a=service.modify(to);
 if (a>0){
		System.out.println("修改OK");
 }	else {
	System.out.println("修改失败");
}
}
}
