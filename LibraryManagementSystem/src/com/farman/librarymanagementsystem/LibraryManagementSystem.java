package com.farman.librarymanagementsystem;

import javax.swing.SwingUtilities;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LibraryGUI gui = new LibraryGUI();
            gui.setVisible(true);
        });
    }
}