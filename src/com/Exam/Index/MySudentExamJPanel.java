package com.Exam.Index;

import java.awt.*;

import java.net.URL;

import javax.swing.*;
public class MySudentExamJPanel extends JPanel {

public void	paintComponent(Graphics g){
	try{ 
		URL url = getClass().getResource("/image/StudentMain.JPG");
		ImageIcon image = new ImageIcon(url);
		g.drawImage(image.getImage(), 0, 0, this); 		
		}catch(Exception e){} 
	}
}
