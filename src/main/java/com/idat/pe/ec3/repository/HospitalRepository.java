package com.idat.pe.ec3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.ec3.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Integer>{

}
