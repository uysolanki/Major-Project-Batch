package com.excelr.MajorProjectCMS.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("aaa")
//		.password("aaa") // cleartext
//		.authorities("ADMIN")  //CRUD
//		.and()
//		.withUser("bbb")
//		.password("bbb") // cleartext
//		.authorities("ADMIN")  //CR
//		.and()
//		.withUser("yyy")
//		.password("yyy") // cleartext
//		.authorities("USER")
//		.and()
//		.withUser("zzz")
//		.password("zzz") // cleartext  Encrption $2ae12ey17ccc6786dasajdfasyd78asd6
//		.authorities("USER");
		
		auth.authenticationProvider(myAuthenticationProvider());
	}

@Bean	
public AuthenticationProvider myAuthenticationProvider() {
	DaoAuthenticationProvider daoAuthentication=new DaoAuthenticationProvider();
	daoAuthentication.setUserDetailsService(myUserDetailsService());
	daoAuthentication.setPasswordEncoder(myPasswordEncoder());
	return daoAuthentication;
}

@Bean
public PasswordEncoder myPasswordEncoder() {
	return new BCryptPasswordEncoder();
}

@Bean
public UserDetailsService myUserDetailsService() {
	return new CMSUserDetailsService();
}

//Authorisation
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/","/customerHome","/newCustomer","/productHome","/newProduct").hasAnyAuthority("USER","ADMIN")
        .antMatchers("/updatecustomerform/**","/deleteCustomer/**","/updateproductform/**","/deleteProduct/**").hasAuthority("ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin().loginProcessingUrl("/login").successForwardUrl("/").permitAll()
        .and()
        .logout().logoutSuccessUrl("/login").permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/403")
        .and()
        .cors().and().csrf().disable();


	}
	
//	@Bean
// 	public PasswordEncoder getPasswordEncoder()
// 	{
// 		return NoOpPasswordEncoder.getInstance();
// 	}


}
