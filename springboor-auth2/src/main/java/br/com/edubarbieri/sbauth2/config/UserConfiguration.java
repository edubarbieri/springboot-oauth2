package br.com.edubarbieri.sbauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("eduardo").password(passwordEncoder.encode("teste12")).roles("ADMIN", "USER", "MANAGER").authorities("CAN_READ", "CAN_WRITE", "CAN_DELETE")
			.and()
			.withUser("luana").password(passwordEncoder.encode("teste12")).roles("USER").authorities("CAN_READ", "CAN_WRITE");
	}
}
