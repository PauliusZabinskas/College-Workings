package org.example;

/**
 * Name: Paulius Zabinskas
 * Id: 2012067
 *
 */

import org.joda.money.Money;

import java.util.List;


import static org.example.Category.*;

public class Main {
    public static void main(String[] args) {
        ExpensesPortal expensesPortal = new ExpensesPortal();
        // Creating expenses with two constructors
        Money moneyCost = Money.parse("EUR 270.59");
        Expense expense = new Expense("Flight to Glasgow", TRAVEL_AND_SUBSISTENCE, true, moneyCost);
        expensesPortal.addExpense(expense);

        Money moneyCost1 = Money.parse("USD  540.00");
        Expense expense1 = new Expense("Dell 17-inch monitor", EQUIPMENT, true, moneyCost1);
        expensesPortal.addExpense(expense1);

        Money moneyCost2 = Money.parse("EUR 17.99");
        Expense expense2 = new Expense("Java for Dummies", OTHER, true, moneyCost2, 2020, 12,12);
        expensesPortal.addExpense(expense2);

        // get expense list
        List<Expense> expenseList = expensesPortal.getExpensesList();


        // lambda expression
        expensesPortal.printExpenses(expenses -> {
            for(Expense e : expenses){
                System.out.println(e.toString());
            }
        });

        // Anonymous new ExpensePrinter()
        expensesPortal.printExpenses(new ExpensePrinter() {
            @Override
            public void print(List<Expense> expenses) {
                System.out.println("There are " + expenses.size()
                        + " expenses in the system totalling to a value of "
                        + ExpensesPortal.sumExpenses(expenses));
            }
        });

        PrinterByLabel printerByLabel = new PrinterByLabel();
        printerByLabel.print(expenseList);
    }
}