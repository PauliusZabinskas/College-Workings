package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
//Author: Paulius Zabinskas
class NCTBookTest {
    // variable3 declared in outer class for usability
    NCTBook bookNCT =  new NCTBook("123","GalwayNCT", "Galway");

    @Test
    void getBookingTimeTest() {
        // test checks if booking time is equal to current time.
        // booking a test without DateTime Param will create booking using LocalDateTime.now(); function
        String returnBookingTime = bookNCT.getBookingTime();
        Assertions.assertEquals(getCurrentTime(), returnBookingTime);
    }

    @Test
    void getBookingTimeWithDateTest() {
        // test used to check if exception is thrown with invalid date parameter
        Assertions.assertThrows(InvalidDateException.class, () -> {
            new NCTBook("123","GalwayNCT", "Galway", "2021-12-03T10:15");

        });

    }

    @Test
    void getBookingRegistrationNumberTest(){
        // test checks if expected Registration number contained in booking
        String returnBookingReqNumber = bookNCT.getRegNumber();
        assertEquals("123", returnBookingReqNumber);
    }


    @Test
    void setBookingRegistrationNumberTest(){
        //test checks if new registration number is set and equal to expected
        bookNCT.setNewRegistrationNumber("456");
        assertEquals("456",bookNCT.getRegNumber());
    }

    // function used to get current time
    private String getCurrentTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime timeAndDate = LocalDateTime.now();
        return timeAndDate.format(formatter);
    }
}