package com.mindful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.mindful.mapper.TestMapper;

@SpringBootApplication
@MapperScan("com.mindful.mapper") // 確保 MyBatis 掃描到 Mapper
public class MindfulApplication implements CommandLineRunner {
	@Autowired
	private TestMapper testMapper;

	public static void main(String[] args) {
		SpringApplication.run(MindfulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int result = testMapper.testConnection();
		System.out.println("Database connection test result: " + result);
	}
}