package com.finance;

import javax.swing.*;
import java.awt.*;

public class PersonalFinanceManager {
    private JFrame frame;
    private CardLayout cardLayout;

    public PersonalFinanceManager() {
        frame = new JFrame("Personal Finance Manager");
        cardLayout = new CardLayout();
        frame.setLayout(cardLayout);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Add panels
        frame.add(new LoginPanel(this), "Login");
        frame.add(new DashboardPanel(this), "Dashboard");
        frame.add(new IncomePanel(this), "Income");
        frame.add(new ExpensesPanel(this), "Expenses");
        frame.add(new ReportsPanel(this), "Reports");
        frame.add(new SettingsPanel(this), "Settings");

        frame.setVisible(true);
    }

    public void switchPanel(String panelName) {
        cardLayout.show(frame.getContentPane(), panelName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersonalFinanceManager::new);
    }
}
