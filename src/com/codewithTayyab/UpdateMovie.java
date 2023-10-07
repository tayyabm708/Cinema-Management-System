package com.codewithTayyab;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateMovie extends JFrame{
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
    JLabel imageDisplay;
    JButton updateBtn;
    JButton bckBtn;

    public UpdateMovie(Object obj0,Object obj , String val){
        super("Moonlite Theatre");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(25,25,25));
        setLayout(null);

        screenTitle = new JLabel("UPDATE MOVIE");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(180, 50, 200, 25);
        add(screenTitle);

        name = new JLabel("Name:");
        name.setForeground(Color.ORANGE);
        name.setBounds(50, 100, 80, 25);
        add(name);

        nameField = new JTextField(((MovieItem) obj).getName());
        nameField.setForeground(Color.black);
        nameField.setBounds(150, 100, 100, 25);
        add(nameField);

        genre = new JLabel("Genre:");
        genre.setForeground(Color.ORANGE);
        genre.setBounds(50, 140, 80, 25);
        add(genre);

        genreField = new JTextField(((MovieItem) obj).getGenre());
        genreField.setForeground(Color.black);
        genreField.setBounds(150, 140, 100, 25);
        add(genreField);

        standardPrice = new JLabel("Standard Ticket");
        standardPrice.setForeground(Color.ORANGE);
        standardPrice.setBounds(50, 180, 80, 25);
        add(standardPrice);

        standardPriceField = new JTextField(String.valueOf(((MovieItem) obj).getStandardTicket()));
        standardPriceField.setForeground(Color.black);
        standardPriceField.setBounds(150, 180, 100, 25);
        add(standardPriceField);

        executivePrice = new JLabel("Executive Ticket");
        executivePrice.setForeground(Color.ORANGE);
        executivePrice.setBounds(50, 220, 80, 25);
        add(executivePrice);

        executivePriceField = new JTextField((String.valueOf(((MovieItem) obj).getExecutiveTicket())));
        executivePriceField.setForeground(Color.black);
        executivePriceField.setBounds(150, 220, 100, 25);
        add(executivePriceField);

        rating = new JLabel("Ratings");
        rating.setForeground(Color.ORANGE);
        rating.setBounds(50, 260, 80, 25);
        add(rating);

        ratingField = new JTextField((String.valueOf(((MovieItem) obj).getStandardTicket())));
        ratingField.setForeground(Color.black);
        ratingField.setBounds(150, 260, 100, 25);
        add(ratingField);

        MovieItem fu = (MovieItem) obj;
        Icon img= new ImageIcon(fu.getPath());
        imageDisplay=new JLabel();
        imageDisplay.setIcon(img);
        imageDisplay.setForeground(Color.ORANGE);
        imageDisplay.setBounds(300, 80, 200, 200);
        add(imageDisplay);

        updateBtn= new JButton("Update");
        updateBtn.setBackground(Color.ORANGE);
        updateBtn.setBounds(100,300,100,25);
        add(updateBtn);


        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(obj0 instanceof Administrator) {
                    new AdminScreen();
                    dispose();
                }
                else {
                    new MovieList(new TicketSeller());
                    dispose();
                }

            }
        });

        updateBtn.addActionListener(new ActionListener() {
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
                    if(st.matches("-?\\d+(\\.\\d+)?") && et.matches("-?\\d+(\\.\\d+)?") &&  r.matches("-?\\d+(\\.\\d+)?")) {
                        String trash = imageDisplay.getIcon().toString();
                        MovieItem f = new MovieItem(n, g, Double.parseDouble(st), Double.parseDouble(et), Float.parseFloat(r), trash);
                        ArrayListFiling a = new ArrayListFiling();
                        a.UpdateFromFileArray(f,val);
                        JOptionPane.showMessageDialog(null, "THe desired item is updated, Refresh to see the updated list");
                        dispose();
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
