package model;

import java.util.List;

public class AvailableDoctor {
    Doctor doctor;
    List<TimeSlot> slotList;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<TimeSlot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<TimeSlot> slotList) {
        this.slotList = slotList;
    }
}
