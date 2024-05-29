package com.trabajoquiz.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabajoquiz.app.entity.Solicitud;

public interface solicitudCrud extends JpaRepository<Solicitud, Long>{

}

