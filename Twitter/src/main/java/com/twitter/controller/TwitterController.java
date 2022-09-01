package com.twitter.controller;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
	import com.twitter.model.Crediantails;
import com.twitter.model.Posts;
import com.twitter.model.User_twitter;
import com.twitter.service.TwitterService;

@Controller
public class TwitterController {
	
	@Autowired
	TwitterService ts;
	
	@PostConstruct
	void postConstruct() {
		Crediantails c=new Crediantails("saiteja","sai");
		ts.saveCrediantails(c);
		Posts p=new Posts(c,"Jhonny Wins #jhonnydepp");
		Posts p1=new Posts(c,"Love is a war");
		ts.savePosts(p1);
		ts.savePosts(p);
		List<Posts> list1=ts.getPosts(c);
		User_twitter u=new User_twitter(c,list1,123,22112,12);
		ts.saveDetails(u);
				
	}
	@RequestMapping("/home")
	public String goHome(Model m)
	{
		List<Posts> list1=ts.getPosts(ts.getcreditails("saiteja"));
		User_twitter u=ts.detUser(ts.getcreditails("saiteja"));
		m.addAttribute("list", list1);
		m.addAttribute("reg", u);
		return "homepage";
	}
	@RequestMapping("user")
	public String addUser(Model m)
	{
		Crediantails c1=new Crediantails();
		m.addAttribute("reg", c1);
		return "AddUser";
		
	}
	@RequestMapping("/adduser")
	public String validateUser(@ModelAttribute("reg") Crediantails c,Model m)
	{
		ts.saveCrediantails(c);
		m.addAttribute("reg", c);
		return "login";
	}
	@RequestMapping("/validateuser")
	public String checkUser(@ModelAttribute("reg") Crediantails c,Model m)
	{
		List<Posts> list1=ts.getPosts(ts.getcreditails(c.getUsername()));
		User_twitter u=ts.detUser(ts.getcreditails(c.getUsername()));
		if(c.getUsername().equals("admin"))
			return "Admin";
		if(u==null) {
			User_twitter user=new User_twitter();
			user.setCs(c);
			m.addAttribute("reg", user);
			return "AddDetails";
		}
		else
		{
			m.addAttribute("list", list1);
			m.addAttribute("reg", u);
			return "homepage";
		}
		
	}
	@RequestMapping("/po/{username}")
	public String goPosts( @PathVariable("username") String name ,Model m)
	{
		Crediantails c=ts.getcreditails(name);
		Posts p=new Posts();
		p.setCs(c);
		m.addAttribute("reg", p);
		return "AddPost";
	}
	@RequestMapping("/addpost")
	public String addPosts(@ModelAttribute("reg") Posts p,Model m) throws UnsupportedEncodingException {
		ts.savePosts(p);
		List<Posts> list1=ts.getPosts(ts.getcreditails(p.getCs().getUsername()));
		User_twitter user=ts.detUser(ts.getcreditails(p.getCs().getUsername()));
		user.setTweets(list1.size());
		byte[] encode = java.util.Base64.getEncoder().encode(user.getImage());
        m.addAttribute("image1", new String(encode, "UTF-8"));
		m.addAttribute("list", list1);
		m.addAttribute("reg", user);
		return "homepage";	
	}	
	@RequestMapping("/adddetails")
	public String saveuserDeatils(@ModelAttribute("reg") User_twitter u ,Model m) {
		ts.saveDetails(u);
		List<Posts> list1=ts.getPosts(ts.getcreditails(u.getCs().getUsername()));
		User_twitter user=ts.detUser(ts.getcreditails(u.getCs().getUsername()));
		m.addAttribute("list", list1);
		m.addAttribute("reg", user);
		return "homepage";
	}
	@RequestMapping("/login")
	public String login(Model m) {
		Crediantails c1=new Crediantails();
		m.addAttribute("reg", c1);
		return "login";
	}
	@RequestMapping("/pic/{username}")
	public String goPic(@PathVariable("username") String name,Model m) {
		Crediantails c=ts.getcreditails(name);
		User_twitter u=ts.detUser(c);
		m.addAttribute("reg", u);
		return "AddPicture";
	}
	@PostMapping(value="/addpicture", produces = MediaType.IMAGE_JPEG_VALUE)
	public String addPic
	(@RequestParam("cs")Crediantails c1 ,@RequestParam("image")MultipartFile file,Model m) throws IOException {
		
		byte [] image=file.getBytes();
		User_twitter u1=ts.detUser(c1);
		List<Posts> list1=ts.getPosts(c1);
		u1.setImage(image);
		ts.saveDetails(u1);
		byte[] encode = java.util.Base64.getEncoder().encode(image);
        m.addAttribute("image1", new String(encode, "UTF-8"));
		m.addAttribute("list", list1);
		m.addAttribute("reg", u1);
		return "homepage";
	}
	
	@RequestMapping("/getallusers")
	public String getAllUsers(Model m) {
		m.addAttribute("list", ts.getAllUsers());
		return "AllUsers";
	}
	@RequestMapping("/getallposts")
	public String getAllPosts(Model m) {
		m.addAttribute("list", ts.getAllPosts());
		return "AllPosts";
	}
	@RequestMapping("/delete/{post_id}")
	public String delete(@PathVariable("post_id") int id,Model m) {
		ts.deleteposts(id);
		return "redirect:/getallposts";
	}
	
}
