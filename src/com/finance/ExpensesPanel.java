package com.finance;

import javax.swing.*;
import java.awt.*;

class ExpensesPanel extends JPanel {
    public ExpensesPanel(PersonalFinanceManager manager) {
        setLayout(new BorderLayout(20, 20));  // Add spacing between components

        // Title Label
        JLabel label = new JLabel("Track Your Expenses", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));  // Add padding around the label
        label.setForeground(new Color(231, 76, 60));  // Red color for the title

        // Text Area for Expenses Input
        JTextArea expensesArea = new JTextArea(10, 40);
        expensesArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        expensesArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));  // Rounded border for the text area
        expensesArea.setLineWrap(true);  // Enable line wrap
        expensesArea.setWrapStyleWord(true);  // Wrap at word boundaries

        // Add a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(expensesArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Enter your expense details"));

        // Back Button
        JButton backButton = createStyledButton("Back to Dashboard");

        // Action Listener for Back Button
        backButton.addActionListener(e -> manager.switchPanel("Dashboard"));

        // Add components to the panel
        add(label, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    // Utility method to create styled buttons
    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));  // Larger font size
        button.setFocusPainted(false);  // Remove focus border
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));  // Blue color for the button
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Change cursor to hand on hover
        button.setPreferredSize(new Dimension(200, 50));  // Set fixed size for the button
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
