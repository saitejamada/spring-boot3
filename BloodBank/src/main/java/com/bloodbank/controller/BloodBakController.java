package com.bloodbank.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bloodbank.exception.BloodBankException;
import com.bloodbank.model.Blood;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Login;
import com.bloodbank.model.Order;
import com.bloodbank.model.Patient;
import com.bloodbank.model.Permission;
import com.bloodbank.model.Role;
import com.bloodbank.model.Stock;
import com.bloodbank.model.User;
import com.bloodbank.service.BloodService;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.OrderService;
import com.bloodbank.service.PatientService;
import com.bloodbank.service.PermissionService;
import com.bloodbank.service.RoleService;
import com.bloodbank.service.StockService;
import com.bloodbank.service.UserService;

@Controller
public class BloodBakController {

	@Autowired
	UserService us;
	
	@Autowired
	BloodService br;
	
	@Autowired
	DonorService ds;
	
	@Autowired
	OrderService os;
	
	@Autowired
	PatientService ps;
	
	@Autowired
	PermissionService pers;
	
	@Autowired
	RoleService rs;
	
	@Autowired
	StockService ss;
	
	@SuppressWarnings("deprecation")
	@PostConstruct
	void postConstruct() {
		Role r=new Role("admin", "has all permissions");
		Permission p=new Permission("admin", r);
		Order or=new Order("online","urgent requirement");
		User u=new User("saiteja","sai@abc.com", new Date(96, 5, 10), "hyderabad", "sai", r, p, or);
		us.saveUser(u);
		Donor d=new Donor("saiteja mada", "8499995950", "sai@abc.com", "hyderabad", u);
		Blood b=new Blood("AB","posititve", "pavan Kalyan Blood Bank", d);
		Stock s=new Stock("AB","POSITIVE", "11211", p);
		Patient ps1=new Patient("raju", "454535354","nizamabad", "raj@abc.com", "rajudani","raj", p);
		Stock s1=new Stock("AB","POSITIVE", "1245", p);
		Stock s2=new Stock("AB","NEGATIVE", "987", p);
		Stock s3=new Stock("A","POSITIVE", "1", p);
		Stock s4=new Stock("A","NEGATIVE", "2", p);
		Stock s5=new Stock("A","POSITIVE", "8989", p);
		Stock s6=new Stock("A","POSITIVE", "987I8", p);
		ds.saveDonor(d);
		br.saveBlood(b);
		ss.saveStock(s);ss.saveStock(s1);ss.saveStock(s2);ss.saveStock(s3);ss.saveStock(s4);ss.saveStock(s6);ss.saveStock(s5);
		ps.savePatient(ps1);
	}
	
	@RequestMapping("/main")
	public String goHomePage() {
		return "MainPage";
	}
	@RequestMapping("/donormain")
	public String goDonorPage(Model m) {
		m.addAttribute("don", new Donor());
		return "Donor";
	}
	@RequestMapping("/adddonor")
	public String addDonor(@ModelAttribute("don") Donor d,Model m) {
		ds.saveDonor(d);
		m.addAttribute("don", d);
		return "DonorFile";
	}
	@RequestMapping("/log")
	public String goLog(Model m) {
		m.addAttribute("log", new Login());
		return "Login";
	}
	
	@RequestMapping("/validateuser")
	public String govalidate(@ModelAttribute("log") Login l,Model m){
		if(l==null) {
			throw new BloodBankException("User Not Found");
		}
		else{
			m.addAttribute("name", l);
			return "UserHomepage";	
		}
		
	}
	
	@RequestMapping("/ro")
	public String role(Model m) {
		m.addAttribute("reg", new Role());
		return "RegisterRole";
	}
	@RequestMapping("/role")
	public String regRle(@ModelAttribute("reg") Role r,Model m) {
		rs.saveRole(r);
		Permission p=new Permission();
		p.setRole(r);
		m.addAttribute("perm",p);
		return "RegistePermission";
	}
	
	@RequestMapping("/per")
	public String goPer(Model m) {
		m.addAttribute("perm",new Permission());
		return "RegistePermission";
	}
	@RequestMapping("/permission")
	public String goPermission(@ModelAttribute("perm")Permission p,Model m) {
		pers.savePermission(p);
		User u=new User();u.setPermission(p);u.setRole(p.getRole());
		m.addAttribute("user", u);
		return "RegisterUserPage";
	}
	@RequestMapping("/reguser")
	public String registerUser(Model m) {
		m.addAttribute("user", new User());
		return "RegisterUserPage";
	}
	@RequestMapping("/registeruser")
	public String register(@ModelAttribute("user") User u) {
		us.saveUser(u);
		return "redirect:/log";
	}
	@RequestMapping("/patient")
	public String patient(Model m) {
		m.addAttribute("pat", new Patient());
		return "RegisterPatient";
	}
	@RequestMapping("/addpatient")
	public String addPatient(@ModelAttribute("pat") Patient p,Model m) {
		ps.savePatient(p);
		List<Stock> list1=ss.getAllStocks(p.getBlood(), p.getType());
		if(list1==null)
			throw new BloodBankException("Blood with secific details not present");
		else {
			m.addAttribute("list", list1);
			return "Stock";
		}
		
	}
	@RequestMapping("/finaled")
	public String finalMethod(Model m) {
		m.addAttribute("time",LocalDateTime.now());
		return "FindHospital";
	}
}
