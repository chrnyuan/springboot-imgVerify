package com.xxx.application.controller;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author ZYK
 * 2019年8月6日 下午5:11:53
 * Desc:
 */
@Controller
public class WeatherController {
	
	/**
	 * 
	 * @param cityId
	 * @param province
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/weather")
	public Object getWeather(String city) throws Exception{
		//拼地址
//		String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s","北京");
		String apiUrl = "http://t.weather.sojson.com/api/weather/city/101030100";
		//开始请求
		URL url = new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = open.getInputStream();
		//这里转换为String，带上包名，怕你们引错包
		String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
		System.out.println(result);
		//输出
		return result;
	}
}
