package THE.Q1;

// Main class for the Estate Agent application
public class EstateAgentApp {

    public static void main(String[] args) {
        // Sample property sales data for two estate agents
        double[][] propertySales = {
            {800000.0, 1500000.0, 2000000.0},
            {700000.0, 1200000.0, 1600000.0}
        };
        // Creating estate agent objects
        EstateAgent joeBloggs = new EstateAgent("Joe Bloggs", propertySales[0]);
        EstateAgent janeDoe = new EstateAgent("Jane Doe", propertySales[1]);

        // Displaying the sales report
        displayReport(joeBloggs, janeDoe);
    }

    // Method to display the sales report
    private static void displayReport(EstateAgent... agents) {
        System.out.println("ESTATE AGENTS SALES REPORT\n");
        System.out.printf("%-20s%-20s%-20s%-20s\n", "", "JAN", "FEB", "MAR");
        System.out.println("----------------------------------------------------------------------------");

        // Displaying property sales for each estate agent
        for (EstateAgent agent : agents) {
            System.out.printf("%-20s", agent.getName());
            for (double sale : agent.getPropertySales()) {
                System.out.printf("R %.1f\t\t", sale);
            }
            System.out.println();
        }

        // Displaying total property sales for each estate agent
        System.out.println("\nTotal property sales:");
        for (EstateAgent agent : agents) {
            System.out.printf("Total property sales for %s = R %.1f\n", agent.getName(), agent.calculateTotalSales());
        }

        // Displaying sales commission for each estate agent
        System.out.println("\nSales Commission:");
        for (EstateAgent agent : agents) {
            System.out.printf("Sales Commission for %s = R %.1f\n", agent.getName(), agent.calculateCommission());
        }

        // Finding and displaying the top-performing estate agent
        int topAgentIndex = agents[0].topEstateAgent(agents);
        System.out.printf("\nTop performing estate agent: %s\n", agents[topAgentIndex].getName());
    }
}
