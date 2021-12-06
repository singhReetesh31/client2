package com.axis.vaccinationcenter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.axis.vaccinationcenter.entity.VaccinationCenter;

public interface IVaccinationCenterDao extends JpaRepository<VaccinationCenter, Integer>{

}
