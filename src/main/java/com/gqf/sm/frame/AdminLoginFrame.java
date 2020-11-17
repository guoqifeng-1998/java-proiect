package com.gqf.sm.frame;


import com.gqf.sm.factory.ServiceFactory;
import com.gqf.sm.utils.ResultEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName AdminLoginFrame
 * @Description TODO
 * @Author Finger
 * @Date 11/15/2020
 **/
public class AdminLoginFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton loginBtn;
    private JButton resetBtn;

    public AdminLoginFrame(){
        this.setTitle("AdminLoginFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        loginBtn.addActionListener(e ->{
            String account = accountField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account,password);
            JOptionPane.showMessageDialog(mainPanel,resultEntity.getMessage());
            if (resultEntity.getCode() == 0){
                this.dispose();
                new MainFrame();
            }else{
                accountField.setText("");
                passwordField.setText("");
            }
        });

        resetBtn.addActionListener(e->{
            accountField.setText("");
            passwordField.setText("");
        });
    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }
}
