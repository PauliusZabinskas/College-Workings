package org.example;

/**
 * Name: Paulius Zabinskas
 * Id: 2012067
 *
 *
 */

import java.time.LocalDate;

import org.joda.money.Money;
public class Expense {
    private LocalDate date;
    private String description;
    private Category category;
    private boolean wasApproved;
    private Money moneyCost;

    public Expense(String description, Category category, boolean wasApproved, Money moneyCost) {
        this.date = setLocalDate();
        this.description = description;
        this.category = category;
        this.wasApproved = wasApproved;
        this.moneyCost = moneyCost;
    }
    public Expense(String description, Category category, boolean wasApproved, Money moneyCost, int year, int month, int day) {
        this.date = toDate(year, month, day);
        this.description = description;
        this.category = category;
        this.wasApproved = wasApproved;
        this.moneyCost = moneyCost;
    }

    private LocalDate toDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    @Override
    public String toString() {
        return String.format("%s: %s | %s | %s", date, description, category, moneyCost);
    }

    public Expense(){}

    public LocalDate setLocalDate() {
        return LocalDate.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isWasApproved() {
        return wasApproved;
    }

    public void setWasApproved(boolean wasApproved) {
        this.wasApproved = wasApproved;
    }

    public Money getMoneyCost() {
        return moneyCost;
    }

    public void setMoneyCost(Money moneyCost) {
        this.moneyCost = moneyCost;
    }




}

