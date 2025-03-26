package models;

import java.time.LocalDateTime;

public class MedicalHistory {
    private LocalDateTime dateTime;
    private String description;
    private boolean treatmentStatus;
    private boolean dischargeStatus;

    public MedicalHistory() {}

    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTreatmentStatus(boolean message) {
        this.treatmentStatus = message;
    }

    public boolean isTreatmentStatus() {
        return treatmentStatus;
    }

    public void setDischargeStatus(boolean message) {
        this.dischargeStatus = message;
    }

    public boolean isDischargeStatus() {
        return dischargeStatus;
    }
}
