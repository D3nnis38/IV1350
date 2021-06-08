package model;

/**
 * An interface for the class Sale
 *
 * @author dennishadzialic
 */
public interface SaleObserver {

    /**
     * @param revenue is the revenue of the sale
     */
    void newRevenue(double revenue);
}
