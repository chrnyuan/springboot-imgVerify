package com.xxx.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * springboot由于默认扫描包机制，application启动时，会默认扫描同一包，或其子包的类
 * @author ZYK
 * 2019年8月6日 下午1:18:20
 * Desc:
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
