package com.ultimatetech.store.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "proveedor")
@Data
public class Proveedor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProvedor", length = 10)
    private Long idProvedor;

    @OneToOne
    private PersonaNatural dni;
	
    @OneToOne
    private PersonaJuridica ruc;
    
    @CreationTimestamp
	@Column(name = "fecha_registro", nullable = false, updatable = false)
	private LocalDateTime fecha_registro;
    
   
    
    
    
}
