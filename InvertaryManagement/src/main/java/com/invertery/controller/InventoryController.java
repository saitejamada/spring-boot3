package com.invertery.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.invertery.model.Customer;
import com.invertery.model.Inventory;
import com.invertery.model.Login;
import com.invertery.model.Payment;
import com.invertery.model.Permission;
import com.invertery.model.Role;
import com.invertery.model.Stock;
import com.invertery.model.Supplier;
import com.invertery.model.User;
import com.invertery.service.CustomerService;
import com.invertery.service.InventoryService;
import com.invertery.service.PaymentService;
import com.invertery.service.PermissionService;
import com.invertery.service.RoleService;
import com.invertery.service.StockService;
import com.invertery.service.SupplierService;
import com.invertery.service.UserService;

@Controller
public class InventoryController {

	@Autowired
	CustomerService cs;
	
	@Autowired
	InventoryService is;
	
	@Autowired
	PaymentService ps;
	
	@Autowired
	PermissionService perser;
	
	@Autowired
	RoleService rs;
	
	@Autowired
	StockService ss;
	
	@Autowired
	SupplierService supser;
	
	@Autowired
	UserService us;
	
	User u1;
	List<Stock> s=new ArrayList<>();
	List<Stock> s1=new ArrayList<>();
	String st;
	
	@PostConstruct
	void postConstruct() {
	 
		Role r=new Role("user", "all user roles");
		User u=new User(112,r, "saiteja", "sai@abc.com", new Date(2022, 8, 29) ,"Hyderabad");
		us.saveUser(u);
		Customer c=new Customer("ravi","889797897","ravi@abc.com","ravi@abc","ravi1","nizamabad");
		cs.saveCustomer(c);
		Inventory i=new Inventory("New Inventory","2211","goods","food");
		is.saveInventory(i);
		Permission per=new Permission(r, "user permission","user is permitted");
		perser.savePermission(per);
		Stock s=new Stock("goods", "99","wheat", "30",70);
		Stock s1=new Stock("goods", "929","rice", "20",1200);
		Stock s2=new Stock("goods", "99","sugar", "10",50);
		ss.saveStock(s);ss.saveStock(s1);ss.saveStock(s2);
		Supplier sup=new Supplier("ranchod","979798","ranchod@abc.com","hyderabaad","ranchod@abc","ranchod");
		supser.saveSupplier(sup);
		
	}
	
	@RequestMapping("/home")
	public String goHome() {
		return "Homepage";
	}
	
	@RequestMapping("/reguser")
	public String registerUser(Model m) {
		m.addAttribute("user", new User());
		return "RegisterUser";
	}
	@RequestMapping("/adduser")
	public String addUser(@ModelAttribute("user") User u,Model m) {
		us.saveUser(u);
		return "redirect:/login";
	}
	@RequestMapping("/login")
	public String goLogin(Model m) {
		m.addAttribute("log", new Login());
		return "Login";
	}
	@RequestMapping("/validateuser")
	public String validateUser(@ModelAttribute("log") Login l ,Model m) {
		 u1=us.getUser(l.getUserid());
		m.addAttribute("name", u1.getName());
		return "MainPage";
	}
	@RequestMapping("/viewallstock")
	public String viewAllStocks(Model m) {
		m.addAttribute("list", ss.getAllStock());
		return "AllStock";
	}
	@RequestMapping("/gopayment/{id}")
	public String gopayment(@PathVariable("id") int id,Model m) {
		Stock s=ss.getStock(id);
		Payment p=new Payment();
		if(u1==null)
		return "AccessDenied";
		Customer c=new Customer(u1.getName(),"" , u1.getEmail(), null, null, u1.getAddress());
		p.setC(c);
		p.setAmount(String.valueOf(s.getPrice()));
		m.addAttribute("pay", p);
		return "Payment";
	}
	@RequestMapping("/suppiler")
	public String goSuppiler(Model m) {
		m.addAttribute("sup",new Supplier() );
		return "RegisterSuppiler";
	}
	@RequestMapping("/addsuppiler")
	public String addSuppiler(@ModelAttribute("sup") Supplier s,Model m) {
		supser.saveSupplier(s);
		m.addAttribute("name", s.getName());
		return "redirect:/log";
	}
	@RequestMapping("/stock")
	public String regStock(Model m) {
		m.addAttribute("stock", new Stock());
		return "AddStock";
	}
	@RequestMapping("/addstock")
	public String addStock(@ModelAttribute("stock") Stock s,Model m) {
		ss.saveStock(s);
		return "SupplierPage";
	}
	@RequestMapping("/finaled")
	public String finalMethod(@ModelAttribute("pay")Payment p,Model m) {
		ps.savePayment(p);
		m.addAttribute("time",LocalDateTime.now());
		return "Success";
	}
	@RequestMapping("/log")
	public String goLog(Model m) {
		m.addAttribute("log", new Supplier());
		return "SupplierLogin";
	}
	@RequestMapping("/validatesupplier")
	public String valid(@ModelAttribute("log") Supplier s,Model m) {
		return "SupplierPage";
	}
	@RequestMapping("/invent")
	public String goinvent(Model m) {
		m.addAttribute("in", new Inventory());
		return "AddInventory";
	}
	@RequestMapping("/addinvent")
	public String addInventory(@ModelAttribute("in") Inventory i,Model m) {
		is.saveInventory(i);
		return "redirect:/validatesupplier";
	}
	@RequestMapping("/viewallinvent")
	public String viewallInentory(Model m) {
		System.out.println(is.getAll());
		m.addAttribute("list", is.getAll());
		return "ViewAllInventorys";
	}
	@RequestMapping("/sipplierstock")
	public String supplierStock(Model m) {
		m.addAttribute("list", ss.getAllStock());
		return "SupplierStock";
	}
	@RequestMapping("/addstockinventory/{id}")
	public String addstocktoinvent(@PathVariable("id") int id,Model m) {
		st=ss.getStock(id).getDecription();
		Inventory inv;
		if(st.equals("goods"))
		{
			st=ss.getStock(id).getDecription();
			s.add(ss.getStock(id));
			 inv=is.getInventoryType(st);
			inv.setS(s);
		}
		else
		{
			st=ss.getStock(id).getDecription();
			s1.add(ss.getStock(id));
			 inv=is.getInventoryType(st);
			inv.setS(s1);
		}
		is.updateInventory(inv);
		return "redirect:/validatesupplier";
	}
}
