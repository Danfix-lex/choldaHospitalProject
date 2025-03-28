package interfaces;

import models.Appointment;
import models.Patient;

public interface PatientsActivities extends UserInterface {
    Appointment bookAppointment(String appointmentDateTime, Patient patient, String doctorsId, String description);
    void viewAvailableDoctors();




}
