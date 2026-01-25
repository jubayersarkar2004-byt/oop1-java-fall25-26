package gui;

import entity.Library;
import fileio.LibraryHandeler;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LibraryManagement extends JFrame {

    private JTextField txtBookName, txtAuthor, txtVolume;
    private JTextArea textArea;

    public LibraryManagement() {

        // settings
        setTitle("Library Management System");
        setSize(600, 450);
        setLayout(new BorderLayout()); // using BorderLayout for better organization
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // center screen
        setLocationRelativeTo(null);

        // --- South Panel for Inputs and Search ---
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5)); // 4 rows, 2 cols, with gaps

        // form inputs
        // Book Name
        inputPanel.add(new JLabel("Book Name:"));
        txtBookName = new JTextField();
        inputPanel.add(txtBookName);

        // for author
        inputPanel.add(new JLabel("Author:"));
        txtAuthor = new JTextField();
        inputPanel.add(txtAuthor);

        // for volume
        inputPanel.add(new JLabel("Volume:"));
        txtVolume = new JTextField();
        inputPanel.add(txtVolume);

        // Add the search field label and button to the last row
        inputPanel.add(new JLabel("Search by Book Name:"));
        JButton searchButton = new JButton("Search");
        inputPanel.add(searchButton);

        add(inputPanel, BorderLayout.SOUTH);
        // --- Center Panel for Output ---
        textArea = new JTextArea();       //text area to display output
        textArea.setEditable(false);      //make text area non-editable
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // button panel
        // --- North Panel for Buttons (Create, Update, View, Delete) ---
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Create");
        JButton updateButton = new JButton("Update");
        JButton viewButton = new JButton("View All");

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE); // text color
        deleteButton.setFocusPainted(false);

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.NORTH);

        // --- Actions ---
        addButton.addActionListener(e -> addLibrary());
        viewButton.addActionListener(e -> viewLibraries());
        searchButton.addActionListener(e -> searchLibrary());
        updateButton.addActionListener(e -> updateLibrary());
        deleteButton.addActionListener(e -> deleteLibrary());

        setVisible(true);// make frame visible
    }

    // view all libraries method
    private void addLibrary() {
        if (txtBookName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book Name cannot be empty.", "Validation Error",
                    JOptionPane.WARNING_MESSAGE); //.ShowMessageDialog to show dialog box
            return;
        }

        //for duplicate check
        try {
            Library existingLibrary = LibraryHandeler.searchLibrary(txtBookName.getText().trim());
            if (existingLibrary != null) {
                JOptionPane.showMessageDialog(this, "Same Book Name Already Exists.", "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            Library lib = new Library(
                    txtBookName.getText().trim(), //trim to remove extra spaces 
                    txtAuthor.getText().trim(),
                    txtVolume.getText().trim());//.getText() to get text from text field
            LibraryHandeler.addLibrary(lib);
            JOptionPane.showMessageDialog(this, "Library Added Successfully");
              clearFields();
        } catch (IOException ex) {
            ex.printStackTrace();// print error
        }
    }

    private void viewLibraries() {
        try {
            Library[] libraries = LibraryHandeler.getAllLibraries();
            StringBuilder sb = new StringBuilder(    //StringBuilder to build string efficiently
                    "                                                              --- Current Library Records ---\n");
            sb.append(" \n");// makin space to look better
            sb.append("BOOK  ||  AUTHOR  ||  VOLUME\n");
            sb.append(" \n");// same reason
                                                           //append method to add string to StringBuilder
            for (Library lib : libraries) {
                if (lib != null) {
                    sb.append(lib).append("\n");    //for ecach means library append its string representation
                }
            }
            textArea.setText(sb.toString());
            clearFields();
        } catch (IOException ex) {
            ex.printStackTrace();// print error
        }
    }

    private void searchLibrary() {// search library method
        try {
            String bookName = txtBookName.getText().trim();
            Library lib = LibraryHandeler.searchLibrary(bookName);// search library in file
            if (lib != null) {
                textArea.setText(lib.toString());// display library in text area
            } else {
                textArea.setText("Library not found");// display not found message
            }
            clearFields();
        } catch (IOException ex) {
            ex.printStackTrace();// print error
        }

        

    }

    private void updateLibrary() {
        if (txtBookName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book Name cannot be empty for update.", "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Library lib = new Library(
                    txtBookName.getText().trim(),
                    txtAuthor.getText().trim(),
                    txtVolume.getText().trim());
            LibraryHandeler.updateLibrary(lib);
            JOptionPane.showMessageDialog(this, "Library Updated Successfully");
            clearFields();
        } catch (IOException ex) {
            ex.printStackTrace();// print error
        }
    }

    private void deleteLibrary() {
        try {
            if (!txtBookName.getText().trim().isEmpty()) {
                LibraryHandeler.deleteLibrary(txtBookName.getText().trim());
            } else if (!txtAuthor.getText().trim().isEmpty()) {
                LibraryHandeler.deleteAuthorLibrary(txtAuthor.getText().trim());
            } else if (!txtVolume.getText().trim().isEmpty()) {
                LibraryHandeler.deleteVolumeLibrary(txtVolume.getText().trim());
            }

            JOptionPane.showMessageDialog(this, "Library Deleted");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

      private void clearFields() {
       
        txtBookName.setText("");
        txtAuthor.setText("");
        txtVolume.setText("");
    }

}
