package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.domain.User;
import com.web.service.JoinService;


@Controller
public class JoinController {
	@Autowired
	private JoinService service;
	 
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String index() {
		return "join";
	}
	 

	@PostMapping("/join")
	public String joinOk(User user, RedirectAttributes rttr) throws Exception{
		service.join(user);
		return "redirect:/login";
	}
	
    @GetMapping("/checkDuplicateId")
    public String checkDuplicateId(@RequestParam("id") String id) {
    	boolean isDuplicate = service.isIdDuplicated(id);
        return isDuplicate ? "true" : "false";
    }
	
}