package com.mp.booklibrary.utils;

import com.mp.booklibrary.enums.UserProfileType;

public class EnumUtils {

    public static UserProfileType getUserProfileType(int value) {
        for (UserProfileType type : UserProfileType.values()) {
            if (type.getValue() == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

    public static String getUserProfileTypeDescription(int value) {
        for (UserProfileType type : UserProfileType.values()) {
            if (type.getValue() == value) {
                return type.getName();
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }
}
