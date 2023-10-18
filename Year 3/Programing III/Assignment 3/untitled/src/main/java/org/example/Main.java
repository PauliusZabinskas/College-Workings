package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    List<Player> playerList = new ArrayList<>();
    LocalDate localDate = LocalDate.of(2022, 8, 20);
    playerList.add(new Player("1", "Paulius", localDate));
    playerList.get(0).addAchievement("shotput","olimpics",localDate );

    for (Player i : playerList){
        System.out.println(i.getId());
        System.out.println(i.getUsername());
        System.out.println(i.getJoinDate());
        System.out.println(i.getAchievements());
    }

    }
}