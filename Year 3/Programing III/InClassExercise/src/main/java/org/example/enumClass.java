package org.example;

public enum enumClass {
    card1 ("Card1",10, 5, 2),
    card2("Card2",5,10,5);

    private String name;
    private int str;
    private int def;
    private int agility;
    enumClass(String name, int str, int defence, int agility){
        this.str = str;
        this.def = defence;
        this.agility = agility;
    }

    public void CompareSTR(enumClass card1, enumClass card2){
        if(card1.str < card2.str){
            System.out.println("Card"+ card2.name+"wins");
        }
    }

}
