package com.retail.pos.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@ComponentScan("com.retail.pos")
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/p/*").permitAll()

				// CORE BANK MOCK URLS
				.antMatchers(HttpMethod.GET, "/validate/*/*/*").permitAll().antMatchers(HttpMethod.POST, "/actcreate")
				.permitAll().antMatchers(HttpMethod.GET, "/accbalance/*/*").permitAll()
				.antMatchers(HttpMethod.POST, "/fundtrf").permitAll()

				.antMatchers(HttpMethod.POST, "/api/v1.0/users").permitAll()
				.antMatchers(HttpMethod.POST, "/api/v1.0/passwords").permitAll()

				.antMatchers(HttpMethod.GET, "/api/v1.0/fund/transferstr").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1.0/account/validatestr").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1.0/account/balancestr").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1.0/account/createstr").permitAll()
				.antMatchers(HttpMethod.GET, "/api/v1.0/server").permitAll()

				.anyRequest().authenticated().and().authorizeRequests();

		http.headers().addHeaderWriter((request, response) -> {

			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
			response.setHeader("Access-Control-Max-Age", "3600");
			response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
			response.addHeader("Access-Control-Expose-Headers", "xsrf-token");

			if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
				response.setStatus(200);
				return;
			}

		});

	}

}
