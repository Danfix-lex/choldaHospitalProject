package services;

import models.Doctor;
import exception.InvalidCredentialsException;
import exception.DuplicateEmailException;
import org.junit.Before;
import org.junit.Test;
import models.Patient;

import static org.junit.Assert.*;

public class UsersServiceTest {
    UsersService myUser;

    @Before
    public void setUp() {
        myUser = new UsersService();

    }

    @Test
    public void testPatientListIsEmpty() {
        assertEquals(0, myUser.getUserSize("patient"));
    }

    @Test
    public void testDoctorListIsNotEmpty() {
        assertEquals(0, myUser.getUserSize("doctor"));
    }

    @Test
    public void test_When_PatientsIsAdded_Size_Is_One() {
        Patient patient = new Patient("firstName", "lastName", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient);
        assertEquals(1, myUser.getUserSize("patient"));
    }

    @Test
    public void test_When_OneDoctorsIsAdded_Size_Is_One() {
        Doctor doctor = new Doctor("firstName", "lastName", "dateOfBirth", "address", "city", "state", "Radiologist");
        myUser.registerUser(doctor);
        assertEquals(1, myUser.getUserSize("doctor"));
    }

    @Test
    public void test_When_2_PatientsIsUpdated_Size_Is_2() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient1);
        assertEquals(1, myUser.getUserSize("patient"));

        Patient patient2 = new Patient("firstName2", "lastName2", "yahoo@gmail.com", "08025479099", "10-10-2025", "Kogi", "0101");
        myUser.registerUser(patient2);
        assertEquals(2, myUser.getUserSize("patient"));

    }

    @Test
    public void test_When_Two_DoctorsAreAdded_Size_Is_Two() {
        Doctor doctor1 = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myUser.registerUser(doctor1);
        assertEquals(1, myUser.getUserSize("doctor"));

        Doctor doctor2 = new Doctor("firstName2", "lastName2", "email@gmail.com", "address", "city", "state", "Dentistry");
        myUser.registerUser(doctor2);
        assertEquals(2, myUser.getUserSize("doctor"));


    }

    @Test
    public void test_when_Patience_registers_id_is_generated() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient1);
        assertEquals(1, myUser.getUserSize("patient"));
        assertEquals("PAT1000", patient1.getPatientsId());

    }

    @Test
    public void test_When_threePatients_register_Id_are_unique() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient1);
        assertEquals(1, myUser.getUserSize("patient"));
        assertEquals("PAT1000", patient1.getPatientsId());

        Patient patient2 = new Patient("firstName2", "lastName2", "yahoo@gmail.com", "08025473812", "02-12-2024", "Benue", "1111");
        myUser.registerUser(patient2);
        assertEquals(2, myUser.getUserSize("patient"));
        assertEquals("PAT1001", patient2.getPatientsId());

        Patient patient3 = new Patient("firstName3", "lastName3", "rocket@gmail.com", "08025473834", "02-12-2024", "Tara", "2222");
        myUser.registerUser(patient3);
        assertEquals(3, myUser.getUserSize("patient"));
        assertEquals("PAT1002", patient3.getPatientsId());
    }

    @Test
    public void test_when_Doctor_registers_id_is_generated() {
        Doctor doctor1 = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myUser.registerUser(doctor1);
        assertEquals(1, myUser.getUserSize("Doctor"));
        assertEquals("DOC1000", doctor1.getDoctorsId());

    }

    @Test
    public void test_When_Two_Doctors_Registers_Ids_Are_unique() {
        Doctor doctor1 = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myUser.registerUser(doctor1);
        assertEquals(1, myUser.getUserSize("Doctor"));
        assertEquals("DOC1000", doctor1.getDoctorsId());


        Doctor doctor2 = new Doctor("firstName2", "lastName2", "rocket.@gmail.com", "address", "city", "state", "Cardiologists");
        myUser.registerUser(doctor2);
        assertEquals(2, myUser.getUserSize("Doctor"));
        assertEquals("DOC1001", doctor2.getDoctorsId());

        Doctor doctor3 = new Doctor("firstName3", "lastName3", "email.@gmail.com", "address", "city", "state", "LabTechnician");
        myUser.registerUser(doctor3);
        assertEquals(3, myUser.getUserSize("Doctor"));
        assertEquals("DOC1002", doctor3.getDoctorsId());

    }

    @Test
    public void test_Patient_with_The_same_Email_RaisesDuplicateEmail_Exception() {
        Patient patient1 = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient1);
        assertEquals(1, myUser.getUserSize("patient"));

        Patient patient2 = new Patient("firstName2", "lastName2", "email@gmail.com", "08027837389", "03-12-2023", "Kwara", "0200");
        assertThrows(DuplicateEmailException.class, () -> myUser.registerUser(patient2));
    }

    @Test
    public void test_Doctors_with_The_same_Email_RaisesDuplicateEmail_Exception() {
        Doctor doctor1 = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myUser.registerUser(doctor1);
        assertEquals(1, myUser.getUserSize("Doctor"));

        Doctor doctor2 = new Doctor("firstName2", "lastName2", "yahoo.@gmail.com", "address", "city", "state", "Cardiologists");
        assertThrows(DuplicateEmailException.class, () -> myUser.registerUser(doctor2));
    }

    @Test
    public void test_Patient_can_login() {
        Patient patient = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient);
        assertEquals(1, myUser.getUserSize("patient"));

        Patient patientLoggedIn = (Patient) myUser.loginUser("email@gmail.com", "0000");
        assertNotNull(patientLoggedIn);
        assertEquals("firstName1", patientLoggedIn.getFirstName());

    }

    @Test
    public void test_InvalidCredentialsException_When_Patient_Enter_Invalid_email() {
        Patient patient = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient);
        assertEquals(1, myUser.getUserSize("patient"));


        Exception invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myUser.loginUser("yahoo@gmail.com", "0000"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());

    }

    @Test
    public void test_InvalidCredentialsException_When_Patient_Enter_Invalid_Password() {
        Patient patient = new Patient("firstName1", "lastName1", "email@gmail.com", "08025473892", "02-12-2024", "Abuja", "0000");
        myUser.registerUser(patient);
        assertEquals(1, myUser.getUserSize("patient"));


        Exception invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myUser.loginUser("email@gmail.com", "0001"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());

    }
    @Test
    public void test_Doctor_can_login() {
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myUser.registerUser(doctor);
        assertEquals(1, myUser.getUserSize("Doctor"));

        assertEquals("firstName1", doctor.getFirstName());
    }
    @Test
    public void test_InvalidCredentialsException_When_A_Doctor_Enter_InvalidEmail(){
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myUser.registerUser(doctor);
        assertEquals(1, myUser.getUserSize("Doctor"));

        Exception invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myUser.loginUser("email@gmail.com", "0000"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());

    }
    @Test
    public void  test_InvalidCredentialsException_When_A_Doctor_Enter_Invalid_Password(){
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo@gmail.com", "address", "city", "1234", "Radiologist");
        myUser.registerUser(doctor);
        assertEquals(1, myUser.getUserSize("Doctor"));

        Exception invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myUser.loginUser("yahoo@gmail.com", "0123"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());
    }

}

