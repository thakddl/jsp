package com.spring.redirect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "/a")
	public String a(RedirectAttributes rttr) {
		String url = "redirect:receive";
		
		//rttr.addAttribute("name", "kim");
		//rttr.addAttribute("message", "good day!");
		
		rttr.addFlashAttribute("name", "kim");
		rttr.addFlashAttribute("message", "good day!");
		
		return url;
	}

	@RequestMapping(value = "/receive")
	public void receive() {//String name, Model model
		//model.addAttribute("name", name);
	}
	
}