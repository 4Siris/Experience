package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class StorePanel extends JPanel {
    JLabel name=new JLabel();
    JLabel info=new JLabel();
    JLabel amount=new JLabel();
    JButton buyButton=new JButton("Buy");
    public StorePanel(ResultSet store) throws SQLException {
        name.setText(store.getString("name"));
        info.setText("Price: "+store.getInt("cost")+"byn for "+store.getInt("weight")+"kg");
        amount.setText(store.getString("amount"));
        setLayout(new BorderLayout());
        add(name, BorderLayout.NORTH);
        add(info, BorderLayout.CENTER);
        add(amount, BorderLayout.SOUTH);
        buyButton.setPreferredSize(new Dimension(60,5));
        Listener buttonListener=new Listener();
        buyButton.addMouseListener(buttonListener);
        add(buyButton, BorderLayout.EAST);
        setPreferredSize(new Dimension(200,100));
        setBackground(new Color(255,255,255));
        name.setFont(new Font("Arial", Font.BOLD, 30));
        info.setFont(new Font("Arial", Font.ITALIC, 10));
        amount.setFont(new Font("Arial", Font.BOLD, 10));
    }

    class Listener implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getComponent()==buyButton){
                try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
                        "root",Config.password)){
                    System.out.println("Connection successfully");
                    Statement statement=connection.createStatement();
                    statement.execute("Use products");
                    statement.executeUpdate("Update store Set amount = amount - 1 where name = '"+name.getText()+"';");
                }catch (SQLException throwables){
                    throwables.printStackTrace();
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}