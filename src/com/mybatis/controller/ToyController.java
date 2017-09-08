package mybatis.controller;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.pojo.Toy;
import mybatis.service.toyService;

@Controller
public class ToyController {
@Resource(name="toyService")
private toyService service;
@RequestMapping("toylist")
public ModelAndView list(@RequestParam (value="name",required=false) String name){
	List<Toy> toys=service.findByName(name);
	ModelAndView mv= new ModelAndView();
	mv.setViewName("toylist");
	mv.addObject("toys", toys);
	return mv;
}

@RequestMapping("findById")
public ModelAndView findById(@RequestParam (value="id",required=false) Integer id) {
	Toy toy =service.findById(id);
	System.out.println(toy.getSaleDate().toString());
	
	String date=toy.getSaleDate().toString();
	String 	date2=date.substring(0,10);
	
	System.out.println(date2);	
	ModelAndView mv= new ModelAndView();
	mv.setViewName("xiugai");
	mv.addObject("toy", toy);
	mv.addObject("date", date2);
	return mv;
}

@RequestMapping("findAll")
public ModelAndView findAll(){
	List<Toy> toys =service.findAll();
	ModelAndView mv= new ModelAndView();
	mv.setViewName("toylist");
	mv.addObject("toys", toys);
	return mv;
}
//只支持POST提交
@RequestMapping(value="deleteToy",method=RequestMethod.POST,produces="text/html;charset=utf-8")
@ResponseBody//响应内容
public String deleteToy(@RequestParam (value="id",required=false) Integer id){
	System.out.println("sssssssssssssssssssssssssss");
	int a =service.remove(id);
	/*ModelAndView mv= new ModelAndView();
	if (a>0) {
		List<Toy> toys=service.findAll();
		mv.setViewName("toylist");
		mv.addObject("toys", toys);
	}else {
		mv.setViewName("toylist");
		mv.addObject("message", "删除失败！！！");
	}*/
	
		return String.valueOf(a);	
	
	
}

@RequestMapping("addToy")
public ModelAndView addToy(
		@RequestParam(value="name",required=false) String name,
		@RequestParam(value="price",required=false) Double price,		
		@RequestParam(value="saleDate",required=false)String saleDate) {
	Toy to=new Toy();
	to.setId(11);
	to.setName(name);
	to.setPrice(price);
    Date date=Date.valueOf(saleDate);
    to.setSaleDate(date);
	int a =service.addtoy(to);
	ModelAndView mv= new ModelAndView();
	if (a>0) {
		List<Toy> toys=service.findAll();
		mv.setViewName("toylist");
		mv.addObject("toys", toys);
	}else {
		mv.setViewName("add");
		mv.addObject("message", "添加失败！！！");
	}
	
	return mv;
}
@RequestMapping("updateToy")
public ModelAndView updateToy(
		@RequestParam(value="id",required=false) Integer id,
		@RequestParam(value="name",required=false) String name,
		@RequestParam(value="price",required=false) Double price,		
		@RequestParam(value="saleDate",required=false) String saleDate) 
       /* @DateTimeFormat(pattern="yyyy-MM-dd")Date saleDate)*/{
	Toy to=new Toy();
	to.setId(id);
	to.setName(name);
	to.setPrice(price);
	Date date=Date.valueOf(saleDate);
	to.setSaleDate(date);
	int a =service.modify(to);
	ModelAndView mv= new ModelAndView();
	if (a>0) {
		List<Toy> toys=service.findAll();
		mv.setViewName("toylist");
		mv.addObject("toys", toys);
	}else {
		mv.setViewName("xiugai");
		mv.addObject("message", "修改失败！！！");
	}
	
	return mv;
}
}
