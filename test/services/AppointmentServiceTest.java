package services;

import models.Patient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppointmentServiceTest {
    AppointmentService myAppointment;
    @Before
    public void setUp() {
        myAppointment = new AppointmentService();
    }

    @Test
    public void testAppointmentServiceIsInitiallyEmpty() {
        assertEquals(0,myAppointment.getAppointmentSize());
    }

    @Test
    public void testYouCreateAnAppointment_SizeIsOne() {
        Patient newPatient = new Patient("firstName", "lastName", "email@gmail.com",
                "08025473892", "02-12-2024", "Abuja", "0000");
        myAppointment.createAppointment("06-12-2025 9:30 am",newPatient,"DOC1002","I have malaria");
        assertEquals(1, myAppointment.getAppointmentSize());
    }





}
