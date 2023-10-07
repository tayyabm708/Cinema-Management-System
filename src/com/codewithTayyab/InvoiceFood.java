package com.codewithTayyab;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InvoiceFood extends JFrame {
    JLabel screenTitle;
    JTable ordertable;
    JScrollPane scroll;
    JLabel imglabel1;
    JLabel placeorder;
    JLabel foodName;
    JComboBox foodMenu;
    JLabel Quantity;
    JTextField noOfItems;
    JLabel itemChoice;
    JRadioButton b1;
    JRadioButton b2;
    JRadioButton b3;
    JTextArea billinginfo;
    JButton genInvoice;
    JButton addDetails;
    JScrollPane sp;
    double grandtotal=0;
    JButton bckBtn;


    String[] headers = {"Name", "Small Price", "Medium Price", "Large Price", "Image"};

    public InvoiceFood(Object obj, ArrayList<FoodItem> store){
        super("Invoice panel");
        setSize(810, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.black);

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
                new FoodList(obj);
                dispose();
            }
        });

        ordertable = new JTable();
        DefaultTableModel model = (DefaultTableModel) ordertable.getModel();
        model.setColumnIdentifiers(headers);
        Object[] rowData = new Object[5];

        for (int i = 0; i < store.size(); i++) {
            if (store.get(i) != null) {
                rowData[0] = store.get(i).getName();
                rowData[1] = store.get(i).getsPrice();
                rowData[2] = store.get(i).getmPrice();
                rowData[3] = store.get(i).getlPrice();
                Icon img1 = new ImageIcon(store.get(i).getPathname());
                imglabel1 = new JLabel();
                imglabel1.setIcon(img1);
                rowData[4] = imglabel1;
                model.addRow(rowData);
            }
        }

        ordertable.getColumn("Image").setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable ordertable, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                return (Component) value;
            }
        });

        ordertable.setModel(model);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(SwingConstants.CENTER);
        ordertable.getColumn("Name").setCellRenderer(dtcr);
        ordertable.getColumn("Small Price").setCellRenderer(dtcr);
        ordertable.getColumn("Medium Price").setCellRenderer(dtcr);
        ordertable.getColumn("Large Price").setCellRenderer(dtcr);
        ordertable.getTableHeader().setBackground(Color.ORANGE);
        ordertable.getTableHeader().setForeground(Color.black);

        ordertable.getColumn("Image").setWidth(200);
        ordertable.setRowHeight(120);
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

        foodName =new JLabel("Choose Item");
        foodName.setForeground(Color.ORANGE);
        foodName.setBounds(80, 380, 100, 25);
        add(foodName);

        foodMenu = new JComboBox();
        foodMenu.setSelectedItem(null);
        foodMenu.setBounds(200,380,100,25);
        foodMenu.setBackground(Color.ORANGE);
        foodMenu.setForeground(Color.black);

        for(int i=0; i<store.size(); i++){
            foodMenu.addItem(store.get(i).getName());
            check[i]=false;
        }

        add(foodMenu);
        Quantity =new JLabel("Quantity: ");
        Quantity.setForeground(Color.ORANGE);
        Quantity.setBounds(80, 420, 100, 25);
        add(Quantity);

        noOfItems =new JTextField();
        noOfItems.setForeground(Color.black);
        noOfItems.setBounds(200, 420, 100, 25);
        add(noOfItems);

        itemChoice =new JLabel("Choose ");
        itemChoice.setForeground(Color.ORANGE);
        itemChoice.setBounds(80, 460, 70, 25);
        add(itemChoice);

        b1=new JRadioButton("Small");
        b1.setForeground(Color.ORANGE);
        b1.setBackground(Color.black);
        b1.setBounds(160, 460, 60, 25);
        add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(b1.isSelected()){
                    b2.setSelected(false);
                    b3.setSelected(false);
                }
            }
        });

        b2=new JRadioButton("Medium");
        b2.setForeground(Color.ORANGE);
        b2.setBackground(Color.black);
        b2.setBounds(220, 460, 80, 25);
        add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(b2.isSelected()){
                    b1.setSelected(false);
                    b3.setSelected(false);
                }
            }
        });

        b3=new JRadioButton("Large");
        b3.setForeground(Color.ORANGE);
        b3.setBackground(Color.black);
        b3.setBounds(300, 460, 60, 25);
        add(b3);

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(b3.isSelected()){
                    b1.setSelected(false);
                    b2.setSelected(false);
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
                int index = foodMenu.getSelectedIndex();
                double price = 0;
                if (check[index] == false) {
                    if (noOfItems.getText().matches("-?\\d+(\\.\\d+)?")) {
                        if (!b1.isSelected() && !b2.isSelected() && !b3.isSelected()) {
                            JOptionPane.showMessageDialog(null, "Please select whether small/ medium or large");
                        }
                        else if (b1.isSelected()) {
                            price = store.get(index).getsPrice();
                            billinginfo.append(System.lineSeparator() + " You ordered " + noOfItems.getText() + " items of " + System.lineSeparator() + store.get(index).getName() + " with " + b1.getText() + " price " + System.lineSeparator() + " Total: " + String.valueOf((int) price * Integer.parseInt(noOfItems.getText())));
                            grandtotal = grandtotal + (int) price * Integer.parseInt(noOfItems.getText());
                            billinginfo.append(System.lineSeparator());
                            JOptionPane.showMessageDialog(null, "Details Added Successfully");
                            check[index] = true;
                        }
                        else if (b2.isSelected()) {
                            price = store.get(index).getmPrice();
                            billinginfo.append(System.lineSeparator() + " You ordered " + noOfItems.getText() + " items of " + System.lineSeparator() + store.get(index).getName() + " with " + b2.getText() + " price " + System.lineSeparator() + " Total: " + String.valueOf((int) price * Integer.parseInt(noOfItems.getText())));
                            grandtotal = grandtotal + (int) price * Integer.parseInt(noOfItems.getText());
                            billinginfo.append(System.lineSeparator());
                            JOptionPane.showMessageDialog(null, "Item Added Successfully");
                            check[index] = true;
                        }

                        else if(b3.isSelected()){
                            price = store.get(index).getlPrice();
                            billinginfo.append(System.lineSeparator() + " You ordered " + noOfItems.getText() + " items of " + System.lineSeparator() + store.get(index).getName() + " with " + b2.getText() + " price " + System.lineSeparator() + " Total: " + String.valueOf((int) price * Integer.parseInt(noOfItems.getText())));
                            grandtotal = grandtotal + (int) price * Integer.parseInt(noOfItems.getText());
                            billinginfo.append(System.lineSeparator());
                            JOptionPane.showMessageDialog(null, "Item Added Successfully");
                            check[index] = true;

                        }

                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Invalid quantity!");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(null, "You already entered details for this item");
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
                        JOptionPane.showMessageDialog(null,"Enter details for "+store.get(i).getName()+" Food");
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
