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

}
