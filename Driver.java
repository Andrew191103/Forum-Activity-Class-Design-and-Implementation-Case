public class Driver {
    private static SalesPerson[] salesPeople = new SalesPerson[100];

    public static void addSales(Sales s, String id) {
        SalesPerson salesPerson = findSalesPersonById(id);
        if (salesPerson != null) {
            salesPerson.setSalesHistory(s);
        } else {
            System.out.println("Salesperson with ID " + id + " not found.");
        }
    }

    private static SalesPerson findSalesPersonById(String id) {
        for (SalesPerson salesPerson : salesPeople) {
            if (salesPerson != null && salesPerson.getId().equals(id)) {
                return salesPerson;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Instantiate salesPeople objects
        salesPeople[0] = new SalesPerson("100");
        salesPeople[1] = new SalesPerson("101");

        // Add sales to salesPeople[0]
        salesPeople[0].setSalesHistory(new Sales("A100", 300.00, 10));
        salesPeople[0].setSalesHistory(new Sales("A200", 1000.00, 2));

        // Add sales to salesPeople[1]
        salesPeople[1].setSalesHistory(new Sales("A300", 2550.40, 10));

        // Output the ID of the salesperson with the highest total sales
        String highestSalesPersonId = SalesPerson.highest(salesPeople);
        System.out.println("Salesperson with the highest total sales: " + highestSalesPersonId);

        // Add a new sale to a salesperson
        addSales(new Sales("A400", 500.00, 5), "100");
    }
}
