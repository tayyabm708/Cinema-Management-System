package com.codewithTayyab;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Invoice extends JFrame {
    JLabel screenTitle;
    JTable ordertable;
    JScrollPane scroll;
    JLabel imglabel;
    JLabel placeorder;
    JLabel movieName;
    JComboBox movieMenu;
    JLabel Tickets;
    JTextField noOfTickets;
    JLabel TicketChoice;
    JRadioButton b1;
    JRadioButton b2;
    JTextArea billinginfo;
    JButton genInvoice;
    JButton addDetails;
    JScrollPane sp;
    double grandtotal=0;
    JButton bckBtn;

    String[] headers = {"Name", "Genre", "Standard Price", "Executive Price", "Rating", "Image"};

    public Invoice(Object obj, ArrayList<MovieItem> store){
        super("Invoice panel");
        setSize(810, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(25,25,25));

        boolean[] check=new boolean[store.size()];

        screenTitle = new JLabel("Invoice");
        screenTitle.setForeground(Color.ORANGE);
        screenTitle.setFont(new Font("Serif", Font.BOLD, 17));
        screenTitle.setBounds(320, 50, 200, 25);
        add(screenTitle,BorderLayout.CENTER);

        bckBtn = new JButton("<");
        bckBtn.setBackground(Color.ORANGE);
        bckBtn.setBounds(20,20, 20, 20);
        bckBtn.setBorder(null);
        add(bckBtn);

        bckBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MovieList(obj);
                dispose();
            }
        });

        ordertable = new JTable();
        DefaultTableModel model = (DefaultTableModel) ordertable.getModel();
        model.setColumnIdentifiers(headers);
        Object[] rowData = new Object[6];

        for (int i = 0; i < store.size(); i++) {
            if (store.get(i) != null) {
                rowData[0] = store.get(i).getName();
                rowData[1] = store.get(i).getGenre();
                rowData[2] = store.get(i).getStandardTicket();
                rowData[3] = store.get(i).getExecutiveTicket();
                rowData[4] = store.get(i).getRating();
                Icon img = new ImageIcon(store.get(i).getPath());
                imglabel = new JLabel();
                imglabel.setIcon(img);
                rowData[5] = imglabel;
                model.addRow(rowData);
            }
        }

        ordertable.getColumn("Image").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });


        ordertable.setModel(model);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        ordertable.getColumn("Name").setCellRenderer(dtcr);
        ordertable.getColumn("Genre").setCellRenderer(dtcr);
        ordertable.getColumn("Standard Price").setCellRenderer(dtcr);
        ordertable.getColumn("Executive Price").setCellRenderer(dtcr);
        ordertable.getColumn("Rating").setCellRenderer(dtcr);
        ordertable.getTableHeader().setBackground(Color.ORANGE);
        ordertable.getTableHeader().setForeground(Color.black);



        ordertable.setRowHeight(100);
        ordertable.setBackground(Color.black);
        ordertable.setForeground(Color.ORANGE);
        ordertable.setFillsViewportHeight(true);


        scroll = new JScrollPane(ordertable);
        scroll.setBounds(100, 100, 600, 130);
        add(scroll);


        placeorder = new JLabel("ORDER SUMMARY");
        placeorder.setForeground(Color.ORANGE);
        placeorder.setBounds(80, 330, 110, 25);
        add(placeorder);

        movieName=new JLabel("Choose Movie ");
        movieName.setForeground(Color.ORANGE);
        movieName.setBounds(80, 380, 100, 25);
        add(movieName);

        movieMenu= new JComboBox();
        movieMenu.setSelectedItem(null);
        movieMenu.setBounds(200,380,100,25);
        movieMenu.setBackground(Color.ORANGE);
        movieMenu.setForeground(Color.black);

        for(int i=0; i<store.size(); i++){
            movieMenu.addItem(store.get(i).getName());
            check[i]=false;
        }

        add(movieMenu);
        Tickets=new JLabel("No of tickets: ");
        Tickets.setForeground(Color.ORANGE);
        Tickets.setBounds(80, 420, 100, 25);
        add(Tickets);

        noOfTickets=new JTextField();
        noOfTickets.setForeground(Color.black);
        noOfTickets.setBounds(200, 420, 100, 25);
        add(noOfTickets);

        TicketChoice=new JLabel("Choose ");
        TicketChoice.setForeground(Color.ORANGE);
        TicketChoice.setBounds(80, 460, 70, 25);
        add(TicketChoice);

        b1=new JRadioButton("Standard");
        b1.setForeground(Color.ORANGE);
        b1.setBackground(Color.black);
        b1.setBounds(160, 460, 80, 25);
        add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(b1.isSelected()){
                    b2.setSelected(false);
                }
            }
        });

        b2=new JRadioButton("Executive");
        b2.setForeground(Color.ORANGE);
        b2.setBackground(Color.black);
        b2.setBounds(250, 460, 100, 25);
        add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(b2.isSelected()){
                    b1.setSelected(false);
                }
            }
        });


        addDetails=new JButton("Add Details");
        addDetails.setBackground(Color.ORANGE);
        addDetails.setForeground(Color.black);
        addDetails.setBounds(100, 530, 120, 25);
        add(addDetails);

        addDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int index = movieMenu.getSelectedIndex();
                double price = 0;
                if (check[index] == false) {
                    if (noOfTickets.getText().matches("-?\\d+(\\.\\d+)?")) {
                        if (!b1.isSelected() && !b2.isSelected()) {
                            JOptionPane.showMessageDialog(null, "Please select whether Standard/Executive");
                        }
                        else if (b1.isSelected()) {
                            price = store.get(index).getStandardTicket();
                            billinginfo.append(System.lineSeparator() + " You booked " + noOfTickets.getText() + " tickets of " + System.lineSeparator() + store.get(index).getName() + " movie with " + b1.getText() + " price " + System.lineSeparator() + " Total: " + String.valueOf((int) price * Integer.parseInt(noOfTickets.getText())));
                            grandtotal = grandtotal + (int) price * Integer.parseInt(noOfTickets.getText());
                            billinginfo.append(System.lineSeparator());
                            JOptionPane.showMessageDialog(null, "Details Added Successfully");
                            check[index] = true;
                        }
                        else if (b2.isSelected()) {
                            price = store.get(index).getExecutiveTicket();
                            billinginfo.append(System.lineSeparator() + " You booked " + noOfTickets.getText() + " tickets of " + System.lineSeparator() + store.get(index).getName() + " movie with " + b2.getText() + " price " + System.lineSeparator() + " Total: " + String.valueOf((int) price * Integer.parseInt(noOfTickets.getText())));
                            grandtotal = grandtotal + (int) price * Integer.parseInt(noOfTickets.getText());
                            billinginfo.append(System.lineSeparator());
                            JOptionPane.showMessageDialog(null, "Details Added Successfully");
                            check[index] = true;
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Enter valid no.of tickets");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "You already entered details for this movie");
                }
            }
        });


        genInvoice=new JButton("Generate Invoice");
        genInvoice.setBackground(Color.ORANGE);
        genInvoice.setForeground(Color.black);
        genInvoice.setBounds(150, 560, 150, 25);
        add(genInvoice);

        billinginfo=new JTextArea();
        billinginfo.setEditable(false);
        billinginfo.setBackground(Color.orange);
        billinginfo.setForeground(Color.black);
        billinginfo.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        billinginfo.setText(" ======================================"+System.lineSeparator()+"   YOUR INVOICE HAS BEEN GENERATED    "+System.lineSeparator()+"  ======================================");

        sp=new JScrollPane(billinginfo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.setBounds(400,350,300,300);
        add(sp);
        sp.setVisible(false);


        genInvoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean display=true;
                for(int i=0; i<check.length; i++){
                    if(!check[i]){
                        JOptionPane.showMessageDialog(null,"Enter details for "+store.get(i).getName()+" movie");
                        display=false;
                        break;
                    }
                }
                if(display){
                    billinginfo.append(System.lineSeparator()+" Grand total: "+String.valueOf(grandtotal));
                    sp.setVisible(true);

                }

            }
        });
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
