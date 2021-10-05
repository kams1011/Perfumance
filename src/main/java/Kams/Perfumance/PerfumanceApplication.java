package Kams
		.Perfumance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan(basePackageClasses = PerfumanceApplication.class)
@SpringBootApplication
@MapperScan(value= {"Kams.Perfumance.mapper"})
public class PerfumanceApplication {


	public static void main(String[] args) {
		SpringApplication.run(PerfumanceApplication.class, args);
	}

}

