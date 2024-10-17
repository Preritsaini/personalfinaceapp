package com.finance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private PersonalFinanceManager manager;

    public LoginPanel(PersonalFinanceManager manager) {
        this.manager = manager;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Set a vibrant background color (optionally a background image)
        setBackground(new Color(240, 248, 255));

        // Username Label and Icon
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Modern font
        JLabel usernameIcon = new JLabel(new ImageIcon("user_icon.png")); // Add user icon

        // Password Label and Icon
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 14)); // Modern font
        JLabel passwordIcon = new JLabel(new ImageIcon("password_icon.png")); // Add password icon

        // Username Field with Rounded Border and Drop Shadow
        usernameField = new JTextField(20);
        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        usernameField.setToolTipText("Enter your username");
        usernameField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding inside the text field
        usernameField.setBackground(new Color(255, 255, 255));
        usernameField.setOpaque(false); // Transparent background
        usernameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        // Password Field with Rounded Border and Drop Shadow
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        passwordField.setToolTipText("Enter your password");
        passwordField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        passwordField.setOpaque(false);
        passwordField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        // Login Button with Rounded Edges, Hover Effect, and Shadow
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        loginButton.setBackground(new Color(30, 144, 255)); // Dodger blue
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false); // Removes focus border
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
        loginButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(30, 144, 255), 1),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        // Add hover effect (color change + shadow)
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(25, 115, 230)); // Slightly darker blue
                loginButton.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(25, 115, 230), 1),
                        BorderFactory.createEmptyBorder(10, 20, 10, 20)
                ));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButton.setBackground(new Color(30, 144, 255)); // Reset to original blue
            }
        });

        // Login button action
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Skipping actual authentication for now
                manager.switchPanel("Dashboard");
            }
        });

        // Layout organization with GridBagConstraints
        gbc.gridx = 0; gbc.gridy = 0;
        add(usernameIcon, gbc); // Icon next to label
        gbc.gridx = 1; gbc.gridy = 0;
        add(usernameLabel, gbc);
        gbc.gridx = 2; gbc.gridy = 0;
        add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(passwordIcon, gbc); // Icon next to label
        gbc.gridx = 1; gbc.gridy = 1;
        add(passwordLabel, gbc);
        gbc.gridx = 2; gbc.gridy = 1;
        add(passwordField, gbc);

        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Set a background image or gradient
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        Color color1 = new Color(240, 248, 255); // Light blue
        Color color2 = new Color(224, 255, 255); // Lighter blue
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, height, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}
