package services;

import exception.*;
import models.Appointment;
import models.Doctor;
import models.User;
import models.Patient;
import interfaces.PatientsActivities;

import java.util.ArrayList;
import java.util.List;

public class PatientsService implements PatientsActivities {

    private List<Patient> patients;
    private int id = 1000;
    private DoctorsService doctorsService;
    private List<Appointment> appointments;



    public PatientsService(DoctorsService doctorsService) {
        patients = new ArrayList<>();
        this.doctorsService = doctorsService;
        appointments = new ArrayList<>();

    }
    public int getPatientSize() {

        return patients.size();
    }

    public boolean isEmailTaken(String email) {

        return patients.stream().anyMatch(p -> p.getEmail().equals(email));
    }


    @Override
    public void registerUser(User user) {
        if (isEmailTaken(user.getEmail())) {
            throw new DuplicateEmailException("User's email already exists!");
        }
        if (!UserValidation.isEmailValid(user.getEmail())) {
            throw new InvalidEmailFormatException("Invalid Email Format!");
        }
        else if (user instanceof Patient newPatient) {
            String newId = "PAT" + id;
            newPatient.setPatientsId(newId);
            patients.add(newPatient);
            this.id ++;
        }



    }

    public User loginUser(String email, String password) {
        for (Patient myPatient : patients) {
            if (myPatient.getEmail().equals(email) && myPatient.getPassword().equals(password)) {
                return myPatient;
            }

        }

        throw new InvalidCredentialsException("Invalid credentials!");
    }


    @Override
    public Appointment bookAppointment(String appointmentDateTime, Patient patient, String doctorsId, String description) {
        Doctor doctor = doctorsService.findDoctorById(doctorsId);
        if (doctor != null ) {
            if(doctor.getIsAvailable()){
                Appointment currentAppointment = new Appointment(appointmentDateTime, patient, doctorsId, description);
                appointments.add(currentAppointment);
                doctor.makeUnavailable();
                return currentAppointment;
            }
            throw new UnavailableDoctorException("Doctor is currently unavailable!");
//            if(!appointment.getAppointmentTime().toString().equalsIgnoreCase(appointmentDateTime)) {
//                appointments.add(appointment);
//                return appointment;
//            }
//            throw new UnavailableDoctorException("Doctor is not available!");
        }

        throw new UnregisteredDoctorException("Doctor not found!");
    }

    @Override
    public void viewAvailableDoctors() {

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
    public String getAppointments() {
        return appointments.toString();
    }

//    @Override
//    public Doctor findDoctorById(int id) {
//        return null;
//    }


}
