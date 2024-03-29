package com.example.demo;

import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudStaffApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudStaffApplication.class, args);
	}
    @Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {

	}
}
