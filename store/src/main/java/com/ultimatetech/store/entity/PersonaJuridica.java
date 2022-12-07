package com.ultimatetech.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PersonaJuridica {
	
	@Id
    @Column(name = "ruc", length = 10)
    private Long ruc;

    @Column(length = 50, nullable = true)
    private String nombre;
    
    @Column(length = 50, nullable = true)
    private String razon_social;
    
    @Column(length = 50, nullable = true)
    private String direccion;
    
    @Column(length = 50, nullable = true)
    private String telefono;
   
}
