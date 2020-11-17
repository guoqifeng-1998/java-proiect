package com.gqf.sm.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author Finger
 * @Date 11/15/2020
 **/
public class MainFrame extends JFrame {
    private JPanel mainPanel;

    public MainFrame(){
        this.setTitle("MainFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
