public class SalesPerson {
    private String id;
    private Sales[] salesHistory;
    private int count;

    public SalesPerson(String id) {
        this.id = id;
        this.salesHistory = new Sales[100];
        this.count = 0;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public void setSalesHistory(Sales s) {
        salesHistory[count] = s;
        count++;
    }

    public double calcTotalSales() {
        double totalSales = 0.0;
        for (int i = 0; i < count; i++) {
            totalSales += salesHistory[i].getValue() * salesHistory[i].getQuantity();
        }
        return totalSales;
    }

    public static String highest(SalesPerson[] salesPeople) {
        if (salesPeople == null || salesPeople.length == 0) {
            return null;
        }

        SalesPerson highestSalesPerson = null;
        double highestTotalSales = 0.0;

        for (int i = 0; i < salesPeople.length; i++) {
            SalesPerson salesPerson = salesPeople[i];
            if (salesPerson != null) {
                double totalSales = salesPerson.calcTotalSales();
                if (totalSales > highestTotalSales) {
                    highestTotalSales = totalSales;
                    highestSalesPerson = salesPerson;
                }
            }
        }

        if (highestSalesPerson != null) {
            return highestSalesPerson.getId();
        } else {
            return null;
        }
    }
}
