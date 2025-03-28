package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
    private String specialization;
    private String doctorsId;
    private List<MedicalHistory> medicalHistories;
    private List<Appointment> appointments;

    public Doctor(String firstName, String lastName, String email, String phoneNumber, String address, String password,  String specialization) {
        super(firstName, lastName, email, phoneNumber, address, password);
        this.specialization = specialization;
        this.doctorsId = doctorsId;
        this.medicalHistories = new ArrayList<>();
        this.appointments = new ArrayList<>();

    }
    public  String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(LocalDate dateOfBirth) {
        this.specialization = specialization;
    }
    public String getDoctorsId() {
        return doctorsId;
    }
    public void setDoctorsId(String doctorsId) {
        this.doctorsId = doctorsId;
    }

    public void addMedicalHistory(String description, boolean treatmentStatus, boolean medicalHistoryStatus) {
        MedicalHistory history = new MedicalHistory(description, treatmentStatus, medicalHistoryStatus);
        medicalHistories.add(history);
    }

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

}
