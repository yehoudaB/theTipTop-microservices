package com.dsp.theTipTop;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		 .antMatcher("/**").authorizeRequests()
         .antMatchers(new String[]{"/", "/not-restricted"}).permitAll()
         .anyRequest().authenticated()
         .and().oauth2Login()
         .defaultSuccessUrl("/users/oauth2LoginSuccess")
         .and().formLogin() 
         .defaultSuccessUrl("/users/formLoginSuccess");
	}
	
	
}