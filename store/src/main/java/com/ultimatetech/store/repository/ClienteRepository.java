package com.ultimatetech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultimatetech.store.entity.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
