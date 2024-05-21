package com.davidbonelo;

import net.datafaker.Faker;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Faker faker = new Faker();
            String searchTerm = faker.appliance().equipment();
            System.out.println(searchTerm);

        }
        System.out.println("Hello world!");
    }
}