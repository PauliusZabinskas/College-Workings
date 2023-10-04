package org.example;
//Author: Paulius Zabinskas
public class InvalidDateException extends Exception {
    // Exception used to be thrown if date entered is before current date
    public InvalidDateException(String message){

        super(message);

    }
}
