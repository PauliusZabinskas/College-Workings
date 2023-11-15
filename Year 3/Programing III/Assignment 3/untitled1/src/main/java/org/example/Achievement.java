package org.example;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Student Name: Paulius Zabinskas
 * Student ID: 20120267
 */

public class Achievement implements Serializable {
    private String achievementName;
    private String achievementDescription;
    private LocalDate dateOfAward;

    public Achievement(String achievementName, String description, LocalDate localDate){
        this.achievementName = achievementName;
        this.achievementDescription = description;
        this.dateOfAward = localDate;
    }

    public String getAchievementDescription() {
        return achievementDescription;
    }

    public void setAchievementDescription(String achievementDescription) {
        this.achievementDescription = achievementDescription;
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName;
    }

    public LocalDate getDateOfAward() {
        return dateOfAward;
    }

    public void setDateOfAward(LocalDate dateOfAward) {
        this.dateOfAward = dateOfAward;
    }
}
