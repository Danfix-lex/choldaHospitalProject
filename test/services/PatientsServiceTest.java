package services;

import exception.InvalidEmailFormatException;
import exception.DuplicateEmailException;
import exception.InvalidCredentialsException;
import org.junit.Before;
import org.junit.Test;
import models.Patient;

import static org.junit.Assert.*;

public class PatientsServiceTest {
    PatientsService myPatientsService = new PatientsService();

    @Before
    public void setUp() {
        myPatientsService = new PatientsService();

    }

    @Test
    public void testPatientListIsEmpty() {
        assertEquals(0, myPatientsService.getPatientSize());
    }
    @Test
    public void test_When_PatientsIsAdded_Size_Is_One() {
        Patient patient = new Patient("firstName", "lastName", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient);
        assertEquals(1, myPatientsService.getPatientSize());

    }

    @Test
    public void test_When_2_PatientsIsUpdated_Size_Is_2() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient1);
        assertEquals(1, myPatientsService.getPatientSize());

        Patient patient2 = new Patient("firstName2", "lastName2", "yahoo@gmail.com", "08025479099", "10-10-2025", "Kogi", "0101");
        myPatientsService.registerUser(patient2);
        assertEquals(2, myPatientsService.getPatientSize());

    }

    @Test
    public void test_when_Patience_registers_id_is_generated() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient1);
        assertEquals(1, myPatientsService.getPatientSize());
        assertEquals("PAT1000", patient1.getPatientsId());

    }

    @Test
    public void test_When_threePatients_register_Id_are_unique() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient1);
        assertEquals(1, myPatientsService.getPatientSize());
        assertEquals("PAT1000", patient1.getPatientsId());

        Patient patient2 = new Patient("firstName2", "lastName2", "yahoo@gmail.com", "08025473812", "02-12-2024", "Benue", "1111");
        myPatientsService.registerUser(patient2);
        assertEquals(2, myPatientsService.getPatientSize());
        assertEquals("PAT1001", patient2.getPatientsId());

        Patient patient3 = new Patient("firstName3", "lastName3", "rocket@gmail.com", "08025473834", "02-12-2024", "Tara", "2222");
        myPatientsService.registerUser(patient3);
        assertEquals(3, myPatientsService.getPatientSize());
        assertEquals("PAT1002", patient3.getPatientsId());
    }
    @Test
    public void test_Patient_with_The_same_Email_RaisesDuplicateEmailException_At_Registration() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient1);
        assertEquals(1, myPatientsService.getPatientSize());

        Patient patient2 = new Patient("firstName2", "lastName2", "email@gmail.com", "08027837389", "03-12-2023", "Kwara", "0200");
        assertThrows(DuplicateEmailException.class, () -> myPatientsService.registerUser(patient2));
    }
    @Test
    public void test_throws_InvalidEmailFormatException_When_Email_Is_Invalid() {
        Patient patient = new Patient("firstName1", "lastName1", "emailgmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        Exception invalidFormat = assertThrows(InvalidEmailFormatException.class, () -> myPatientsService.registerUser(patient));
        assertEquals("Invalid Email Format!", invalidFormat.getMessage());
    }

    @Test
    public void test_InvalidCredentialsException_When_Patient_Enters_wrong_email() {
        Patient patient = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient);
        assertEquals(1, myPatientsService.getPatientSize());


        InvalidCredentialsException invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myPatientsService.loginUser("yahoo@gmail.com", "0000"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());

    }
    @Test
    public void test_InvalidCredentialsException_When_Patient_Enter_Wrong_Password() {
        Patient patient = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient);
        assertEquals(1, myPatientsService.getPatientSize());


        InvalidCredentialsException invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myPatientsService.loginUser("email@gmail.com", "0001"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());
    }
    @Test
    public void test_Patient_can_login() {
        Patient patient = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myPatientsService.registerUser(patient);
        assertEquals(1, myPatientsService.getPatientSize());

        Patient patientLoggedIn = (Patient) myPatientsService.loginUser("email@gmail.com", "0000");
        assertNotNull(patientLoggedIn);
        assertEquals("firstName1", patientLoggedIn.getFirstName());
    }

}
