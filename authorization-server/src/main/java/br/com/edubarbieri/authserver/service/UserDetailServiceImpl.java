package br.com.edubarbieri.authserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edubarbieri.authserver.model.AuthUserDetails;
import br.com.edubarbieri.authserver.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Bean
	public AccountStatusUserDetailsChecker accountStatusUserDetailsChecker() {
		return new AccountStatusUserDetailsChecker();
	}

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user = userRepository.findByUsername(username);
		if (user.isEmpty()) {
			throw new UsernameNotFoundException("Not found user with username " + username);
		}
		var userDetails = new AuthUserDetails(user.get());
		accountStatusUserDetailsChecker().check(userDetails);
		return userDetails;
	}

}
