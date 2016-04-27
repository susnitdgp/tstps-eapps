package com.ntpc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
         .antMatchers("/css/**").permitAll();
		 http.authorizeRequests()
         .antMatchers("/js/**").permitAll();
		 http.authorizeRequests()
         .antMatchers("/fonts/**").permitAll();
		
		
		
		 http.authorizeRequests().anyRequest().authenticated();
		 
		
		 http
         .formLogin().failureUrl("/login?error")
         .defaultSuccessUrl("/home")
         .loginPage("/login")
         .permitAll()
         .and()
         .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
         .permitAll();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("GOSWAMI");
    }
	

}
