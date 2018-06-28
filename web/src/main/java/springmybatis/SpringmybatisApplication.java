package springmybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringmybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmybatisApplication.class, args);
	}
}
