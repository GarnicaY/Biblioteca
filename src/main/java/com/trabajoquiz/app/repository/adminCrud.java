package com.trabajoquiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajoquiz.app.entity.Admin;

public interface adminCrud extends JpaRepository<Admin, Long>{

}
