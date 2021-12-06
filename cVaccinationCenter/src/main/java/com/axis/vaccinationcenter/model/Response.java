package com.axis.vaccinationcenter.model;

import java.util.List;

import com.axis.vaccinationcenter.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
private VaccinationCenter center;
private List<Citizen> citizens;
}
