package com.gqf.sm.frame;

import com.gqf.sm.componet.CustomPanel;
import com.gqf.sm.entity.Clazz;
import com.gqf.sm.entity.Department;
import com.gqf.sm.factory.ServiceFactory;
import com.gqf.sm.utils.Aliossutil;
import com.gqf.sm.vo.StudentVo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;
import com.sun.org.apache.xml.internal.security.Init;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
    private  int departmentId = 0;
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
    private JTextField classNameField;
    private JButton 新增班级Button;
    private JComboBox<Department> depCombobox;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private JPanel classToolPanel;
    private JPanel bottom;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField searchField;
    private JButton 搜索Button;
    private JButton 新增学生Button;
    private JButton 批量导入Button;
    private JPanel tablePanel;

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
            showClazz();
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
        depCombobox.addActionListener(e ->{
            int index  = depCombobox.getSelectedIndex();
            departmentId = depCombobox.getItemAt(index).getId();
        });
        新增班级Button.addActionListener(e ->{
            Clazz clazz = new Clazz();
            clazz.setDepartmentId(departmentId);
            clazz.setClassName(classNameField.getText().trim());
            int n = ServiceFactory.getClazzServiceInstance().addClazz(clazz);
            if (n == 1){
                JOptionPane.showMessageDialog(centerPanel,"新增班级成功");
                classNameField.setText("");
                showClazz();
            } else {
                JOptionPane.showMessageDialog(centerPanel,"新增班级失败");
            }
                }

                );
        学生管理Button.addActionListener(e ->{
            c.show(centerPanel,"3");
            showStudents();
                }
                );
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
            delBtn.addActionListener(e->{
                int id = department.getId();
                ServiceFactory.getDepartmentServiceInstance().deleteDepartmentById(id);
                showDepartments();
            });
            contentPanel.add(depPanel);
            contentPanel.revalidate();
        }

    }
 private  void showClazz(){
        List<Department> departments =ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departments);
        showTree(departments);
        showClazz(departments);
 }
  private void  showCombobox(List<Department> departments){
        for (Department department : departments){
            depCombobox.addItem(department);
        }
  }
  private  void  showTree(List<Department> departments){
        treePanel.removeAll();
      DefaultMutableTreeNode root = new DefaultMutableTreeNode("南京工业职业技术大学");
      for (Department department: departments){
          DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
          root.add(group);
          List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
          for (Clazz clazz : clazzList){
              DefaultMutableTreeNode node = new DefaultMutableTreeNode(clazz.getClassName());
              group.add(node);
          }
      }
      final  JTree tree = new JTree(root);
      tree.setRowHeight(30);
      tree.setFont(new Font("微软雅黑",Font.PLAIN,14));
      treePanel.add(tree,BorderLayout.CENTER);
      treePanel.revalidate();
  }
  private void showStudents(){
      CustomPanel stuInfoPanel = new CustomPanel("D:\\Student-manager\\src\\main\\resources\\img\\1.jpg");
      stuInfoPanel.setPreferredSize(new Dimension(300,600));
      JLabel title = new JLabel("学生信息");
      title.setFont(new Font("楷体",Font.BOLD,20));
      title.setForeground(new Color(97,174,239));
     stuInfoPanel.add(title);
      stuInfoPanel.repaint();
      studentPanel.add(stuInfoPanel,BorderLayout.EAST);
      List<StudentVo> students = ServiceFactory.getStudentServiceInstance().getStudentAll();
      JTable table = new JTable();
      DefaultTableModel model   =new DefaultTableModel();
      table.setModel(model);
      model.setColumnIdentifiers(new String[]{"学号", "院系","班级","姓名","性别","地址","手机号","出生日期","头像"});
      for(StudentVo student :students){
          Object[] object = new Object[]{
                  student.getId(), student.getDepartmentName(), student.getClassName(),student.getStudentName(),student.getGender(),
       student.getAddress(), student.getPhone(), student.getBirthday(),student.getAvatar()};
          model.addRow(object);
          TableColumn tc = table.getColumnModel().getColumn(8);
          tc.setMaxWidth(0);
          tc.setMinWidth(0);
          JTableHeader header = table.getTableHeader();
         DefaultTableCellHeaderRenderer hr  = new DefaultTableCellHeaderRenderer();
          hr.setHorizontalTextPosition(JLabel.CENTER);
          header.setDefaultRenderer(hr);
          header.setPreferredSize(new Dimension(header.getWidth(),40));
          header.setFont(new Font("楷体",Font.PLAIN,18));
          table.setRowHeight(35);
          table.setBackground(new Color(223,241,234));
          DefaultTableCellRenderer r = new DefaultTableCellRenderer();
          r.setHorizontalAlignment(JLabel.CENTER);
          table.setDefaultRenderer(Object.class,r);
          JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
  tablePanel.add(scrollPane);
  table.getSelectionModel().addListSelectionListener(e->{
      int row = table.getSelectedRow();
      JOptionPane.showMessageDialog(null,table.getValueAt(row,2).toString()+table.getValueAt(row,3).toString());
  });

      }
  }
  private  void  showClazz(List<Department> departments){
        classContentPanel.removeAll();
      classContentPanel.setLayout(new GridLayout(0,5,15,15));
      Font titleFont = new Font("微软雅黑",Font.PLAIN,16);
      for (Department department :departments){
          JPanel depPanel = new JPanel();
          depPanel.setPreferredSize(new Dimension(120,150));
          depPanel.setBackground(new Color(63,98,131));
          depPanel.setLayout(new BorderLayout());
          JLabel depNameLabel = new JLabel(department.getDepartmentName());
          depNameLabel.setFont(titleFont);
          depNameLabel.setForeground(new Color(255,255,255));
          depPanel.add(depNameLabel,BorderLayout.NORTH);
          List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
          DefaultListModel<Clazz> listModel = new DefaultListModel<>();
          for (Clazz clazz :clazzList){
              listModel.addElement(clazz);
          }
          JList<Clazz> jList = new JList<>(listModel);
          jList.setBackground(new Color(101,134,184));
          JScrollPane scrollPane =  new JScrollPane(jList);
          depPanel.add(scrollPane,BorderLayout.CENTER);
          classContentPanel.add(depPanel);
          JPopupMenu jPopupMenu = new JPopupMenu();
          JMenuItem modifyItem = new JMenuItem("修改");
          JMenuItem deleteItem = new JMenuItem("删除");
          jPopupMenu.add(modifyItem);
          jPopupMenu.add(deleteItem);
          jList.add(jPopupMenu);
          jList.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {

                  int index = jList.getSelectedIndex();
                  if (e.getButton() == 3) {
                      jPopupMenu.show(jList,e.getX(),e.getY());
                      Clazz clazz = jList.getModel().getElementAt(index);
                      deleteItem.addActionListener(e1 -> {
                          int choice = JOptionPane.showConfirmDialog(depPanel, "确定删除么吗?");
                          if (choice == 0) {
                              int n = ServiceFactory.getClazzServiceInstance().deleteClazz(clazz.getId());
                              if (n == 1) {
                                  listModel.remove(index);
                                  showTree(ServiceFactory.getDepartmentServiceInstance().selectAll());
                              }
                          }
                      });
                  }
              }
          });


      }
  }
    public static void main(String[] args) {
        new MainFrame();
    }

}

