package services;

import exception.ShortPassWordLengthException;
import exception.WeakPassWordException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserValidationTest {
    UserValidation validation;

    @Before
    public void setUp() {

        validation = new UserValidation();
    }
    @Test
    public void test_correct_email_validation() {
        assertTrue(UserValidation.isEmailValid("email@gmail.com"));
        assertTrue(UserValidation.isEmailValid("c@edu.ng"));
        assertTrue(UserValidation.isEmailValid("firstname@yahoo.com"));
        assertTrue(UserValidation.isEmailValid("john@rocketmail.com"));
    }
    @Test
    public void test_invalid_email_validation() {
        assertFalse(UserValidation.isEmailValid("emailgmail.com"));
        assertFalse(UserValidation.isEmailValid("c@gmail"));
        assertFalse(UserValidation.isEmailValid("firstname@.yahoo.com"));
    }
    @Test
    public void test_valid_password_validation() {
        assertTrue(UserValidation.isPasswordValid("Password123"));
        assertTrue(UserValidation.isPasswordValid("Chrisoj2020"));
    }
    @Test
    public void test_short_length_throws_Short_password_Length_Exception() {

        ShortPassWordLengthException shortPassword = assertThrows(ShortPassWordLengthException.class, () -> UserValidation.isPasswordValid("chris01"));
        assertEquals("Password must be at least 8 characters long!", shortPassword.getMessage());
    }
    @Test
    public void test_invalid_password_throws_WeekPasswordException() {
        WeakPassWordException weekPassWord = assertThrows(WeakPassWordException.class, () -> UserValidation.isPasswordValid("password123"));
        assertEquals("Password is too weak!\nIt must contain one uppercase\natleast one digit\nand the rest lower cases", weekPassWord.getMessage());
    }
    @Test
    public void test_to_validate_phone_number(){
        assertTrue(UserValidation.isValidPhoneNumber("08025878634"));
        assertTrue(UserValidation.isValidPhoneNumber("09023907581"));
        assertTrue(UserValidation.isValidPhoneNumber("07089726301"));
        assertTrue(UserValidation.isValidPhoneNumber("08189238756"));
        assertTrue(UserValidation.isValidPhoneNumber("+2349189736450"));
    }
    @Test
    public void test_throwsInvalidPhoneNumberException_If_A_User_EntersAn_Invalid_Phone_Number() {
        assertFalse(UserValidation.isValidPhoneNumber("030902345iw"));
        assertFalse(UserValidation.isValidPhoneNumber("090239075io"));
        assertFalse(UserValidation.isValidPhoneNumber("000897"));
        assertFalse(UserValidation.isValidPhoneNumber("0803948"));
    }
}
