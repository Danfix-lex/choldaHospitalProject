package services;

import models.Doctor;
import models.MedicalHistory;
import models.User;
import exception.DuplicateEmailException;
import exception.InvalidCredentialsException;

import java.util.ArrayList;
import java.util.List;

public class DoctorsService {
    private List<Doctor> doctors;
    private int id = 1000;

    public DoctorsService() {
        doctors = new ArrayList<>();
    }

    public int getDoctorSize() {
        return doctors.size();
    }

    public void registerUser(User user) {
        if (isEmailTaken(user.getEmail())) {
            throw new DuplicateEmailException("User's email already exists!");
        }
         if (user instanceof Doctor newDoctor) {
            String newId = "DOC" + id;
            newDoctor.setDoctorsId(newId);
            doctors.add(newDoctor);
            this.id ++;
        }
    }

    private boolean isEmailTaken(String email) {
        return doctors.stream().anyMatch(doctor -> doctor.getEmail().equals(email));
    }

    public User loginUser(String email, String password) {
        for (Doctor doctor : doctors) {
            if (doctor.getEmail().equals(email) && doctor.getPassword().equals(password)) {
                return doctor;
            }
        }
        throw new InvalidCredentialsException("Invalid credentials!");
    }

    public List<MedicalHistory> getMedicalHistories(String doctorsId) {
        List<MedicalHistory> medicalHistories = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorsId().equals(doctorsId)) {
                return medicalHistories;
            }
        }
        throw new InvalidCredentialsException("Invalid credentials!");
    }

    public List <Doctor> getDoctors() {
        return doctors;
    }
    public Doctor findDoctorById(String doctorsId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorsId().equals(doctorsId)) {
                return doctor;
            }
        }
       return null;
    }

    public String toString(){
        return doctors.toString();
    }

}
