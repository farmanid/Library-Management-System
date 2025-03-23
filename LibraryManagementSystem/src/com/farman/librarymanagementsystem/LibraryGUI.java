package com.farman.librarymanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibraryGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField titleField;
    private JTextField authorField;
    private JTextArea displayArea;
    private ArrayList<LibraryItem> libraryItems;

    public LibraryGUI() {
        libraryItems = new ArrayList<>();
        setTitle("Library Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel titleLabel = new JLabel("Book Title:");
        titleField = new JTextField(20);
        JLabel authorLabel = new JLabel("Author:");
        authorField = new JTextField(20);
        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        addButton.addActionListener(new AddBookAction());
        viewButton.addActionListener(new ViewBooksAction());

        add(titleLabel);
        add(titleField);
        add(authorLabel);
        add(authorField);
        add(addButton);
        add(viewButton);
        add(new JScrollPane(displayArea));

        setLocationRelativeTo(null);
    }

    private class AddBookAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = titleField.getText();
            String author = authorField.getText();
            try {
                if (title.isEmpty() || author.isEmpty()) {
                    throw new InvalidInputException("Title and Author cannot be empty.");
                }
                LibraryItem book = new Book(title, author);
                libraryItems.add(book);
                titleField.setText("");
                authorField.setText("");
                JOptionPane.showMessageDialog(null, "Book added successfully!");
            } catch (InvalidInputException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class ViewBooksAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayArea.setText("");
            for (LibraryItem item : libraryItems) {
                displayArea.append(item.getDetails() + "\n");
            }
        }
    }
}