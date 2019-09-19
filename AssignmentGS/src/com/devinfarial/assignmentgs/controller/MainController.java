package com.devinfarial.assignmentgs.controller;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.devinfarial.assignmentgs.dao.UserDAO;
import com.devinfarial.assignmentgs.dao.UserDAOImpl;
import com.devinfarial.assignmentgs.model.User;

@Controller
public class MainController {
	
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/admin")
	public ModelAndView adminScreen(ModelAndView model, HttpSession session) {
		if(session.getAttribute("Role").toString().contains("Admin")) {
			List<User> listUser = userDAO.list();
			model.addObject("listUser", listUser);
			model.setViewName("admin_page");
			
			return model;
		}else {
			return new ModelAndView("redirect:/"); 
		}
		
	}
	
	@RequestMapping(value="/staff")
	public ModelAndView staffScreen(ModelAndView model, HttpSession session) {
		if(session.getAttribute("Role")!=null) {
			Integer id = (Integer) session.getAttribute("Id");
			List<User> listUser = userDAO.list();
			model.addObject("listUser", listUser);
			model.addObject("Id", id);
			model.setViewName("staff_page");
			
			return model;
		}else {
			return new ModelAndView("redirect:/"); 
		}
		
	}
	
	@RequestMapping(value="/new", method= RequestMethod.GET)
	public ModelAndView newUser(ModelAndView model) {
		User newUser = new User();
		model.addObject("user", newUser);
		model.setViewName("admin_form");
		
		return model;
	}
	
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user, HttpSession session) {
		if(user.getId() == null ) {
			userDAO.save(user);
		}else {
			userDAO.update(user);
		}
		
		if(session.getAttribute("Role").equals("Admin")) {
			return new ModelAndView("redirect:/admin");
		}
		else {
			return new ModelAndView("redirect:/staff");
		}
	}
	
	@RequestMapping(value="/edit", method= RequestMethod.GET)
	public ModelAndView editUser(HttpServletRequest request, HttpSession session) {
		
		if(session.getAttribute("Role").toString().contains("Admin")) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			User user = userDAO.get(id);
			ModelAndView model = new ModelAndView("admin_form");
			model.addObject("user", user);
		
			return model;
		}else {
			Integer id = Integer.parseInt(request.getParameter("id"));
			User user = userDAO.get(id);
			ModelAndView model = new ModelAndView("staff_form");
			model.addObject("user", user);
			
			return model;
		}
		
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		userDAO.delete(id);
		
		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView loginUser(@ModelAttribute User user, ModelAndView model) {
		model.setViewName("login");
		
		return model;
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public ModelAndView processLogin(@ModelAttribute User user, ModelAndView model, HttpServletRequest request, HttpSession session ) {

		if(userDAO.validateUser(user)==null) {
			request.setAttribute("message", "Invalid username/password");
			return model;
		} else {
			String role = userDAO.validateUser(user).getRole();
			Integer id = userDAO.validateUser(user).getId();
			System.out.println(id);
			if(role.contains("Admin")) {
				session.setAttribute("Role", role);
				session.setAttribute("Id", id);
				return new ModelAndView("redirect:/admin");
			}else {
				session.setAttribute("Role", role);
				session.setAttribute("Id", id);
				return new ModelAndView("redirect:/staff");
			}

		}
		
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/");
	}

}
