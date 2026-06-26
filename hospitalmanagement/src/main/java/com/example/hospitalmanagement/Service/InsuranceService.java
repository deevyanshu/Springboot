package com.example.hospitalmanagement.Service;

import org.springframework.stereotype.Service;

import com.example.hospitalmanagement.Entity.Insurance;
import com.example.hospitalmanagement.Entity.Patient;
import com.example.hospitalmanagement.Repository.InsuranceRepository;
import com.example.hospitalmanagement.Repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void assignInsuranceToPatient(Insurance insurance,Long patientId)
    {
        Patient patient=patientRepository.findById(patientId).get();
        patient.setInsurance(insurance);
        insurance.setPatient(patient); //not needed because patient is owning entity, but using for bidirectional maintainance 
    }

    @Transactional
    public void disassociateInsuranceFromPatient(Long patientId)
    {
        Patient patient=patientRepository.findById(patientId).get();
        patient.setInsurance(null);
    }
}
