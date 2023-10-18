package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Student Name: Paulius Zabinskas
 * Student ID: 20120267
 */

class MainTest {
    List<Player> playerList = new ArrayList<>();
    @BeforeEach
    void initFivePlayersForSerialization() {

        /**
         * Initialize Players and achievements linked to players.
         * add players to the playerList.
         *
         * issue with my test is that each iteration of running test or Main class, csv file will be appended creating test issues.
         * if csv file would be deleted after each RUN. then test passes.
         */

        // Creation of 5 Players
        int numberOfPlayers = 5;
        int numberOfAchievements = 3;


        for (int i = 0; i < numberOfPlayers; i++) {
            String playerId = String.valueOf(i);
            String playerName = "Scooby " + i;
            Country country = Country.GERMANY;
            LocalDate joinDate = LocalDate.of(2023, 8, i + 1);

            Player player = new Player(playerId, playerName, joinDate, country);

            // Adding achievements to each player
            for (int j = 0; j < numberOfAchievements; j++) {
                String achievementName = "Achievement " + j;
                String achievementDescription = "Description " + j;
                LocalDate dateOfAward = joinDate.plusDays(j);

                Achievement achievement = new Achievement(achievementName, achievementDescription, dateOfAward);
                player.addAchievement(achievement);
            }

            playerList.add(player);
        }
    }
        @Test
        void testPlayerSerialization() {
            try {

                /**
                 * For each player in playerList
                 * 1. serialize the player
                 * 2. deserialize the player
                 * 3. assert if original player object is equal to deserialized object.
                 *      checking if original player attributes are equal to deserialized player attributes.
                 * 4. checking if csv file exists.
                 * 5. reading in achievements from csv file.
                 *      method is a copy of readObject method in Player class.
                 *      result is saved in achievement list
                 *      witch will be used to draw assertions
                 * 6. checking if original achievements are equal to deserialized achievements per player.
                 *
                 */

                for (Player player : playerList) {
                    /**
                     * Serializing each player
                     */

                    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("player.ser"))) {
                        os.writeObject(player);
                    }
                    /**
                     * Deserializing each player
                     */

                    Player deserializedPlayer;
                    try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("player.ser"))) {
                        deserializedPlayer = (Player) is.readObject();
                    }

                    // Assertions to check the equality of original and deserialized player details
                    assertEquals(player.getId(), deserializedPlayer.getId());
                    assertEquals(player.getUsername(), deserializedPlayer.getUsername());
                    assertEquals(player.getCountry(), deserializedPlayer.getCountry());
                    assertEquals(player.getJoinDate(), deserializedPlayer.getJoinDate());

                    // Check if achievements.csv file exists
                    assertTrue(Files.exists(Paths.get("achievements.csv")));


                    // Reading achievements from the CSV file
                    List<Achievement> deserializedAchievements = new ArrayList<>();
                    try (BufferedReader reader = new BufferedReader(new FileReader("achievements.csv"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            String[] parts = line.split(",");
                            if (parts[0].equals(player.getId())) {
                                deserializedAchievements.add(new Achievement(parts[1], parts[2], LocalDate.parse(parts[3])));
                            }
                        }
                    }

                    // Assertions to check the equality of original and deserialized achievements
                    List<Achievement> originalAchievements = player.getAchievementsList();
                    assertEquals(originalAchievements.size(), deserializedAchievements.size());
                    for (int i = 0; i < originalAchievements.size(); i++) {
                        assertEquals(originalAchievements.get(i).getAchievementName(), deserializedAchievements.get(i).getAchievementName());
                        assertEquals(originalAchievements.get(i).getAchievementDescription(), deserializedAchievements.get(i).getAchievementDescription());
                        assertEquals(originalAchievements.get(i).getDateOfAward(), deserializedAchievements.get(i).getDateOfAward());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                fail("An exception occurred during the test.");
            }
        }


}