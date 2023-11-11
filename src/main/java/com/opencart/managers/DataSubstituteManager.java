package com.opencart.managers;

public class DataSubstituteManager {

    public static String substituteString(String value) {
        switch (value.toUpperCase()) {
            case "RANDOMFIRSTNAME":
                return RandomDataManager.generatedFirstName();
            case "RANDOMEMAIL":
                return RandomDataManager.generateRandomEmail();
            case "RANDOMLASTNAME":
                return RandomDataManager.generateLastName();
            case "RANDOMPASSWORD":
                return RandomDataManager.generatePassword();


        }
        return value;
    }
}
