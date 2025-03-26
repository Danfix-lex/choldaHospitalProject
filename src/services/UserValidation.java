package services;
import exception.ShortPassWordLengthException;
import exception.WeakPassWordException;

import java.util.regex.Pattern;


public class UserValidation {
    private static final String EMAIL_VALIDATOR = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    private static final Pattern EMAIL_VALIDATOR_PATTERN = Pattern.compile(EMAIL_VALIDATOR);

    public static boolean isEmailValid(String email) {
        return email != null && EMAIL_VALIDATOR_PATTERN.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password) {
        if (password == null || password.length() < 8) {
            throw new ShortPassWordLengthException("Password must be at least 8 characters long!");
        }
        boolean containsUpperCase = !password.equals(password.toLowerCase());
        boolean containsLowerCase = !password.equals(password.toUpperCase());
        boolean containsDigits = password.matches(".*\\d.*");

        if (!containsUpperCase || !containsLowerCase || !containsDigits) {
            throw new WeakPassWordException("Password is too weak!\nIt must contain one uppercase\natleast one digit\nand the rest lower cases");

        }
        return true;


    }


    public static boolean isValidPhoneNumber(String phoneNumber) {
        String  phoneRegex = "^\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$";
        return phoneNumber != null && phoneNumber.matches(phoneRegex);
    }
}
