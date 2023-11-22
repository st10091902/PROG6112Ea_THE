package THE.Q2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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

// Main class representing the GUI application
public class EstateAgentGUI extends JFrame {

    private JTextField agentNameField, propertyPriceField, commissionField;
    private JComboBox<String> locationComboBox;
    private JTextArea reportTextArea;

    private IEstateAgent estateAgent;

    public EstateAgentGUI() {
        estateAgent = new EstateAgent();

        setTitle("Estate Agent Commission Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        // Create components
        locationComboBox = new JComboBox<>(new String[]{"Cape Town", "Durban", "Pretoria"});
        agentNameField = new JTextField(15);
        propertyPriceField = new JTextField(15);
        commissionField = new JTextField(15);
        reportTextArea = new JTextArea(10, 20);
        reportTextArea.setEditable(false);

        JLabel locationLabel = new JLabel("Agent Location:");
        JLabel agentNameLabel = new JLabel("Agent Name:");
        JLabel propertyPriceLabel = new JLabel("Property Price:");
        JLabel commissionLabel = new JLabel("Commission Percentage:");
        JLabel reportLabel = new JLabel("Report:");

        // Add components to the panel using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(locationLabel, gbc);

        gbc.gridx = 1;
        panel.add(locationComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(agentNameLabel, gbc);

        gbc.gridx = 1;
        panel.add(agentNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(propertyPriceLabel, gbc);

        gbc.gridx = 1;
        panel.add(propertyPriceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(commissionLabel, gbc);

        gbc.gridx = 1;
        panel.add(commissionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Span two columns
        panel.add(reportLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2; // Span two columns
        panel.add(new JScrollPane(reportTextArea), gbc);

        // Add the panel to the frame
        add(panel);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        // Create Tools menu
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processReportMenuItem = new JMenuItem("Process Report");
        processReportMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processReport();
            }
        });
        toolsMenu.add(processReportMenuItem);

        JMenuItem clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        toolsMenu.add(clearMenuItem);

        JMenuItem saveReportMenuItem = new JMenuItem("Save Report");
        saveReportMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveReportToFile();
            }
        });
        toolsMenu.add(saveReportMenuItem);

        menuBar.add(toolsMenu);

        setVisible(true);
    }

    private void processReport() {
        String agentLocation = locationComboBox.getSelectedItem().toString();
        String agentName = agentNameField.getText();
        String propertyPriceStr = propertyPriceField.getText();
        String commissionStr = commissionField.getText();

        try {
            double propertyPrice = Double.parseDouble(propertyPriceStr);
            double agentCommission = Double.parseDouble(commissionStr);

            if (estateAgent.validateData(agentLocation, agentName, propertyPrice, agentCommission)) {
                double commission = estateAgent.calculateCommission(propertyPrice, agentCommission);
                String report = String.format("Agent Location: %s\nAgent Name: %s\nProperty Price: %.2f\nCommission Percentage: %.2f%%\nCommission Earned: %.2f",
                        agentLocation, agentName, propertyPrice, agentCommission, commission);
                reportTextArea.setText(report);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input. Please check the data and try again.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format. Please enter valid numbers.");
        }
    }

    private void clearFields() {
        agentNameField.setText("");
        propertyPriceField.setText("");
        commissionField.setText("");
        reportTextArea.setText("");
    }

    private void saveReportToFile() {
    String agentLocation = locationComboBox.getSelectedItem().toString();
    String agentName = agentNameField.getText();
    String propertyPriceStr = propertyPriceField.getText();
    String commissionStr = commissionField.getText();

    try {
        double propertyPrice = Double.parseDouble(propertyPriceStr);
        double agentCommission = Double.parseDouble(commissionStr);

        if (estateAgent.validateData(agentLocation, agentName, propertyPrice, agentCommission)) {
            double commission = estateAgent.calculateCommission(propertyPrice, agentCommission);

            // Format the report for saving
            String formattedReport = String.format("ESTATE AGENT REPORT\n" +
                            "*******************************\n" +
                            "AGENT LOCATION: %s\n" +
                            "AGENT NAME: %s\n" +
                            "PROPERTY PRICE: %.2f\n" +
                            "COMMISSION PERCENTAGE: %.2f%%\n" +
                            "CALCULATED COMMISSION: %.2f\n" +
                            "*******************************\n",
                    agentLocation, agentName, propertyPrice, agentCommission, commission);

            // Save the formatted report to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
                writer.write(formattedReport);
                JOptionPane.showMessageDialog(this, "Report saved to report.txt");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error saving report to file.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid input. Please check the data and try again.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid number format. Please enter valid numbers.");
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EstateAgentGUI();
            }
        });
    }
}
