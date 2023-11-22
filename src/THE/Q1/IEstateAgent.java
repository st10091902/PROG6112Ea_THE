package THE.Q1;

// Interface defining methods for estate agents
public interface IEstateAgent {

    double estateAgentSales(double[] propertySales);

    double estateAgentCommission(double propertySales);

    int topEstateAgent(EstateAgent[] agents);
}
