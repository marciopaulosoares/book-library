package com.mp.booklibrary.validator;

import org.springframework.stereotype.Component;

@Component
public class BookValidator {

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

    public boolean isValidTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            return false;
        }
        if (title.length() < 2 || title.length() > 255) {
            return false;
        }
        return true;
    }

    public String normalizeTitle(String title) {
        if (title == null) {
            return null;
        }
        title = title.trim();
        title = title.replaceAll("\\s+", " ");
        return title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
    }

     public String normalizeTitle3(String title) {
        if (title == null) {
            return null;
        }
        title = title.trim();
        title = title.replaceAll("\\s+", " ");
        return title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
    }
}
