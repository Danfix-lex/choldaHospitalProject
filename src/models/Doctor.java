package models;

import java.time.LocalDate;

public class Doctor extends User {
    private String specialization;
    private String doctorsId;


    public Doctor(String firstName, String lastName, String email, String phoneNumber, String address, String password,  String specialization) {
        super(firstName, lastName, email, phoneNumber, address, password);
        this.specialization = specialization;
        this.doctorsId = doctorsId;
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
}
