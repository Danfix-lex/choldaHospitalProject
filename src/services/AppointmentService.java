package services;

import models.Appointment;
import models.Patient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;

    public AppointmentService() {
        appointments = new ArrayList<>();
    }

    public int getAppointmentSize() {
        return appointments.size();
    }

    public void createAppointment(String appointmentDateTime, Patient patient, String doctorsId, String description) {
        Appointment appointment = new Appointment(appointmentDateTime,patient,doctorsId,description);
        appointments.add(appointment);

    }
}
