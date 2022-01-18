package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.Locale;

public class MainFrame extends JFrame{
    JPanel window=new JPanel();
    JButton addButton=new JButton("Add");
    Listener listener=new Listener();

    public void update(){
        Component[] mas=window.getComponents();
        for(int i=0;i<mas.length;i++){
            window.remove(mas[i]);
        }
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
                "root",Config.password)){
            System.out.println("Connection successfully");
            Statement statement=connection.createStatement();
            statement.executeUpdate("use products;");
            statement.executeUpdate("Delete from store where amount = 0");
            ResultSet rs=statement.executeQuery("Select * from store;");
            while (rs.next()){
                StorePanel SP=new StorePanel(rs);
                SP.buyButton.addMouseListener(listener);
                window.add(SP);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        repaint();
        revalidate();
    }

    public MainFrame(){

        setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        window.setLayout(new FlowLayout());
        add(window, BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);
        window.setBackground(new Color(255,193,206));
        addButton.setPreferredSize(new Dimension(100,50));
        try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
                "root",Config.password)){
            System.out.println("Connection successfully");
            Statement statement=connection.createStatement();
            statement.executeUpdate("use products;");
            ResultSet rs=statement.executeQuery("Select * from store;");
            while (rs.next()){
                StorePanel SP=new StorePanel(rs);
                SP.buyButton.addMouseListener(listener);
                window.add(SP);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        setVisible(true);
        addButton.addMouseListener(listener);
        window.repaint();
    }

    class Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getComponent() == addButton){
                String name = JOptionPane.showInputDialog(addButton,"Input name").toLowerCase(Locale.ROOT);
                int price=Integer.parseInt(JOptionPane.showInputDialog(addButton,"Input price"));
                int weight=Integer.parseInt(JOptionPane.showInputDialog(addButton,"Input weight"));
                int amount=Integer.parseInt(JOptionPane.showInputDialog(addButton,"Input amount"));
                try(Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
                        "root",Config.password)){
                    System.out.println("Connection successfully");
                    Statement statement=connection.createStatement();
                    statement.executeUpdate("use products");
                    statement.executeUpdate("Insert store(name,cost,weight,amount) values('"+name+"',"+price+","+weight+","+amount+");");
                }catch (SQLException throwables){
                    throwables.printStackTrace();
                }
            }
            update();
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
