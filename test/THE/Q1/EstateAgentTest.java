
package THE.Q1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EstateAgentTest {

    @Test
    public void calculateTotalSales_ReturnsTotalSales() {
        // Sample property sales data for an estate agent
        double[] propertySales = {800000.0, 1500000.0, 2000000.0};

        // Creating an estate agent object for testing
        EstateAgent estateAgent = new EstateAgent("Test Agent", propertySales);

        // Expected total sales value
        double expectedTotalSales = 4300000.0;

        // Testing the calculateTotalSales() method
        double actualTotalSales = estateAgent.calculateTotalSales();

        // Asserting that the actual total sales value matches the expected value
        assertEquals(expectedTotalSales, actualTotalSales, 0.001);
    }

    @Test
    public void calculateTotalCommission_ReturnsCommission() {
        // Sample property sales data for an estate agent
        double[] propertySales = {800000.0, 1500000.0, 2000000.0};

        // Creating an estate agent object for testing
        EstateAgent estateAgent = new EstateAgent("Test Agent", propertySales);

        // Expected commission value (2% of total sales)
        double expectedCommission = 86000.0;

        // Testing the calculateCommission() method
        double actualCommission = estateAgent.calculateCommission();

        // Asserting that the actual commission value matches the expected value
        assertEquals(expectedCommission, actualCommission, 0.001);
    }

    @Test
    public void topAgent_ReturnsTopPosition() {
        // Sample property sales data for two estate agents
        double[] propertySalesJoe = {800000.0, 1500000.0, 2000000.0};
        double[] propertySalesJane = {700000.0, 1200000.0, 1600000.0};

        // Creating estate agent objects for testing
        EstateAgent joeBloggs = new EstateAgent("Joe Bloggs", propertySalesJoe);
        EstateAgent janeDoe = new EstateAgent("Jane Doe", propertySalesJane);

        // Expected top agent index (Joe Bloggs has higher total sales)
        int expectedTopAgentIndex = 0;

        // Creating an array of estate agents for testing the topEstateAgent() method
        EstateAgent[] estateAgents = {joeBloggs, janeDoe};

        // Testing the topEstateAgent() method
        int actualTopAgentIndex = joeBloggs.topEstateAgent(estateAgents);

        // Asserting that the actual top agent index matches the expected value
        assertEquals(expectedTopAgentIndex, actualTopAgentIndex);
    }
}
