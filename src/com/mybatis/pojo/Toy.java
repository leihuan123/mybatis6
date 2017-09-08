package mybatis.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Toy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private	Integer id;
private String name;
private Double price;
private Date saleDate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Date getSaleDate() {
	return saleDate;
}
public void setSaleDate(Date saleDate) {
	this.saleDate = saleDate;
}
public Toy(Integer id, String name, Double price, Date saleDate) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
	this.saleDate = saleDate;
}
public Toy() {
	super();
}


}
