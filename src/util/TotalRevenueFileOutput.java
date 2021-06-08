package util;

import model.SaleObserver;

import java.text.DecimalFormat;

/**
 * Prints a total revenue to a file
 *
 * @author dennishadzialic
 */
public class TotalRevenueFileOutput implements SaleObserver {
    private final FileLogger logger = new FileLogger("total_revenue.txt");
    DecimalFormat df = new DecimalFormat("###.###");
    private double totalRevenue;

    /**
     * adds total revenue
     *
     * @param revenue is the revenue of the sale
     */
    @Override
    public void newRevenue(double revenue) {
        totalRevenue += revenue;
        logRevenue();
    }

    /**
     * Logs total revenue
     */
    private void logRevenue() {
        logger.log("Total revenue is: " + df.format(totalRevenue));
    }


}
