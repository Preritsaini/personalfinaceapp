package com.finance;

import javax.swing.*;
import java.awt.*;

class DashboardPanel extends JPanel {
    public DashboardPanel(PersonalFinanceManager manager) {
        setLayout(new BorderLayout(20, 20));  // Add spacing between components

        // Welcome Label
        JLabel label = new JLabel("Welcome to the Personal Finance Manager!", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0)); // Add padding around the label
        label.setForeground(new Color(40, 55, 71));  // Darker color for the title

        // Button Customization
        JButton incomeButton = createStyledButton("Manage Income");
        JButton expensesButton = createStyledButton("Manage Expenses");
        JButton reportsButton = createStyledButton("View Reports");
        JButton settingsButton = createStyledButton("Settings");

        // Action Listeners
        incomeButton.addActionListener(e -> manager.switchPanel("Income"));
        expensesButton.addActionListener(e -> manager.switchPanel("Expenses"));
        reportsButton.addActionListener(e -> manager.switchPanel("Reports"));
        settingsButton.addActionListener(e -> manager.switchPanel("Settings"));

        // Button Panel (Grid for better spacing)
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));  // 2x2 grid with spacing
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));  // Add padding inside the panel
        buttonPanel.add(incomeButton);
        buttonPanel.add(expensesButton);
        buttonPanel.add(reportsButton);
        buttonPanel.add(settingsButton);

        // Add components to the panel
        add(label, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Utility method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));  // Increase font size for a modern look
        button.setFocusPainted(false);  // Remove the focus border
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));  // Light blue background
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Change cursor on hover
        button.setPreferredSize(new Dimension(200, 50));  // Set a fixed size
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));  // Rounded border

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(41, 128, 185));  // Darker blue on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(52, 152, 219));  // Original color
            }
        });

        return button;
    }
}
