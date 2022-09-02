package com.api.opendata;

import com.api.opendata.dao.BoxOfficeDao;
import com.api.opendata.dao.BoxOfficeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OpendataApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpendataApplication.class, args);
	}

}

