package com.trabajoquiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajoquiz.app.entity.User;

public interface userCrud extends JpaRepository<User, Long>{

}

