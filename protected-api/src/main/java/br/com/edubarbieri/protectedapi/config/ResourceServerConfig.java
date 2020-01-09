package br.com.edubarbieri.protectedapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.anonymous().disable()
			.authorizeRequests()
			.antMatchers("/employee**").authenticated()
			.and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
	    RemoteTokenServices tokenService = new RemoteTokenServices();
	    tokenService.setCheckTokenEndpointUrl("http://localhost:8282/oauth/check_token");
	    tokenService.setClientId("webapp");
	    tokenService.setClientSecret("teste12");
	    return tokenService;
	}
	
//	@Override
//	public void configure(ResourceServerSecurityConfigurer config) throws Exception {
//		config.tokenServices(tokenServices());
//	}
//	
//	
//	@Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(accessTokenConverter());
//    }
// 
//    @Bean
//    public JwtAccessTokenConverter accessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setSigningKey("as466g");
//        return converter;
//    }
// 
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//        defaultTokenServices.setTokenStore(tokenStore());
//        return defaultTokenServices;
//    }
	
}
