package com.mycontroller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.entities.AccountClient;
import com.model.DaoImpl;

@Controller
public class AddController {
	
	
	@RequestMapping(value = "/login")
	public ModelAndView home(HttpServletRequest request , HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView();
		String u = request.getParameter("t1");
		String p = request.getParameter("t2");
		
		if(new DaoImpl().checkLogin(u, p))
		{
			mv.setViewName("display.jsp");
		}
		
		else
		{
			mv.setViewName("index.jsp");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/signUp")
	public String SignUp(HttpServletRequest request) {
		AccountClient acc = new AccountClient();
		acc.setEmail(request.getParameter("e1"));
		acc.setUser(request.getParameter("u1"));
		acc.setPass(request.getParameter("p1"));	
		
		if(new DaoImpl().addAccount(acc)) 
		{
			return "index.jsp";
		}
		else 
		{
			return "singUp.jsp";
		}
			
		
	}
	
	
	
}
