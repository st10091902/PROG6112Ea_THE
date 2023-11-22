package THE.Q2;

// Interface to define methods for estate agent functionality
interface IEstateAgent {

    double calculateCommission(double propertyPrice, double agentCommission);

    boolean validateData(String agentLocation, String agentName, double propertyPrice, double agentCommission);
}

// Implementation of the IEstateAgent interface
class EstateAgent implements IEstateAgent {

    @Override
    public double calculateCommission(double propertyPrice, double agentCommission) {
        return propertyPrice * agentCommission / 100.0;
    }

    @Override
    public boolean validateData(String agentLocation, String agentName, double propertyPrice, double agentCommission) {
        // Validate data based on specified rules
        return !agentLocation.isEmpty() && !agentName.isEmpty() && propertyPrice > 0 && agentCommission > 0;
    }
}
