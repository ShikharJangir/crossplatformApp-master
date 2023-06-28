package com.example.project;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserDetailRepository userDetailRepository;
  @GetMapping("/login")
    public String getLandingPage(){
      return "landingpage";
  }

  @PostMapping("/signup")
  public String signup(@RequestParam String username, HttpServletRequest request, @RequestParam String password, Model model){
    UserEntity saveduser = new UserEntity(username, password);
    HttpSession session = request.getSession();
    session.setAttribute("username",username);
    model.addAttribute("username" , session.getAttribute("username"));
    userRepository.save(saveduser);
    return "dashboard";
  }
  @PostMapping("/register")
  public void register(@RequestParam String usertype,@RequestParam String username, @RequestParam String fname,@RequestParam String lname, @RequestParam String phone){
    UserDetailEntity saveduser = new UserDetailEntity(usertype,username,fname,lname,phone);
    userDetailRepository.save(saveduser);
    if(saveduser.getUsertype()=="Buyer"){
         return "buyerdashboard";
    }
    else if(saveduser.getUsertype()=="seller"){
      return "sellerdashboard";
    }

  }


}
