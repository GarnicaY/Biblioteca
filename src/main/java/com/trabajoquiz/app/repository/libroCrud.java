package com.trabajoquiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajoquiz.app.entity.Libro;

public interface libroCrud extends JpaRepository<Libro, Long>{

}
