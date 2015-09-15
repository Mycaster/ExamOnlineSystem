/*
 * MySetPassWord.java
 *
 * Created on 2008��8��12��, ����5:45
 */

package com.Exam.Index;

import javax.swing.JOptionPane;

import com.Exam.Index.StudentExam;
import com.Exam.bean.*;
import com.Exam.dao.*;

/**
 *
 * @author  Administrator
 */
public class MySetPassWord extends javax.swing.JFrame {

    /** Creates new form MySetPassWord */
    public MySetPassWord() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        userNameJLabel = new javax.swing.JLabel();
        UserjTextField = new javax.swing.JTextField();
        passWordJLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        updetejButton = new javax.swing.JButton();
        closejButton = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        java.io.File file = new java.io.File("save.txt");
        User uses = null;
    	try{
    		java.io.FileInputStream in = new java.io.FileInputStream(file);		
    		byte byt[] = new byte[1024];					
    		int len = in.read(byt);						
    		String strid = new String(byt,0,len);	
    		int id = Integer.parseInt(strid);
    		User user = new User();
    		user.setId(id);
    		MyFindUserDao myfindUser = new MyFindUserDao();
    		uses = myfindUser.getUserID(user);
    		in.close();									
    	}catch (Exception e) {
    		e.printStackTrace();							
    	}
        userNameJLabel.setText("�û�����");

        UserjTextField.setText(ChDeal.toChinese(uses.getUserName()));
        UserjTextField.setEnabled(false);
        passWordJLabel.setText(" �� �룺");

        jPasswordField1.setText(ChDeal.toChinese(uses.getPassWord()));

        jLabel2.setText("ȷ�����룺");

        jPasswordField2.setText(ChDeal.toChinese(uses.getPassWord()));

        updetejButton.setText("�޸�");
        updetejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updetejButtonActionPerformed(evt);
            }
        });

        closejButton.setText("�˳�");
        closejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(userNameJLabel))
                            .addComponent(jLabel2)
                            .addComponent(passWordJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField2)
                            .addComponent(jPasswordField1)
                            .addComponent(UserjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(updetejButton)
                        .addGap(35, 35, 35)
                        .addComponent(closejButton)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameJLabel)
                    .addComponent(UserjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passWordJLabel)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closejButton)
                    .addComponent(updetejButton))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

private void updetejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updetejButtonActionPerformed
	if(jPasswordField1.equals("")||(jPasswordField2.equals(""))){
		JOptionPane.showMessageDialog(this, "���벻��Ϊ�գ�","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		return;
	}
	if(!jPasswordField1.getText().equals(jPasswordField2.getText())){
		JOptionPane.showMessageDialog(this, "���벻һ��","��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		return;
	}
	java.io.File file = new java.io.File("save.txt");
    User uses = null;
	try{
		java.io.FileInputStream in = new java.io.FileInputStream(file);		
		byte byt[] = new byte[1024];					
		int len = in.read(byt);						
		String strid = new String(byt,0,len);	
		int id = Integer.parseInt(strid);
		User user = new User();
		user.setId(id);
		MyFindUserDao myfindUser = new MyFindUserDao();
		uses = myfindUser.getUserID(user);
		user.setPassWord(jPasswordField1.getText());
		InsertUserDao inseruser = new InsertUserDao();
		boolean bool = inseruser.updateUserPassWord(uses);
		if(bool == true){
			JOptionPane.showMessageDialog(this, "�����޸ĳɹ���", "��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		}
		in.close();									
	}catch (Exception e) {
		e.printStackTrace();							
	}
	
}
private void formWindowClosing(java.awt.event.WindowEvent evt) {
	dispose();
	StudentExam studentExam = new StudentExam();
	studentExam.setVisible(true);
	studentExam.setBounds(150, 150, 400, 300);
}
private void closejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closejButtonActionPerformed
	dispose();
	StudentExam studentExam = new StudentExam();
	studentExam.setVisible(true);
	studentExam.setBounds(150, 150, 400, 300);
}


    private javax.swing.JTextField UserjTextField;
    private javax.swing.JButton closejButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JLabel passWordJLabel;
    private javax.swing.JButton updetejButton;
    private javax.swing.JLabel userNameJLabel;
 }