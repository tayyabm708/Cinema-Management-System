package com.codewithTayyab;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddMovie extends JFrame{
    JLabel screenTitle;
    JLabel name;
    JTextField nameField;
    JLabel genre;
    JTextField genreField;
    JLabel standardPrice;
    JTextField standardPriceField;
    JLabel executivePrice;
    JTextField executivePriceField;
    JLabel rating;
    JTextField ratingField;
    JLabel image;
    JLabel imageDisplay;
    JButton choosePoster;
    JButton addBtn;

    JButton bckBtn;

    public AddMovie(Object obj){
        super("Moonlite Theatre");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(25,25,25));
        setLayout(null);


        screenTitle = new JLabel("ADD MOVIE");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(180, 50, 200, 25);
        add(screenTitle);

        name = new JLabel("Name:");
        name.setForeground(Color.ORANGE);
        name.setBounds(50, 100, 80, 25);
        add(name);

        nameField = new JTextField();
        nameField.setForeground(Color.black);
        nameField.setBounds(150, 100, 100, 25);
        add(nameField);

        genre = new JLabel("Genre:");
        genre.setForeground(Color.ORANGE);
        genre.setBounds(50, 140, 80, 25);
        add(genre);

        genreField = new JTextField();
        genreField.setForeground(Color.black);
        genreField.setBounds(150, 140, 100, 25);
        add(genreField);

        standardPrice = new JLabel("StandardPrice:");
        standardPrice.setForeground(Color.ORANGE);
        standardPrice.setBounds(50, 180, 80, 25);
        add(standardPrice);

        standardPriceField = new JTextField();
        standardPriceField.setForeground(Color.black);
        standardPriceField.setBounds(150, 180, 100, 25);
        add(standardPriceField);

        executivePrice = new JLabel("ExecutivePrice:");
        executivePrice.setForeground(Color.ORANGE);
        executivePrice.setBounds(50, 220, 80, 25);
        add(executivePrice);

        executivePriceField = new JTextField();
        executivePriceField.setForeground(Color.black);
        executivePriceField.setBounds(150, 220, 100, 25);
        add(executivePriceField);

        rating = new JLabel("Rating:");
        rating.setForeground(Color.ORANGE);
        rating.setBounds(50, 260, 80, 25);
        add(rating);

        ratingField = new JTextField();
        ratingField.setForeground(Color.black);
        ratingField.setBounds(150, 260, 100, 25);
        add(ratingField);

        imageDisplay=new JLabel();
        imageDisplay.setBackground(Color.ORANGE);
        imageDisplay.setBounds(300, 100, 200, 150);
        add(imageDisplay);

        choosePoster=new JButton("Choose poster");
        choosePoster.setBackground(Color.ORANGE);
        choosePoster.setBounds(310,260,120,25);
        add(choosePoster);

        addBtn = new JButton("Add Movie");
        addBtn.setBackground(Color.ORANGE);
        addBtn.setBounds(100,300,100,25);
        add(addBtn);


        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obj instanceof Administrator) {
                    new AdminScreen();
                    dispose();
                }
                else {
                    new MovieList(new TicketSeller());
                    dispose();
                }


            }
        });

        choosePoster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser file=new JFileChooser();
                file.setCurrentDirectory(new File(System.getProperty("user.home")));
                FileNameExtensionFilter filter=new FileNameExtensionFilter("JPEG file","jpg","jpeg");
                file.addChoosableFileFilter(filter);
                int result=file.showSaveDialog(null);
                if(result==JFileChooser.APPROVE_OPTION){
                    File selectedFile=file.getSelectedFile();
                    String path=selectedFile.getAbsolutePath();
                    ImageIcon img=new ImageIcon(path);
                    imageDisplay.setIcon(img);
                }
                else if(result==JFileChooser.CANCEL_OPTION){
                    JOptionPane.showMessageDialog(null,"No file selected");
                }
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String n= nameField.getText();
                String g=genreField.getText();
                String st=standardPriceField.getText();
                String et=executivePriceField.getText();
                String r = ratingField.getText();
                if (n.isBlank() || g.isBlank() || st.isBlank() || et.isBlank() || r.isBlank()){
                    JOptionPane.showMessageDialog(null, "Some Field is Empty ");
                }

                else {
                    if(st.matches("-?\\d+(\\.\\d+)?") && et.matches("-?\\d+(\\.\\d+)?") &&  r.matches("-?\\d+(\\.\\d+)?")){
                        if(imageDisplay.getIcon()==null){
                            JOptionPane.showMessageDialog(null,"Please select an image");
                        }
                        else{
                            String trash=imageDisplay.getIcon().toString();
                            MovieItem f = new MovieItem(n, g, Double.parseDouble(st), Double.parseDouble(et), Float.parseFloat(r), trash);
                            ArrayListFiling a = new ArrayListFiling();
                            a.writeToFileArray(f);
                            JOptionPane.showMessageDialog(null, "THe desired item is added, Refresh to see the updated list");
                            dispose();

                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, " Please Take Care of Numerics ");
                    }
                }
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
