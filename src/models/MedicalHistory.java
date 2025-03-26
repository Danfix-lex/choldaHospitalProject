package models;

import java.time.LocalDateTime;

public class MedicalHistory {
    private LocalDateTime dateTime;
    private String description;
    private boolean treatmentStatus;
    private boolean dischargeStatus;

    public MedicalHistory(String description, boolean treatmentStatus, boolean dischargeStatus) {
        this.dateTime = LocalDateTime.now();
        this.description = description;
        this.treatmentStatus = treatmentStatus;
        this.dischargeStatus = dischargeStatus;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public boolean isTreatmentStatus() {
        return treatmentStatus;
    }

    public boolean isDischargeStatus() {
        return dischargeStatus;
    }
}
