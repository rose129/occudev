package com.occu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
		
		// landing & login
		@RequestMapping("/")
		public String occuMain() {
			System.out.println("occu main");
			return "main/landing";
		}
		
		
}
