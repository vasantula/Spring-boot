package com.softvision.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softvision.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
