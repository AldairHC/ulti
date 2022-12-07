package com.ultimatetech.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codProducto", length = 10)
	private Long codProducto;

	private String nombre;

	private Integer cantidad;

	private Double precio;

	@ManyToOne
    @JoinColumn(name = "idCategoria")
    private Categoria categoria;

	
}
