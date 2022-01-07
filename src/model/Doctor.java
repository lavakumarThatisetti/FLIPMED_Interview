package model;

import java.util.HashMap;

public class Doctor  implements Cloneable{
    Integer doctorId;
    String doctorName;
    HashMap<TimeSlot, Boolean> slots;
    Specialization specialization;
    Integer rating;

    public Doctor(Integer doctorId, String doctorName, HashMap<TimeSlot, Boolean> slots, Specialization specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.slots = slots;
        this.specialization = specialization;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public HashMap<TimeSlot, Boolean> getSlots() {
        return slots;
    }

    public void setSlots(HashMap<TimeSlot, Boolean> slots) {
        this.slots = slots;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Doctor clone() throws CloneNotSupportedException{
        return (Doctor) super.clone();
    }
}
