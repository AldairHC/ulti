package com.ultimatetech.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ultimatetech.store.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
