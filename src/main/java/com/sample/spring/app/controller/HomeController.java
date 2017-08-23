package com.sample.spring.app.controller;

import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.spring.app.entity.dto.UserDto;

@Controller
public class HomeController {

	private static final String WELLCOME_PAGE = "wellcome";

	@RequestMapping("/index.*")
	public String wellcome() {
		return WELLCOME_PAGE;
	}

	// data return string/json
	@RequestMapping("/hello/rest")
	public @ResponseBody String sampleRest() {
		return "hello";

	}

	// data return string/json (su dung request body convert)
	@RequestMapping(path= "/hello/rest/param",
			method = RequestMethod.POST,produces="application/json",consumes ="application/json")
	public @ResponseBody String sampleRestJsonData(@RequestBody UserDto dto) {
		return "{\"user\": \"" + dto.getUserName()+"\"";
	}
	// data return string/json (su dung request body convert)
	@RequestMapping("/hello/rest/pathVariable/{id}/{code}")
	public @ResponseBody String sampleRestJsonData(@PathVariable("id")Integer id, @PathVariable("code") String code) {
		return "id: " + id + ", code: "+ code;
	}
}
