package com.finance;

import javax.swing.*;
import java.awt.*;

class SettingsPanel extends JPanel {
    public SettingsPanel(PersonalFinanceManager manager) {
        setLayout(new BorderLayout(20, 20));  // Add spacing for a cleaner layout

        // Title Label
        JLabel label = new JLabel("Settings", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));  // Padding around label
        label.setForeground(new Color(241, 196, 15));  // Yellow color for settings title

        // Settings area (Using form-like layout for multiple settings)
        JPanel settingsForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;

        // Example Settings: Theme, Notifications, Language
        JLabel themeLabel = new JLabel("App Theme:");
        JComboBox<String> themeCombo = new JComboBox<>(new String[] {"Light", "Dark", "System Default"});

        JLabel notificationsLabel = new JLabel("Notifications:");
        JCheckBox notificationsCheckbox = new JCheckBox("Enable Notifications");

        JLabel languageLabel = new JLabel("Language:");
        JComboBox<String> languageCombo = new JComboBox<>(new String[] {"English", "Spanish", "French"});

        // Adding components to form layout
        settingsForm.add(themeLabel, gbc);
        gbc.gridx = 1;
        settingsForm.add(themeCombo, gbc);
        gbc.gridx = 0; gbc.gridy++;
        settingsForm.add(notificationsLabel, gbc);
        gbc.gridx = 1;
        settingsForm.add(notificationsCheckbox, gbc);
        gbc.gridx = 0; gbc.gridy++;
        settingsForm.add(languageLabel, gbc);
        gbc.gridx = 1;
        settingsForm.add(languageCombo, gbc);

        // Back Button
        JButton backButton = createStyledButton("Back to Dashboard");

        // Action Listener for Back Button
        backButton.addActionListener(e -> manager.switchPanel("Dashboard"));

        // Add components to the panel
        add(label, BorderLayout.NORTH);
        add(settingsForm, BorderLayout.CENTER);
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
