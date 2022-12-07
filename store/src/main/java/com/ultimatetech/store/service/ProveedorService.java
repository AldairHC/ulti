package com.ultimatetech.store.service;

import java.util.ArrayList;
import java.util.Optional;
import com.ultimatetech.store.entity.Proveedor;

public interface ProveedorService {
	ArrayList<Proveedor>ListarProveedor();
	Optional<Proveedor>ProveedorById(long id);
	Proveedor GuardarProveedor(Proveedor proveedor);
	boolean EliminarProveedorById(long id);
}
