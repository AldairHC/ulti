package com.ultimatetech.store.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Empleado {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codEmpleado;

    @OneToOne
    private PersonaNatural dni;
    
    private String cargo;
    
    private Double sueldo;

    @CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "update_at")
	private LocalDateTime updateAt;
}
