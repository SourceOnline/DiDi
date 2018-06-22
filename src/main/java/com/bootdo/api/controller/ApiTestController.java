package com.bootdo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootdo.common.annotation.Log;

/**
 * @author geyy
 * @date 2018年6月7日 下午2:37:44
 */
@RestController
@RequestMapping("/api/test")
public class ApiTestController extends ApiBaseController{

	
	@Log("app测试tt")
	@GetMapping("/tt")
	public String tt(){
		return "tt back";
	}
}
