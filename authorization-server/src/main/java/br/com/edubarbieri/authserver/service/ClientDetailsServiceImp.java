package br.com.edubarbieri.authserver.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

public class ClientDetailsServiceImp implements ClientDetailsService {

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		// TODO Auto-generated method stub
		return null;
	}

}
