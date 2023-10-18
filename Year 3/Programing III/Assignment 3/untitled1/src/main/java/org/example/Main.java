package org.example;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Student Name: Paulius Zabinskas
 * Student ID: 20120267
 */


public class Main {
    public static void main(String[] args) {
        /**
         * Main class initiates player objects using a loop.
         * Each player will have X number of achievements initiated.
         *
         * joinDate is incremented by a day for each player &
         * dateOfAward is incremented by a day for each award.
         *
         * Each player is added to list<player> playerList.
         *
         * For each player number of achievements are added.
         */
        int numberOfPlayers = 5;
        int numberOfAchievements = 2;
        List<Player> playerList = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            String playerId = String.valueOf(i);
            String playerName = "Scooby" + i;
            LocalDate joinDate = LocalDate.of(2023, 8, i+1);

            Player player = new Player(playerId, playerName, joinDate, Country.GERMANY);
            playerList.add(player);

            for (int j = 0; j < numberOfAchievements; j++) {
                String achievementName = "Achievement" + j;
                String achievementDescription = "Description" + j;
                LocalDate dateOfAward = joinDate.plusDays(j);

                Achievement achievement = new Achievement(achievementName, achievementDescription, dateOfAward);
                player.addAchievement(achievement);
            }
        }


        /**
         * In try block each player is printed that previously has been added to player list.
         * Also, nested inner TRY block initiates new ObjectInputStream
         * object, specifying serialization file, and object type to serialize (player).
         *
         * Following inner TRY block initiates new ObjectOutputStream object,
         * specifying file to read, and what data type to map to deserialized object.
         *
         * Printing the deserialized object to terminal.
         *
         * Note: Player object has customized serialization & deserialization methods
         */
        try{
            for (Player player : playerList) {

                System.out.println("\n=====================Player Check ======================");
                System.out.println("ID: " + player.getId());
                System.out.println("User NameS: " + player.getUsername());
                System.out.println("Date: " + player.getJoinDate());

                System.out.println("Achievements: " + player.getAchievements());


                try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("player.ser"))) {
                    os.writeObject(player);
                }


                Player deserializedPlayer;
                try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("player.ser"))) {
                    deserializedPlayer = (Player) is.readObject();
                }
                System.out.println("\n=====================Player Deserialized Check ======================");
                System.out.println("ID: " + deserializedPlayer.getId());
                System.out.println("User Name: " + deserializedPlayer.getUsername());
                System.out.println("Date: " + deserializedPlayer.getJoinDate());

                System.out.println("Achievements: " + deserializedPlayer.getAchievements());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}