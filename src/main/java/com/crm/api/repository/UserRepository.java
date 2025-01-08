package com.crm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.crm.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	UserDetails findByLogin(String login);
}
