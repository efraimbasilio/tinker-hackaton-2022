package com.example.mycrud;

import com.example.mycrud.model.Todo;
import com.example.mycrud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class MycrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MycrudApplication.class, args);
	}

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
