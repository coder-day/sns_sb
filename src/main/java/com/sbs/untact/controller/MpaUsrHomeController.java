package com.sbs.untact.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MpaUsrHomeController {
	@RequestMapping("mpaUsr/home/main")
	@ResponseBody
	public String showmain() {
		return "안녕";
	}
	
	@RequestMapping("mpaUsr/home/main2")
	@ResponseBody
	public String showmain2() {
		return "잘가";
	}
	
	@RequestMapping("mpaUsr/home/main3")
	@ResponseBody
	public int showmain3(int a, int b) {
		return a + b;
	}

	@RequestMapping("mpaUsr/home/main4")
	@ResponseBody
	public int showmain4(int a, int b) {
		return a - b;
	}

	@RequestMapping("mpaUsr/home/main5")
	@ResponseBody
	public String showmain5() {
		return "-20";
	}
	
	@RequestMapping("mpaUsr/home/main6")
	@ResponseBody
	public boolean showmain6() {
		return 1 > 2;
	}
	
	@RequestMapping("mpaUsr/home/main7")
	@ResponseBody
	public int[] showmain7() {
		int[] arr = new int[] {1,2,3};
		return arr;
	}

	
}
