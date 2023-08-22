package com.oss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oss.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
