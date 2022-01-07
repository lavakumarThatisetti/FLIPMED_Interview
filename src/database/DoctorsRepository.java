package database;

import exceptions.DoctorAlreadyPresentException;
import exceptions.DoctorNotPresentException;
import exceptions.NoSpecializationPresentException;
import exceptions.SlotException;
import model.AvailableDoctor;
import model.Doctor;
import model.Specialization;
import model.TimeSlot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorsRepository {
    Map<Integer, Doctor> doctors = new HashMap<>();
    Map<Specialization, List<Doctor>> doctorsForSpecialization = new HashMap<>();

    public void registerDoctor(Doctor doctor){
        if(doctors.containsKey(doctor.getDoctorId())){
            throw new DoctorAlreadyPresentException();
        }
        doctors.put(doctor.getDoctorId(), doctor);
        if(!doctorsForSpecialization.containsKey(doctor.getSpecialization())){
            doctorsForSpecialization.put(doctor.getSpecialization(), new ArrayList<>());
        }
        doctorsForSpecialization.get(doctor.getSpecialization()).add(doctor);
    }

    public void addAvailability(Integer doctorId, TimeSlot timeSlot){
        if(!doctors.containsKey(doctorId)){
            throw new DoctorNotPresentException();
        }
        Doctor doctor = doctors.get(doctorId);
        HashMap<TimeSlot, Boolean> slots = doctor.getSlots();
        slots.put(timeSlot,true);
        doctors.put(doctorId, doctor);
    }

    public List<Doctor> getDoctorsBySpeciality(Specialization specialization){
        if(!doctorsForSpecialization.containsKey(specialization)){
            throw new NoSpecializationPresentException();
        }
        return doctorsForSpecialization.get(specialization);
    }
    
    public List<AvailableDoctor> getAvailableTimeSlotsForAllDoctorsForSpecialization(List<Doctor> specializedDoctors) throws CloneNotSupportedException {
        List<AvailableDoctor> doctorsWithAvailableSlots = new ArrayList<>();
        for(Doctor doctor: specializedDoctors){
            AvailableDoctor availableDoctor = new AvailableDoctor();
            availableDoctor.setDoctor(doctor.clone());
            List<TimeSlot> aSlots = new ArrayList<>();
            HashMap<TimeSlot, Boolean> slots = doctor.getSlots();
            for(Map.Entry<TimeSlot, Boolean> entry: slots.entrySet()){
                if(entry.getValue()){
                    aSlots.add(entry.getKey());
                }
            }
            availableDoctor.setSlotList(aSlots);
            doctorsWithAvailableSlots.add(availableDoctor);
        }
        return doctorsWithAvailableSlots;
    }

    public boolean isDoctorRegistered(Integer doctorId){
        return doctors.containsKey(doctorId);
    }

    public Doctor getDoctorDetails(Integer doctorId){
        return doctors.get(doctorId);
    }

    public void freeSlot(Integer doctorId, TimeSlot timeSlot){
        Boolean put = doctors.get(doctorId).getSlots().put(timeSlot, true);
        if(put == null){
            doctors.get(doctorId).getSlots().remove(timeSlot);
            throw new SlotException("Slot Not found");
        }
    }

}
