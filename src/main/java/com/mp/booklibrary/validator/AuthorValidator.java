package com.mp.booklibrary.validator;

import org.springframework.stereotype.Component;

@Component
public class AuthorValidator {

    public boolean isValidIsbn(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            return false;
        }
        isbn = isbn.replaceAll("[\\s-]", "");
        if (isbn.length() != 10 && isbn.length() != 13) {
            return false;
        }
        if (!isbn.matches("[0-9]+")) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < isbn.length(); i++) {
            sum += Character.getNumericValue(isbn.charAt(i)) * (i + 1);
        }
        return sum % 11 == 0;
    }

    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (name.length() < 2 || name.length() > 255) {
            return false;
        }
        return true;
    }

    public String normalizeName(String name) {
        if (name == null) {
            return null;
        }
        name = name.trim();
        name = name.replaceAll("\\s+", " ");
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
