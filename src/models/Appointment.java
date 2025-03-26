package models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Appointment {
    private static final DateTimeFormatter APPOINTMENT_FORMATTER =
            new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("dd-MM-yyyy h:mm a")
                    .toFormatter(Locale.ENGLISH);

    private LocalDateTime appointmentTime;
    private Patient patient;
    private String doctorsId;
    private String description;

    public Appointment(String appointmentDateTime, Patient patient, String doctorsId, String description) {
        this.appointmentTime = LocalDateTime.parse(appointmentDateTime, APPOINTMENT_FORMATTER);
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
