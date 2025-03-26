package services;

import models.Doctor;
import models.User;
import exception.InvalidCredentialsException;
import models.Patient;
import interfaces.UserInterface;
import exception.DuplicateEmailException;

import java.util.ArrayList;
import java.util.List;

public class UsersService implements UserInterface {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private int id = 1000;

    public UsersService() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();

    }
    public boolean isEmailTaken(String email) {
        return patients.stream().anyMatch(p -> p.getEmail().equals(email)) ||
                doctors.stream().anyMatch(d -> d.getEmail().equals(email));
    }


    @Override
    public void registerUser(User user) {
        if (isEmailTaken(user.getEmail())) {
            throw new DuplicateEmailException("User's email already exists!");
        }

        if (user instanceof Patient newPatient) {
            String newId = "PAT" + id;
            newPatient.setPatientsId(newId);
            patients.add(newPatient);
            this.id ++;
        }
        else if (user instanceof Doctor newDoctor) {
            String newId = "DOC" + id;
            newDoctor.setDoctorsId(newId);
            doctors.add(newDoctor);
            this.id ++;
        }


    }





    @Override
    public void updateProfile() {

    }

    @Override
    public void viewAppointment() {

    }





    @Override
    public void viewUserProfile() {

    }

    @Override
    public void viewAvailableUsers() {

    }

    @Override
    public void updateMedicalHistory() {

    }

    @Override
    public void viewMedicalHistory() {

    }



    public int getUserSize(String userType) {
        if ("patient".equalsIgnoreCase(userType)) {
            return patients.size();
        } else if ("doctor".equalsIgnoreCase(userType)) {
            return doctors.size();
        }
        else return 0;
    }

    public User loginUser(String email, String password) {
        for (Patient myPatient : patients) {
            if (myPatient.getEmail().equals(email) && myPatient.getPassword().equals(password)) {
                return myPatient;
            }

        }
        for (Doctor myDoctor : doctors) {
            if (myDoctor.getEmail().equals(email) && myDoctor.getPassword().equals(password)) {
                return myDoctor;
            }
        }
        throw new InvalidCredentialsException("Invalid credentials!");
    }
}


