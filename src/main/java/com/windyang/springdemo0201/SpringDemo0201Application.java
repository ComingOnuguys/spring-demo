package com.windyang.springdemo0201;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

/**
 * @author windyang
 */
@Slf4j
@SpringBootApplication
public class SpringDemo0201Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDemo0201Application.class, args);
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println("beanDefinitionNames = " + Arrays.toString(beanDefinitionNames));
	}

}
