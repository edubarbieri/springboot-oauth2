package br.com.edubarbieri.authserver.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.edubarbieri.authserver.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String login);
}
