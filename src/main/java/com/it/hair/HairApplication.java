package com.it.hair;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.it.hair.mapper")
@ServletComponentScan
public class HairApplication {

	public static void main(String[] args) {
		SpringApplication.run(HairApplication.class, args);
	}

}
