package services;

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
        myAppointment.createAppointment();
        assertEquals(1, myAppointment.getAppointmentSize());
    }




}
