package model;

import java.util.Objects;

public class TimeSlot {
    String start;
    String end;

    public TimeSlot(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeSlot slot = (TimeSlot) o;
        return Objects.equals(start, slot.start) && Objects.equals(end, slot.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
