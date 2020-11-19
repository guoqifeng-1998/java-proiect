package com.gqf.sm.frame;

import com.gqf.sm.entity.Department;
import com.gqf.sm.factory.ServiceFactory;
import com.gqf.sm.utils.Aliossutil;
import com.sun.org.apache.xml.internal.security.Init;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.util.*;
import java.util.List;


/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author Finger
 * @Date 11/15/2020
 **/
public class MainFrame extends JFrame {
    private String uploadFileUrl;
    private File file;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel bottomPanel;
    private JPanel addDepPanel;
    private JButton 选择图片Button;
    private JLabel logoLabel;
    private JPanel toolBarPanel;
    private JButton 新增院系Button;
    private JButton 切换显示Button;
    private JPanel contentPanel;
    private JTextField depNameField;
    private JButton 新增Button;

    private final CardLayout c;


    public MainFrame() {
        init();
        院系管理Button.setOpaque(false);
        班级管理Button.setOpaque(false);
        学生管理Button.setOpaque(false);
        奖惩管理Button.setOpaque(false);
        c = new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1", departmentPanel);
        centerPanel.add("2", classPanel);
        centerPanel.add("3", studentPanel);
        centerPanel.add("4", rewardPanel);
        院系管理Button.addActionListener(e -> {
            c.show(centerPanel, "1");
        });
        班级管理Button.addActionListener(e -> {
            c.show(centerPanel, "2");
        });
        学生管理Button.addActionListener(e -> {
            c.show(centerPanel, "3");
        });
        奖惩管理Button.addActionListener(e -> {
            c.show(centerPanel, "4");
        });
        showDepartments();
        新增院系Button.addActionListener(e ->{
            boolean visible = addDepPanel.isVisible();
            if(!visible){
                leftPanel.setPreferredSize(new Dimension(180,this.getHeight()-100));
                addDepPanel.setVisible(true);
            } else {
                leftPanel.setPreferredSize(new Dimension(60,this.getHeight()-100));
                addDepPanel.setVisible(false);
            }
            leftPanel.revalidate();
        });
        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });
        选择图片Button.addActionListener(e ->{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:\\tools"));
            int result = fileChooser.showOpenDialog(centerPanel);
            if(result == JFileChooser.APPROVE_OPTION){
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(150,150));
                icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(),logoLabel.getHeight(),Image.SCALE_DEFAULT));
                logoLabel.setIcon(icon);
            }
        });
        新增Button.addActionListener(e ->{
            uploadFileUrl = Aliossutil.ossUpload(file);
            Department department = new Department();
            department.setDepartmentName(depNameField.getText().trim());
            department.setLogo(uploadFileUrl);
            int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if (n ==1){
                JOptionPane.showMessageDialog(centerPanel,"新增院系成功");
                leftPanel.setPreferredSize(new Dimension(60,this.getHeight() - 100));
                addDepPanel.setVisible(false);
                showDepartments();
                depNameField.setText("");
                logoLabel.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(centerPanel,"新增院系失败");
            }
        });
    }
    public void  init(){
        this.setTitle("管理员");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
    private  void showDepartments(){
        contentPanel.removeAll();
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        int len = departmentList.size();
        int row = len % 4 == 0 ? len /4 : len /4 +1;
        GridLayout gridLayout = new GridLayout(row,4,15,15);
        contentPanel.setLayout(gridLayout);
        for ( Department department : departmentList){
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(200,290));
            depPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15 ,10));
            JLabel nameLabel = new JLabel(department.getDepartmentName());
            JLabel logoLabel = new JLabel("<html><img src = '" + department.getLogo() + "' height = '200' width = '200'/></html>");
            JLabel blankLabel = new JLabel();
            blankLabel.setPreferredSize(new Dimension(200,30));
            JButton delBtn = new JButton("删除");
            depPanel.add(nameLabel);
            depPanel.add(logoLabel);
            depPanel.add(delBtn);
            contentPanel.add(depPanel);
            contentPanel.revalidate();
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }

}

