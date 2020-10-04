package com.example.first_project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    
    @RequestMapping("home")
    public String Home(HttpServletRequest req)
    {
        String name=req.getParameter("name");
        System.out.println("Home Execute"+name);
        return "home";
    }

    @RequestMapping("param1")
    @ResponseBody
    public String Param1(HttpServletRequest req)
    {
        return req.getParameter("name");
    }

    @RequestMapping("param2")
    @ResponseBody
    public String Param2(@RequestParam("name") String name,HttpSession session)
    {
        //Bos Data to jsp view
        session.setAttribute("name", name);
        return name;
    }

    @RequestMapping("param3")
    public ModelAndView Param3(@RequestParam("name") String name)
    {
        System.out.println("-------Model and view---------");
        ModelAndView mv=new ModelAndView();
        mv.addObject("name", name);
        mv.setViewName("home");
        return mv;
    }
}
