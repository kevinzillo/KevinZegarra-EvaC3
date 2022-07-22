package com.idat.pe.ec3.service;

import java.util.List;

import com.idat.pe.ec3.dto.HospitalDTORequest;
import com.idat.pe.ec3.dto.HospitalDTOResponse;

public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest hospital);
	void actualizarHospital(HospitalDTORequest hospital);
	void eliminarHospital(Integer id);
	List<HospitalDTOResponse> listarHospital();
	HospitalDTOResponse obtenerHospitalId(Integer id);

}
