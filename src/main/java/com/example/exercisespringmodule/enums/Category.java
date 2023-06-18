package com.example.exercisespringmodule.enums;

public enum Category {

    FANTASY("fantasy"),
    DRAMA("drama"),
    HORROR("horror"),
    ACTION("action"),
    ROMANCE("romance"),
    THRILLER("thriller");

    private String value;
     Category(String value){
        this.value=value;
    }

//    public static Enum getCategoryByValue(String value){
//         return Category.valueOf(value);
//    }
}

