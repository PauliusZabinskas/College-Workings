package org.example;

//Author: Paulius Zabinskas

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class NCTBook {
// Defining variables
    private String registrationNumber;
    private String testCenterName;
    private String testCenterAddress;
    private LocalDateTime timeAndDate;
    private String bookingID;

    // Created two constructors to satisfy initialization of the class with "DateTime" parameter and without.
    // overloaded constructor
    NCTBook(String registrationNumber, String testCenterName, String testCenterAddress){

        this.bookingID = generateID();
        this.registrationNumber = registrationNumber;
        this.testCenterName = testCenterName;
        this.testCenterAddress = testCenterAddress;
        this.timeAndDate = LocalDateTime.now();

    }
    NCTBook(String registrationNumber, String testCenterName, String testCenterAddress, String timeAndDate) throws InvalidDateException{
        // includes compile time Exception handling
        this.bookingID = generateID();
        this.registrationNumber = registrationNumber;
        this.testCenterName = testCenterName;
        this.testCenterAddress = testCenterAddress;

        try{
            // pass "timeAndDate" parameter to check if date is valid.
            checkIfDateIsValid(timeAndDate);
        } catch (InvalidDateException e){ // Exception will be caught here if thrown.
            throw new InvalidDateException("Invalid Date Exception");
        }
    }

    // method used to throw an exception if condition is not met.
    // and assigns timeAndDate value
    private void checkIfDateIsValid(String timeAndDate) throws InvalidDateException{
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime inputDate = convertStringToDate(timeAndDate);
        if(inputDate.isAfter(now)){
            this.timeAndDate = inputDate;

        }else
            throw new InvalidDateException("Invalid Date Exception");
    }

    @Override
    public String toString(){
         return "\nBooking ID Number: "+ bookingID + "\n"+
                "Registration Number: " + registrationNumber + "\n" +
                "Centre:" + testCenterName + "\n"+
                "Address: " + testCenterAddress + "\n"+
                 "Date & Time:" + formatLocalDateTimeToString(timeAndDate)+"\n\n" ;
    }




    public static void main(String[] args) throws InvalidDateException {

        // dates for testability
        String validDateTime = "2023-12-03T10:15";
        String inValidDateTime = "2020-12-03T10:15";

        NCTBook book = new NCTBook("123","GalwayNCT","Galway" );
        System.out.println(book.toString());
        System.out.println(book.getBookingTime());

        NCTBook book2 = null;
        try {
            book2 = new NCTBook("123","GalwayNCT","Galway", validDateTime );
        } catch (InvalidDateException e) {
            throw new InvalidDateException("Invalid Date Exception");
        }
        System.out.println(book2.toString());


        NCTBook book3 = null;
        try {
            book3 = new NCTBook("123","GalwayNCT","Galway", inValidDateTime );
        } catch (InvalidDateException e) {
            throw new InvalidDateException("Invalid Date Exception");
        }
        System.out.println(book3.toString());

    }

    // Getters and Setters
    public String getRegNumber()  {
        return this.registrationNumber;
    }

    public void setNewRegistrationNumber(String regNo) {
        this.registrationNumber = regNo;
    }
    public String getBookingTime(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return this.timeAndDate.format(formatter);
    }

    // Was not sure what LocalDate formatting to use for this example
    // Chose something light but useful
    private LocalDateTime convertStringToDate(String dateTime){
        // Obtains an instance of LocalDateTime
        // from a text string such as "2007-12-03T10:15:30"
        return LocalDateTime.parse(dateTime);
    }
    // generates an ID
    private String generateID(){
        Random random = new Random();

        int randomNumber = 10000000 + random.nextInt(90000000);

        return String.valueOf(randomNumber);
    }

    // Changing to requested format
    private static String formatLocalDateTimeToString(LocalDateTime dateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'Date & Time: 'EEEE, dd MMMM yyyy 'at' HH:mm")
                .withLocale(Locale.US);

        return dateTime.format(formatter);
    }
}