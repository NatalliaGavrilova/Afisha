package com.gmail.natalliagavrilova.classifier;

import com.gmail.natalliagavrilova.classifier.dao.api.ICountryDao;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        System.out.println("Your UUID is: " + uuidAsString);

    }


}
