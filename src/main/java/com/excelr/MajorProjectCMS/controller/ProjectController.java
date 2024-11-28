package com.excelr.MajorProjectCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProjectController {

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
}
