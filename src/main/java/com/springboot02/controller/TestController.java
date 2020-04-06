package com.springboot02.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot02.utils.HttpUtil;

@RestController
public class TestController {
	private static final String APP_ID = "wxe674524b28a7fe7d";
	private static final String SECRET = "b8b7922b58fad75d909b9a08ef5bd082";
	
	@RequestMapping("/hello")
	public String hello() {
	 	return "hello springboot!";
	}
	
	@RequestMapping(value = "/getWxLoginInfo", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public Object getWxLoginInfo(@RequestParam("code") String code) {
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + APP_ID
				+ "&secret=" + SECRET
				+ "&js_code=" + code
				+ "&grant_type=authorization_code";
		//发送请求获取结果
		String res = null;
		Map<String, String> headers = new HashMap<>();
		//headers.put("Content-Type", "application/json;charset=utf-8");
		try {
			res = HttpUtil.get(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}

}
