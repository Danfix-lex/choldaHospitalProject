package services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import models.MedicalHistory;

class MedicalHistoryTest {
    private MedicalHistory medicalHistory;

    @BeforeEach
    void setUp() {
        medicalHistory = new MedicalHistory();
    }

    @Test
    void testSetAndGetDateTime() {
        LocalDateTime now = LocalDateTime.now();
        medicalHistory.setDateTime(now);
        assertEquals(now, medicalHistory.getDateTime());
    }

    @Test
    void testSetAndGetDescription() {
        String description = "Patient had a mild fever.";
        medicalHistory.setDescription(description);
        assertEquals(description, medicalHistory.getDescription());
    }

    @Test
    void testSetAndGetTreatmentStatus() {
        medicalHistory.setTreatmentStatus(true);
        assertTrue(medicalHistory.isTreatmentStatus());
    }

    @Test
    void testSetAndGetDischargeStatus() {
        medicalHistory.setDischargeStatus(false);
        assertFalse(medicalHistory.isDischargeStatus());
    }
}
