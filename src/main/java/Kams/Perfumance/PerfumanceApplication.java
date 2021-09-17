package Kams
		.Perfumance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackageClasses = PerfumanceApplication.class)

public class PerfumanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfumanceApplication.class, args);
	}

}

