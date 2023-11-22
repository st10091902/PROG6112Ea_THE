package THE.Q2;

import THE.Q2.EstateAgent;
import THE.Q2.IEstateAgent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstateAgentTest {

    private final IEstateAgent estateAgent = new EstateAgent();

    @Test
    void calculateCommission_CalculatedSuccessfully() {
        // Arrange
        double propertyPrice = 100000.0;
        double agentCommission = 5.0;

        // Act
        double calculatedCommission = estateAgent.calculateCommission(propertyPrice, agentCommission);

        // Assert
        assertEquals(5000.0, calculatedCommission, 0.001); // Allow a small delta for double comparison
    }

    @Test
    void calculateCommission_CalculatedUnsuccessfully() {
        // Arrange
        double propertyPrice = -50000.0;
        double agentCommission = 5.0;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            estateAgent.calculateCommission(propertyPrice, agentCommission);
        });
    }

    @Test
    void validateData_ValidData() {
        // Arrange
        String agentLocation = "Cape Town";
        String agentName = "John Doe";
        double propertyPrice = 100000.0;
        double agentCommission = 5.0;

        // Act
        boolean isValid = estateAgent.validateData(agentLocation, agentName, propertyPrice, agentCommission);

        // Assert
        assertTrue(isValid);
    }
}
