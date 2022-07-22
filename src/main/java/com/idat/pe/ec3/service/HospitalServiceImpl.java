package com.idat.pe.ec3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.idat.pe.ec3.dto.HospitalDTORequest;
import com.idat.pe.ec3.dto.HospitalDTOResponse;
import com.idat.pe.ec3.model.Hospital;
import com.idat.pe.ec3.repository.HospitalRepository;

public class HospitalServiceImpl implements HospitalService{
	
	@Autowired
	private HospitalRepository repository;

	@Override
	public void guardarHospital(HospitalDTORequest hospital) {
		
		Hospital p = new Hospital();
		p.setNombre(hospital.getNombreHospital());
		p.setDescripcion(hospital.getDescripcionHospital());
		p.setDistrito(hospital.getDistritoHospital());
		repository.save(p);
		
	}

	@Override
	public void actualizarHospital(HospitalDTORequest hospital) {
		
		Hospital p = new Hospital();
		p.setNombre(hospital.getNombreHospital());
		p.setDescripcion(hospital.getDescripcionHospital());
		p.setDistrito(hospital.getDistritoHospital());
		p.setIdHospital(hospital.getId());
		repository.saveAndFlush(p);
	}

	@Override
	public void eliminarHospital(Integer id) {
		
		repository.deleteById(id);
	}

	@Override
	public List<HospitalDTOResponse> listarHospital() {
		
		List<HospitalDTOResponse> listar = new ArrayList<>();
		
		HospitalDTOResponse dto = null;
		
		List<Hospital> p = repository.findAll();
		
		for (Hospital hospitales : p) {
			
			dto = new HospitalDTOResponse();
			
			dto.setNombreHospital(hospitales.getNombre());
			dto.setDescripcionHospital(hospitales.getDescripcion());
			dto.setDistritoHospital(hospitales.getDistrito());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public HospitalDTOResponse obtenerHospitalId(Integer id) {
		
		Hospital hospitales = repository.findById(id).orElse(null);
		HospitalDTOResponse dto = new HospitalDTOResponse();
		
		dto.setNombreHospital(hospitales.getNombre());
		dto.setDescripcionHospital(hospitales.getDescripcion());
		dto.setDistritoHospital(hospitales.getDistrito());
		dto.setId(hospitales.getIdHospital());
		
		return dto;
	}
	
	

}
