package interfaces;
import models.User;

public interface UserInterface {
    void registerUser(User user);
    User loginUser(String email, String password);
    void updateProfile();
    void viewAppointment();
    void viewUserProfile();
    void viewAvailableUsers();
    void updateMedicalHistory();
    void viewMedicalHistory();


}
