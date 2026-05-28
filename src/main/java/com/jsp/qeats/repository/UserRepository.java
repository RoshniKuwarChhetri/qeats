package com.jsp.qeats.repository;

import com.jsp.qeats.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}