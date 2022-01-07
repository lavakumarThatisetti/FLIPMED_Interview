package model;

import java.util.HashMap;
import java.util.List;

public class Patient {
    Integer patientId;
    String patientName;
    HashMap<Doctor,List<TimeSlot>> bookedSlots;

    public Patient(Integer patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

    public HashMap<Doctor, List<TimeSlot>> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(HashMap<Doctor, List<TimeSlot>> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }
}
