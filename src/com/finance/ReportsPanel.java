package com.finance;

import javax.swing.*;
import java.awt.*;

class ReportsPanel extends JPanel {
    public ReportsPanel(PersonalFinanceManager manager) {
        setLayout(new BorderLayout(20, 20));  // Add spacing for a cleaner layout

        // Title Label
        JLabel label = new JLabel("Financial Reports", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));  // Padding around label
        label.setForeground(new Color(46, 204, 113));  // Green color for reports title

        // Reports Text Area (Read-only)
        JTextArea reportsArea = new JTextArea(10, 40);
        reportsArea.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        reportsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));  // Rounded border
        reportsArea.setEditable(false);  // Set as read-only
        reportsArea.setLineWrap(true);
        reportsArea.setWrapStyleWord(true);

        // Sample text for demonstration purposes
        reportsArea.setText("Your financial reports will appear here.\n\n"
                + "Summary:\n"
                + "- Income: $5,000\n"
                + "- Expenses: $3,000\n"
                + "- Net Savings: $2,000\n\n"
                + "Details can be viewed in graphical format.");

        JScrollPane scrollPane = new JScrollPane(reportsArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Financial Summary"));

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
        button.setFont(new Font("Segoe UI", Font.PLAIN, 18));  // Set larger font size
        button.setFocusPainted(false);  // Remove focus border
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(52, 152, 219));  // Blue color for the button
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));  // Hand cursor on hover
        button.setPreferredSize(new Dimension(200, 50));  // Fixed button size
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2, true));  // Rounded border

        // Hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(41, 128, 185));  // Darker blue on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(52, 152, 219));  // Original blue color
            }
        });

        return button;
    }
}
