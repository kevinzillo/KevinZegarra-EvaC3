package com.idat.pe.ec3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.ec3.dto.ClienteDTORequest;
import com.idat.pe.ec3.dto.ClienteDTOResponse;
import com.idat.pe.ec3.model.Cliente;
import com.idat.pe.ec3.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public void guardarCliente(ClienteDTORequest cliente) {
		
		Cliente p = new Cliente();
		p.setNombre(cliente.getNombreCliente());
		p.setCelular(cliente.getCelularCliente());
		repository.save(p);
	}

	@Override
	public void actualizarCliente(ClienteDTORequest cliente) {
		Cliente p = new Cliente();
		p.setNombre(cliente.getNombreCliente());
		p.setCelular(cliente.getCelularCliente());
		p.setIdCliente(cliente.getId());
		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarCliente(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<ClienteDTOResponse> listarCliente() {
		List<ClienteDTOResponse> listar = new ArrayList<>();
		
		ClienteDTOResponse dto = null;
		
		List<Cliente> p = repository.findAll();
		
		for (Cliente clientes : p) {
			
			dto = new ClienteDTOResponse();
			
			dto.setNombreCliente(clientes.getNombre());
			dto.setCelularCliente(clientes.getCelular());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ClienteDTOResponse obtenerClienteId(Integer id) {
		
		Cliente clientes = repository.findById(id).orElse(null);
		ClienteDTOResponse dto = new ClienteDTOResponse();
		
		dto.setNombreCliente(clientes.getNombre());
		dto.setCelularCliente(clientes.getCelular());
		dto.setId(clientes.getIdCliente());
		
		return dto;
	}

	

}
