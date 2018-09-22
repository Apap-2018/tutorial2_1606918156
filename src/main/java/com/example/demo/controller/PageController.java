package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String index(@RequestParam(value = "a", required = false, defaultValue = "0")String a, @RequestParam(value = "b", required = false, defaultValue = "0")String b, Model model) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);	
		String result = "hm";
		if (num2 != 0) {
			String temp = "";
			for(int i = 0 ; i < num2 ; i++ ) {
				temp += " hm";
				for(int j = 1 ; j < num1 ; j++) {
					temp += "m";
				}
			}
			model.addAttribute("result",temp);
		} else {		
			if (num1 == 0) {
				model.addAttribute("result",result);
			} else {
				for (int i = 1 ; i < num1 ; i++) {
					result += "m";
				}
				model.addAttribute("result",result);
			}
		}
		model.addAttribute("a", num1); //mengirim a ke html
		model.addAttribute("b", num2); //mengirim b ke html
		return "generator";
	}
}

