package com.ultimatetech.store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PersonaNatural {

	@Id
    private Long dni;

    @Column(length = 15, nullable = true)
    private String primer_nombre;
    
    @Column(length = 15, nullable = true)
    private String segundo_nombre;
    
    @Column(length = 25, nullable = true)
    private String apellido_paterno;
    
    @Column(length = 25, nullable = true)
    private String apellido_materno;

    @Column(length = 50, nullable = true)
    private String direccion;
    
    @Column(length = 50, nullable = true)
    private String telefono;

	
	
}
