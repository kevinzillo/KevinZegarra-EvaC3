package com.idat.pe.ec3.service;

import java.util.List;

import com.idat.pe.ec3.dto.ClienteDTORequest;
import com.idat.pe.ec3.dto.ClienteDTOResponse;


public interface ClienteService {
	
	void guardarCliente(ClienteDTORequest cliente);
	void actualizarCliente(ClienteDTORequest cliente);
	void eliminarCliente(Integer id);
	List<ClienteDTOResponse> listarCliente();
	ClienteDTOResponse obtenerClienteId(Integer id);

}
