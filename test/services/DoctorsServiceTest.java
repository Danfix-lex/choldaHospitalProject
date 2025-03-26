package services;

import models.Doctor;
import exception.DuplicateEmailException;
import exception.InvalidCredentialsException;
import models.MedicalHistory;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DoctorsServiceTest {
    DoctorsService myDoctorsService;

    @Before
    public void setUp() {
        myDoctorsService = new DoctorsService();
    }
    @Test
    public void testDoctorListIsEmpty() {
        assertEquals(0, myDoctorsService.getDoctorSize());
    }
    @Test
    public void test_OneDoctor_Registers_Size_One(){
        Doctor doctor = new Doctor("firstName", "lastName", "dateOfBirth", "address", "city", "state", "Radiologist");
        myDoctorsService.registerUser(doctor);
        assertEquals(1, myDoctorsService.getDoctorSize());
    }
    @Test
    public void test_When_Two_DoctorsAreAdded_Size_Is_Two() {
        Doctor doctor1 = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myDoctorsService.registerUser(doctor1);
        assertEquals(1, myDoctorsService.getDoctorSize());

        Doctor doctor2 = new Doctor("firstName2", "lastName2", "email@gmail.com", "address", "city", "state", "Dentistry");
        myDoctorsService.registerUser(doctor2);
        assertEquals(2, myDoctorsService.getDoctorSize());

    }
    @Test
    public void test_when_Doctor_registers_id_is_generated() {
        Doctor newDoctor = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myDoctorsService.registerUser(newDoctor);
        assertEquals(1, myDoctorsService.getDoctorSize());
        assertEquals("DOC1000", newDoctor.getDoctorsId());
    }
    @Test
    public void test_When_Two_Doctors_Registers_Ids_Are_unique() {
        Doctor doctor1 = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myDoctorsService.registerUser(doctor1);
        assertEquals(1, myDoctorsService.getDoctorSize());
        assertEquals("DOC1000", doctor1.getDoctorsId());


        Doctor doctor2 = new Doctor("firstName2", "lastName2", "rocket.@gmail.com", "address", "city", "state", "Cardiologists");
        myDoctorsService.registerUser(doctor2);
        assertEquals(2, myDoctorsService.getDoctorSize());
        assertEquals("DOC1001", doctor2.getDoctorsId());

        Doctor doctor3 = new Doctor("firstName3", "lastName3", "email.@gmail.com", "address", "city", "0000", "LabTechnician");
        myDoctorsService.registerUser(doctor3);
        assertEquals(3, myDoctorsService.getDoctorSize());
        assertEquals("DOC1002", doctor3.getDoctorsId());

    }
    @Test
    public void test_Doctors_with_The_same_Email_RaisesDuplicateEmail_Exception() {
        Doctor doctor1 = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "0000", "Radiologist");
        myDoctorsService.registerUser(doctor1);
        assertEquals(1, myDoctorsService.getDoctorSize());

        Doctor doctor2 = new Doctor("firstName2", "lastName2", "yahoo.@gmail.com", "address", "city", "0000", "Cardiologists");
        assertThrows(DuplicateEmailException.class, () -> myDoctorsService.registerUser(doctor2));
    }

    @Test
    public void test_InvalidCredentialsException_When_A_Doctor_Enter_WrongEmail(){
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo.@gmail.com", "address", "city", "state", "Radiologist");
        myDoctorsService.registerUser(doctor);
        assertEquals(1, myDoctorsService.getDoctorSize());

        InvalidCredentialsException invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myDoctorsService.loginUser("email@gmail.com", "0000"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());

    }
    @Test
    public void test_A_Doctor_can_login() {
        Doctor doctor = new Doctor("firstName1", "lastName1", "email@gmail.com", "address", "city", "0000", "LabTechnician");
        myDoctorsService.registerUser(doctor);
        assertEquals(1, myDoctorsService.getDoctorSize());

        Doctor currentDoctor = (Doctor) myDoctorsService.loginUser("email@gmail.com", "0000");
        assertNotNull(currentDoctor);
        assertEquals("firstName1", currentDoctor.getFirstName());
    }
    @Test
    public void  test_InvalidCredentialsException_When_A_Doctor_Enter_Invalid_Password(){
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo@gmail.com", "address", "city", "1234", "Radiologist");
        myDoctorsService.registerUser(doctor);
        assertEquals(1, myDoctorsService.getDoctorSize());

        Exception invalidCredentials = assertThrows(InvalidCredentialsException.class, () -> myDoctorsService.loginUser("yahoo@gmail.com", "0123"));
        assertEquals("Invalid credentials!", invalidCredentials.getMessage());
    }
    @Test
    public void test_Doctor_Creates_Patients_Medical_History(){
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo@gmail.com", "address", "city", "1234", "Radiologist");
        myDoctorsService.registerUser(doctor);
        assertEquals(1, myDoctorsService.getDoctorSize());


    }

    @Test
    public void testGetMedicalHistoriesValidDoctor() {
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo@gmail.com", "address", "city", "1234", "Radiologist");
        myDoctorsService.registerUser(doctor);
        assertEquals(1, myDoctorsService.getDoctorSize());
        List<MedicalHistory> histories = myDoctorsService.getMedicalHistories("DOC1000");
        assertNotNull(histories.toString(), "Medical history list should not be null.");
        assertEquals(0, histories.size());
    }

    @Test
    public void testGetMedicalHistoriesInvalidDoctor() {
        Doctor doctor = new Doctor("firstName1", "lastName1", "yahoo@gmail.com", "address", "city", "1234", "Radiologist");
        myDoctorsService.registerUser(doctor);
        assertEquals(1, myDoctorsService.getDoctorSize());
        Exception exception = assertThrows(InvalidCredentialsException.class, () -> {
            myDoctorsService.getMedicalHistories("DOC9999");
        });
        assertEquals("Invalid credentials!", exception.getMessage(), "Invalid credentials!");
    }



}
