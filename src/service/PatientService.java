package service;

import Mode.Print;
import database.PatientsRepository;
import model.*;
public class PatientService {
    PatientsRepository patientsRepository;
    Print print;

    public PatientService(Print print, PatientsRepository patientsRepository){
        this.print = print;
        this.patientsRepository = patientsRepository;
    }

    public void registerPatient(Patient patient){
        patientsRepository.registerPatient(patient);
        print.printData(patient.getPatientName()+ " registered successfully.");
    }
}
