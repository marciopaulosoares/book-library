package com.mp.booklibrary.enums;

public enum UserProfileType {
    BACKOFFICE("Backoffice"),
    MEMBER("Member");
    private final String label;

     UserProfileType(String label){
         this.label = label;
     }
     public String getLabel(){
         return label;
     }
}
