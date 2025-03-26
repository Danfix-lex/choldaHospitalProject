package models;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import models.MedicalHistory;

public class  Patient extends User {
    private LocalDate dateOfBirth;
    private String patientsId;
    private List<MedicalHistory> medicalHistories = new ArrayList<>();


    public Patient(String firstName, String lastName, String email, String phoneNumber, String dateOfBirth, String address, String password) {
        super(firstName, lastName, email, phoneNumber, address, password);
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.patientsId = patientsId;
    }
    public  LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPatientsId() {
        return patientsId;
    }
    public  void setPatientsId(String patientsId) {
        this.patientsId = patientsId;
    }

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
        this.medicalHistories = medicalHistories;
    }
}
