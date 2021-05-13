package com.dsp.theTipTop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dsp.theTipTop.services.LotService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TheTipTopApplication implements CommandLineRunner {

	@Value("${spring.datasource.username}")
	public String username;
	@Value("${spring.datasource.password}")
	public String password;
	@Autowired
	LotService lotService;
	
	public static void main(String[] args) {
		SpringApplication.run(TheTipTopApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println(this.username + password);
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------");
	}
	
	  @Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	       registry.addMapping("/**").allowedOrigins("**")
	                      .allowedMethods("PUT", "DELETE", "GET", "POST");
	      }
	    };
	  }

}
