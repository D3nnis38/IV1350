package view;

import model.SaleObserver;

import java.text.DecimalFormat;

/**
 * Logs total revenue to the console
 *
 * @author dennishadzialic
 */
public class TotalRevenueView implements SaleObserver {
    DecimalFormat df = new DecimalFormat("###.###");
    private double totalRevenue;

    /**
     * Constructor for the TotalRevenueView-class
     */
    public TotalRevenueView() {
    }

    /**
     * adds total revenue and prints
     *
     * @param revenue is the revenue of the sale
     */
    @Override
    public void newRevenue(double revenue) {
        totalRevenue += revenue;
        printRevenue();
    }

    /**
     * Prints total revenue
     */
    private void printRevenue() {
        System.out.println("-------TotalRevenueView------\nTotal revenue is: " + df.format(totalRevenue) + "\n-----------------------");
    }
}
