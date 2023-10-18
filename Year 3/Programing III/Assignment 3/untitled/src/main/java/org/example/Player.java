package org.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
    private String id;
    private String username;
    //private Country country;

    private LocalDate joinDate;
    private final List<Achievement> achievementList;

    public Player(String id, String username, LocalDate joinDate){
        this.id = id;
        this.username = username;
       //this.country = country;
        this.joinDate = joinDate;
        achievementList = new ArrayList<>();
    }

    public void addAchievement(String name, String description, LocalDate localDate){
        achievementList.add(new Achievement(name, description, localDate));
    }

    public String getAchievements(){
        StringBuilder str = new StringBuilder();
        for (Achievement i : achievementList){
            str.append(i.getAchievementName());
            str.append(i.getAchievementDescription());
            str.append(i.getDateOfAward());
        }
        return String.valueOf(str);
    }

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

//    public Country getCountry() {
//        return country;
//    }
//
//    public void setCountry(Country country) {
//        this.country = country;
//    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

}
