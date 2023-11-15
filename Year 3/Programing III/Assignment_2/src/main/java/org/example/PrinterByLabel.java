package org.example;

/**
 * Name: Paulius Zabinskas
 * Id: 2012067
 *
 */

import java.util.List;

public class PrinterByLabel implements ExpensePrinter{

    /**
     * the goal of this method
     * for each CATEGORY in enum class
     * print the category.
     * print Expense details if expense category is equal
     * to current  CATEGORY iteration
     */
    @Override
    public void print(List<Expense> eList) {
        System.out.println("\n");

        for (Category category : Category.values()) {// iterate over Categories
            System.out.println(category);
            for (Expense e : eList) { // for each category, print expense
                if (e.getCategory() == category) {
                    System.out.println(e);
                }
            }
            System.out.println("\n");
        }
    }
}
