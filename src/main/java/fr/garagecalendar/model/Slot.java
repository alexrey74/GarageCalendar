package fr.garagecalendar.model;


import java.time.LocalDate;

public class Slot {
    LocalDate date;
    Double start;
    Double duration;

    public Slot(LocalDate date, Double start, Double duration){
        setDate(date);
        setStart(start);
        setDuration(duration);
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) { this.date = date; }

    public Double getStart() {
        return start;
    }

    public void setStart(Double start) {
        this.start = start;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
