package br.com.edza.cjus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
@SpringBootApplication
public class CjusApplication {

	public static void main(String[] args) {
		System.getProperties().put("javax.xml.stream.XMLInputFactory", "br.com.edza.cjus.conf.InputFactory");    
		SpringApplication.run(CjusApplication.class, args);
	}

}
