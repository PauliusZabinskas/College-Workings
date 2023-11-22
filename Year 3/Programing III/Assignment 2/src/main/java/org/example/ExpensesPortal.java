package org.example;

/**
 * Name: Paulius Zabinskas
 * Id: 2012067
 *
 */

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ExpensesPortal {

    private final List<Expense> expenses;

    public ExpensesPortal() {
        this.expenses = new ArrayList<>();
    }

    // implement use of Joda Money


    /**
     * the goal of this method
     * for given list,
     * check all elements for validity in if statements.
     * if validity holds, convert USD to EURO if requeue,
     * and add elements expense cost to total cost.
     * return joda-money type
     */
    public static Money sumExpenses(List<Expense> expenses) {
        Money totalCost = Money.zero(CurrencyUnit.EUR);
        BigDecimal conversionRate = new BigDecimal("0.95");

        for(Expense e : expenses){
            // lets deal with unexpected currency type (!usd && !eur)
            if(e != null &&
                    e.getMoneyCost().getCurrencyUnit() != CurrencyUnit.USD &&
                    e.getMoneyCost().getCurrencyUnit() != CurrencyUnit.EUR){
                throw new IllegalArgumentException("Allowed currencies are EUR & USD");
            }
            else {
                assert e != null;
                if (e.getMoneyCost().getCurrencyUnit() == CurrencyUnit.USD){
                    totalCost = totalCost.plus(e.getMoneyCost().
                            convertedTo(CurrencyUnit.EUR, conversionRate, RoundingMode.HALF_UP));
                }else
                    totalCost = totalCost.plus(e.getMoneyCost());

            }
        }
        return totalCost;
    }

    public void addExpense(Expense expense){

        expenses.add(expense);
    }

    public void printExpenses(ExpensePrinter printer) {
        printer.print(expenses);
    }



    public List<Expense> getExpensesList() {
        return expenses;
    }


}
