package database;

import exceptions.PatientNotPresentException;
import model.Patient;
import model.TimeSlot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientsRepository {
    Map<Integer, Patient> patients = new HashMap<>();

    public void registerPatient(Patient patient){
        if(patients.containsKey(patient.getPatientId())){
            throw new PatientNotPresentException();
        }
        patients.put(patient.getPatientId(), patient);
    }

    public boolean isPatientRegistered(Integer patientId){
        return patients.containsKey(patientId);
    }

}
