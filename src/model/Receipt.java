package model;

/**
 * Represents the Receipt
 *
 * @author dennishadzialic
 */
public class Receipt {
    private final Sale sale;

    /**
     * Creates a new instance
     *
     * @param sale is the current expiring sale
     */
    public Receipt(Sale sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "\nSale start at: " + sale.getSaleTime() +
                "\nitems=" + sale.getProductList() +
                "\nTotal amount= " + sale.getRunningTotal() + " SEK + " + sale.getVAT() + " SEK VAT" + " = " + sale.getTotal() + " SEK" +
                "\nAmount Paid by customer= " + sale.getAmountPaid() + " SEK" +
                "\n Change= " + sale.getChange() + " SEK" +
                '}';
    }
}
