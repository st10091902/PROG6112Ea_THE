package THE.Q1;

// Class representing an estate agent
class EstateAgent implements IEstateAgent {

    private String name;
    private double[] propertySales;

    // Constructor to initialize an estate agent with a name and property sales
    public EstateAgent(String name, double[] propertySales) {
        this.name = name;
        this.propertySales = propertySales;
    }

    // Getter method for the estate agent's name
    public String getName() {
        return name;
    }

    // Getter method for the estate agent's property sales
    public double[] getPropertySales() {
        return propertySales;
    }

    // Implementation of the estateAgentSales method from the interface
    @Override
    public double estateAgentSales(double[] propertySales) {
        double totalSales = 0;
        for (double sale : propertySales) {
            totalSales += sale;
        }
        return totalSales;
    }

    // Method to calculate the total property sales for the estate agent
    public double calculateTotalSales() {
        return estateAgentSales(propertySales);
    }

    // Implementation of the estateAgentCommission method from the interface
    @Override
    public double estateAgentCommission(double propertySales) {
        return 0.02 * propertySales;
    }

    // Method to calculate the commission earned by the estate agent
    public double calculateCommission() {
        return estateAgentCommission(calculateTotalSales());
    }

    // Implementation of the topEstateAgent method from the interface
    @Override
    public int topEstateAgent(EstateAgent[] agents) {
        int topAgentIndex = 0;
        double maxSales = agents[0].calculateTotalSales();

        // Finding the index of the estate agent with the highest total sales
        for (int i = 1; i < agents.length; i++) {
            double totalSales = agents[i].calculateTotalSales();
            if (totalSales > maxSales) {
                maxSales = totalSales;
                topAgentIndex = i;
            }
        }

        return topAgentIndex;
    }
}
