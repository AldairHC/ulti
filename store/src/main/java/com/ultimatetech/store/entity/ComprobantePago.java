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
import lombok.Data;

@Entity
@Data
public class ComprobantePago {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codComprobante;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "codVenta")
	private Venta venta;
	
	private String tipo_comprobante;
	
	private String serie_comprobante;
	
	private String numero_comprobante;
	
	@CreationTimestamp
	@Column(name = "fecha", nullable = false, updatable = false)
	private LocalDateTime fecha;
}
