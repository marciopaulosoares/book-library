package com.mp.booklibrary.enums;

public enum UserProfileType {
    BACKOFFICE(1),
    BORROWER(2);

    private final int value;
     UserProfileType(int value){
         this.value = value;
     }

     public int getValue(){
         return  value;
     }
}
