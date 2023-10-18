package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Student Name: Paulius Zabinskas
 * Student ID: 20120267
 */

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String id;
    private String username;
    private Country country;

    private LocalDate joinDate;
    // attribute that should not be serialized
    private transient List<Achievement> achievementList;

    public Player(String id, String username, LocalDate joinDate, Country country){
        this.id = id;
        this.username = username;
        this.country = country;
        this.joinDate = joinDate;
        achievementList = new ArrayList<>();
    }

    /**
     * add new achievement to the list of player achievements.
     *
     */
    public void addAchievement(Achievement achievement){

        achievementList.add(achievement);
    }


    /**
     * Key function of Player Class.
     * Serialization method is customized using description of this function.
     * Meaning, when serialization function will be called to serialize this object (player object),
     * writeObject will be triggered.
     *
     * writeObject method serializes all attributes expect achievementList witch is done,
     * by indicated using transient parameter.
     *
     * achievementList is serialized into csv file with BufferedWriter.
     * append parameter is TRUE, appending to csv file with each iteration of file RUN
     *
     * admittedly causing issues if file will be executed more than once.
     */
    @Serial
    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject(); // Serialize other attributes

        // Write achievements to CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("achievements.csv", true))) {
            for (Achievement achievement : achievementList) {
                writer.write(String.format("%s,%s,%s,%s\n",
                        getId(),
                        achievement.getAchievementName(),
                        achievement.getAchievementDescription(),
                        achievement.getDateOfAward()));
            }
        }
    }

    /**
     * Key function of Player Class.
     * Deserialization method is customized using description of this function.
     * Meaning, when deserialization function will be called to deserialize this object (player object),
     * readObject will be triggered.
     *
     * Player objects are deserializes as per default, except achievementList.
     *
     * achievementList list must be initialized.
     *
     * Using BufferedReader data type to read in the file.
     * As advised by assignment notes, I have changed deliminator to ",".
     * So, for each line of in csv file, (knowing that 4 columns exist),
     * create new Achievement object with column data as parameters.
     */
    @Serial
    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject(); // Deserialize other attributes

        // Initialize the achievementList as it's marked transient
        achievementList = new ArrayList<>();

        // Read achievements from CSV file and populate achievementList
        try (BufferedReader reader = new BufferedReader(new FileReader("achievements.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(id)) {
                    Achievement achievement = new Achievement(parts[1], parts[2], LocalDate.parse(parts[3]));
                    achievementList.add(achievement);
                }
            }
        }
    }

    /**
     * Method getAchievements return all achievements via their name, description, date awarded,
     * as one string, using StringBuilder.
     *
     */
    public String getAchievements(){
        if (achievementList.isEmpty()) {
            return "This player has no achievements yet.";
        }

        StringBuilder str = new StringBuilder();
        str.append("Achievements:\n");

        for (Achievement achievement : achievementList) {
            str.append("- Achievement Name: ").append(achievement.getAchievementName()).append("\n")
                    .append("  Description: ").append(achievement.getAchievementDescription()).append("\n")
                    .append("  Date of Award: ").append(achievement.getDateOfAward()).append("\n\n");
        }

        return str.toString();
    }

    public List<Achievement> getAchievementsList(){

        return achievementList;
    }

    /**
     * Override toString method with method below.
     * should return player details.
     *
     */
    @Override
    public String toString(){
        return "Player{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", joinDate=" + joinDate +
                ", Country= " + country +
                ", achievements=\n" + getAchievements() +
                '}';
    }

    /**
     *
     * Getters and Setters
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }



}
