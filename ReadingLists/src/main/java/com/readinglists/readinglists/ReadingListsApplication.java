package com.readinglists.readinglists;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.readinglists")
@SpringBootApplication
public class ReadingListsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingListsApplication.class, args);
	}

}
