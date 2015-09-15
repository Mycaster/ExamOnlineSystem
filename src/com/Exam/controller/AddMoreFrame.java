/*
 * AddRadioFrame.java
 *
 * Created on 2008年8月9日, 下午2:45
 */

package com.Exam.controller;
import javax.swing.JOptionPane;
import com.Exam.bean.*;
import com.Exam.dao.FindQuestionDao;

/**
 *
 * @author  Administrator
 */
public class AddMoreFrame extends javax.swing.JFrame { // 多选题

    /** Creates new form AddRadioFrame */
    public AddMoreFrame() {// 构造方法
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {// 初始化方法

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        messageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        NameJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        NamejTextArea = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        answerJLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        optionATextField = new javax.swing.JTextField();
        answerB = new javax.swing.JLabel();
        optionBTextField = new javax.swing.JTextField();
        answerC = new javax.swing.JLabel();
        optionCTextField = new javax.swing.JTextField();
        answerC1 = new javax.swing.JLabel();
        optionDTextField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        addjButton = new javax.swing.JButton();
        resButton = new javax.swing.JButton();
        noteTextField = new javax.swing.JTextField();
        closejButton = new javax.swing.JButton();
        jLabel2.setText("jLabel2");
        setSize(400, 600);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        messageLabel.setText("增加多选题模块，要填满一下所有各项。");
        FindQuestionDao findDao = new FindQuestionDao();
        java.util.List list = findDao.findQuestion();
        int id = 0;// 题目编号
        if(list.size()>0){
        	for(int i = 0 ;i<list.size();i++){
        		Question question = (Question)list.get(i);
        		id = question.getId();// 获取list集合中所有的试题id
        	}
        }
        jLabel1.setText("题目编号：");
        idTextField.setText(""+(id+1));
        idTextField.setEditable(false);
        NameJLabel.setText("题目题目：");
        NamejTextArea.setColumns(20);
        NamejTextArea.setRows(5);
        jScrollPane1.setViewportView(NamejTextArea);
        answerJLabel.setText("备选答案区：");
        jLabel3.setText("答案A：");
        answerB.setText("答案B：");
        answerC.setText("答案C：");
        answerC1.setText("答案D：");
        jLabel4.setText("答案：");
        jLabel5.setText("备 注:");
        addjButton.setText("添加");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });

        resButton.setText("重置");
        resButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resButtonActionPerformed(evt);
            }
        });

        closejButton.setText("退出");
        closejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	closejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(addjButton)
                .addGap(18, 18, 18)
                .addComponent(resButton)
                .addGap(18, 18, 18)
                .addComponent(closejButton)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(answerC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(answerB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(answerC1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(noteTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(optionDTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(optionCTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(optionBTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                .addComponent(optionATextField, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
                            .addGap(48, 48, 48))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(answerJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(NameJLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                            .addGap(48, 48, 48)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(NameJLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(optionATextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerB)
                    .addComponent(optionBTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerC)
                    .addComponent(optionCTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answerC1)
                    .addComponent(optionDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addjButton)
                    .addComponent(resButton)
                    .addComponent(closejButton))
                .addContainerGap(31, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }
private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {
	if(NamejTextArea.getText().equals("")){
		JOptionPane.showMessageDialog(this, "试题题目不能为空", "信息对话框",JOptionPane.WARNING_MESSAGE);
		return;
	}
	if(optionATextField.getText().equals("")){
		JOptionPane.showMessageDialog(this, "选项A不能为空", "信息对话框",JOptionPane.WARNING_MESSAGE);
		return;
	}
	if(optionBTextField.getText().equals("")){
		JOptionPane.showMessageDialog(this, "选项B不能为空", "信息对话框",JOptionPane.WARNING_MESSAGE);
		return;
	}
	if(optionCTextField.getText().equals("")){
		JOptionPane.showMessageDialog(this, "选项C不能为空", "信息对话框",JOptionPane.WARNING_MESSAGE);
		return;
	}
	if(optionDTextField.getText().equals("")){
		JOptionPane.showMessageDialog(this, "选项D不能为空", "信息对话框",JOptionPane.WARNING_MESSAGE);
		return;
	}
	if(noteTextField.getText().equals("")){
		JOptionPane.showMessageDialog(this, "需要添加备注", "信息对话框",JOptionPane.WARNING_MESSAGE);
		return;
	}
	if((jTextField1.getText().length()>1)&&(jTextField1.getText().indexOf(",")== -1)){
		JOptionPane.showMessageDialog(this, "多选题要求答案格式如：'A,B,C,D'", "信息对话框",JOptionPane.WARNING_MESSAGE);
		return;
	}
	FindQuestionDao findQuestion = new FindQuestionDao();
	Question question = new Question();
	question.setId(Integer.parseInt(idTextField.getText()));
	question.setQ_subject(ChDeal.toISO(NamejTextArea.getText()));
	question.setQ_answer(ChDeal.toISO(jTextField1.getText()));
	question.setOptionA(ChDeal.toISO(optionATextField.getText()));
	QuestionType questionType = new QuestionType();
	questionType.setQName(ChDeal.toISO("多选题"));
	QuestionType qtype = findQuestion.getQuestionTypeID(questionType);
	question.setTypeid(qtype.getId());
	question.setOptionB(ChDeal.toISO(optionBTextField.getText()));
	question.setOptionC(ChDeal.toISO(optionCTextField.getText()));
	question.setOptionD(ChDeal.toISO(optionDTextField.getText()));
	question.setNote(noteTextField.getText());
	boolean bool = findQuestion.setQuestionDBbean(question);
	if( bool== true ){
		JOptionPane.showMessageDialog(this, "信息添加成功","信息对话框", JOptionPane.WARNING_MESSAGE);
		dispose();
		ControllerFrame controllerFrame = new ControllerFrame();
		controllerFrame.setVisible(true);
	}
}
private void resButtonActionPerformed(java.awt.event.ActionEvent evt) {
	NamejTextArea.setText("");
	jTextField1.setText("");
	optionATextField.setText("");
	optionBTextField.setText("");
	optionCTextField.setText("");
	optionDTextField.setText("");
	
}
private void closejButtonActionPerformed(java.awt.event.ActionEvent evt) {
	dispose();
	ControllerFrame controller = new ControllerFrame();
	controller.setVisible(true);
	controller.setBounds(100, 200, 650, 450);
} 
private void formWindowClosing(java.awt.event.WindowEvent evt) {
	dispose();
	ControllerFrame controll = new ControllerFrame();
	controll.setVisible(true);
}
	/**
    * @param args the command line arguments
    */
   
    private javax.swing.JLabel NameJLabel;
    private javax.swing.JButton addjButton;
    private javax.swing.JLabel answerB;
    private javax.swing.JLabel answerC;
    private javax.swing.JLabel answerC1;
    private javax.swing.JLabel answerJLabel;
    private javax.swing.JButton closejButton;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea NamejTextArea;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField noteTextField;
    private javax.swing.JTextField optionATextField;
    private javax.swing.JTextField optionBTextField;
    private javax.swing.JTextField optionCTextField;
    private javax.swing.JTextField optionDTextField;
    private javax.swing.JButton resButton;
}
