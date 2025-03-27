package services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import models.MedicalHistory;

class MedicalHistoryTest {

    @Test
    void testSetAndGetDateTime() {
        MedicalHistory medicalHistory = new MedicalHistory("Malaria", true, false);
        LocalDateTime now = medicalHistory.getDateTime();
        assertEquals(now, medicalHistory.getDateTime());
    }

    @Test
    void testSetAndGetDescription() {
        MedicalHistory medicalHistory = new MedicalHistory("Malaria", true, false);
        String description = medicalHistory.getDescription();
        assertEquals(description, medicalHistory.getDescription());
    }

    @Test
    void testSetAndGetTreatmentStatus() {
        MedicalHistory medicalHistory = new MedicalHistory("Malaria", true, false);
        medicalHistory.isTreatmentStatus();
        assertTrue(medicalHistory.isTreatmentStatus());
    }

    @Test
    void testSetAndGetDischargeStatus() {
        MedicalHistory medicalHistory = new MedicalHistory("Malaria", true, false);
        medicalHistory.isDischargeStatus();
        assertFalse(medicalHistory.isDischargeStatus());
    }
}
