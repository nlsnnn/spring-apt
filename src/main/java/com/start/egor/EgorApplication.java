package com.start.egor;

import com.start.egor.dbexample.dao.BookDAOBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EgorApplication implements CommandLineRunner {

	private BookDAOBean bookDAOBean;

	public EgorApplication(BookDAOBean bookDAOBean){
		this.bookDAOBean = bookDAOBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(EgorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		bookDAOBean.findBookById(3);
	}

}
