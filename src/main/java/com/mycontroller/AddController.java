package com.mycontroller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.DaoImpl;

@Controller
public class AddController {
	
	@RequestMapping("/login")
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
}
