package models;

import java.time.LocalDateTime;

public class Appointment {
    private LocalDateTime appointmentTime;
    private Patient patient;
    private String doctorsId;
    private String description;

    public Appointment(LocalDateTime appointmentTime, Patient patient, String doctorsId, String description) {
        this.appointmentTime = appointmentTime;
        this.patient = patient;
        this.doctorsId = doctorsId;
        this.description = description;
    }

    public LocalDateTime getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDoctorsId() {
        return doctorsId;
    }

    public void setDoctorsId(String doctorsId) {
        this.doctorsId = doctorsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
