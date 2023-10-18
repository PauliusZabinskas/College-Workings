package org.example;

public class Country {
    public enum EuropeanCountry {
        GERMANY,
        FRANCE,
        SPAIN,
        ITALY,
        NETHERLANDS,
        BELGIUM,
        AUSTRIA,
        PORTUGAL,
        SWEDEN,
        POLAND;

        // You can also add methods inside the enum class if needed
        public static EuropeanCountry getCountryByOrdinal(int ordinal) {
            if (ordinal >= 0 && ordinal < values().length) {
                return values()[ordinal];
            } else {
                throw new IllegalArgumentException("Invalid ordinal: " + ordinal);
            }
        }
    }


}
