package com.products.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.products.model.Bill;
import com.products.model.Category;
import com.products.model.Product;
import com.products.model.Users;
import com.products.service.ProductsService;

@Controller
public class ProductController {

	@Autowired
	ProductsService ps;
	
	@PostConstruct
	void postConstruct()
	{
		Category c=new Category();
		c.setCategory_id(10);
		c.setType("electronics");
		ps.saveCategory(c);
		Product p=new Product();
		p.setProduct_id(112);
		p.setAvaiable_quantity(112);
		p.setCategory(c);
		p.setName("tv");
		p.setPrice(12345);
		ps.addProducts(p);
		Users u=new Users();
		u.setUser_id(1992);
		u.setName("sai");
		u.setPassword("sai");
		u.setType("user");
		ps.saveUser(u);
		Users u1=new Users();
		u1.setUser_id(1);
		u1.setName("admin");
		u1.setPassword("admin");
		u1.setType("admin");
		ps.saveUser(u1);
		Bill b=new Bill();
		b.setBillno(101);b.setAmount(23400);b.setProduct(p);b.setSelect_quantity(3);
		b.setUser(u);
		ps.addBill(b);
		//ps.getBill(b);
	}
	
	@RequestMapping("/home")
	public String home() {
		return "HomePage";
	}
	@RequestMapping("/login")
	public String login(Model m) {
		Users u=new Users();
		m.addAttribute("user",u);
		return "Login";
	}
	@RequestMapping("/validate")
	public String ValidateUser(@ModelAttribute("user") Users u,Model m) {
		String type=ps.validateUser(u);
		if(type.equals("admin"))
		{
			return "Admin";
		}
		else {
			List<Product> list=ps.getAllProducts();
			m.addAttribute("user", list);
			return "MainPage";
		}
	}
	@RequestMapping("/signup")
	public String signup(Model m) {
		Users u=new Users();
		m.addAttribute("user",u);
		return "Signup";
	}
	@RequestMapping("/signupuser")
	public String saveUser(@ModelAttribute("user") Users u,Model m)
	{
		ps.saveUser(u);
		m.addAttribute("user", u);
		return "Login";
		
	}
	@RequestMapping("/product")
	public String product(Model m) {
	Product p=new Product();
	m.addAttribute("product", p);
	return "AddProduct";
	}
	@RequestMapping("/addproduct")
	public String addProduct(@ModelAttribute("product") Product p,Model m) {
		ps.addProducts(p);
		m.addAttribute("msg","Added Succesfully");
		return "AddProduct";
	}
	@RequestMapping("/bill")
	public String bill(Model m) {
		Bill b=new Bill();
		m.addAttribute("bill", b);
		return "AddBill";
	}
	@RequestMapping("/addbill")
	public String addBill(@ModelAttribute("bill")Bill b,Model m) {
		Product p=b.getProduct();
		p=ps.getProduct(p.getProduct_id());
		int amount=p.getPrice();
		int quantity=b.getSelect_quantity();
		System.out.println(quantity+"   "+amount);
		int total=amount*quantity;
		b.setAmount(total);
		//ps.addBill(b);
		//int total=ps.getBill(b);
		m.addAttribute("msg","total amount is = "+total);
		return "AddBill";
	}
	@RequestMapping("/up")
	public String goUpdate(Model m) {
		Product p=new Product();
		m.addAttribute("product", p);
		return "Update";
	}
	@RequestMapping("/updateproduct")
	public String update(@ModelAttribute("product") Product p,Model m)
	{
		System.out.println(p);
		ps.updateProduct(p.getProduct_id(), p.getPrice());
		m.addAttribute("msg","Updated Succesfully");
		return "Update";
	}
}
