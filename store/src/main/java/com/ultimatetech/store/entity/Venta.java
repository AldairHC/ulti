package com.ultimatetech.store.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Venta {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codVenta", length = 10)
    private Long codVenta;
	
	@CreationTimestamp
	@Column(name = "fecha", nullable = false, updatable = false)
	private LocalDateTime fecha;
	
	private int cantidad;
	
	private int igv;
	
	private double total;
	
    @OneToOne
    private Cliente cliente;
    
    @OneToOne
    private Empleado empleado;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codProducto")
    private Producto producto;
        
}
