package com.mp.booklibrary.enums;

public enum UserProfileType {
    BACKOFFICE(1,"Backoffice"),
    BORROWER(2,"User");

    private final int value;
    private final String name;

     UserProfileType(int id, String name){
         this.value = id;
         this.name = name;
     }

     public int getValue(){
         return  value;
     }

     public String getName(){
         return  name;
     }
}
