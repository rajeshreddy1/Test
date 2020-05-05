package com.rajesh.microservices.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajesh.microservices.jpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByRole(String role);
}
