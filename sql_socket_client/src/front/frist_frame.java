package front;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class frist_frame extends Frame{

	private Font laFont=new Font("宋体", Font.BOLD, 100);
	private Font btFont=new Font("宋体", Font.BOLD, 25);
	JButton doctorJButton=new JButton("医生信息");
	JButton patientJButton=new JButton("患者信息");
	JButton operation_roomJButton=new JButton("手术室信息");
	
	
	JLabel jlabel=new JLabel("手术室安排系统");
    
    public frist_frame(String str) {
    	super(str);
    	this.setLayout(null);
    	this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//对四个按钮进行排版
		
		this.add(jlabel);//患者ID
		jlabel.setBounds(50, 50, 750,100 );
		jlabel.setFont(laFont);
		
		this.add(doctorJButton);//查找按钮
		doctorJButton.setBounds(150, 300, 180, 50);
		doctorJButton.setFont(btFont);
		
		
		this.add(patientJButton);//添加按钮
		patientJButton.setBounds(350, 300, 180, 50);
		patientJButton.setFont(btFont);
		
		this.add(operation_roomJButton);//删除按钮
		operation_roomJButton.setBounds(550, 300, 180, 50);
		operation_roomJButton.setFont(btFont);
		
		
		
		doctorJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//打开医生信息界面
					doctor_frame doc=new doctor_frame("yisheng");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
				
			}
		});
		
		patientJButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					//打开病人信息界面
					patient_frame pat=new patient_frame("hauznhe");
				}
					
				 catch (Exception e2) {
					System.out.println(e2);
				}
			
				
			}
		});
		
		operation_roomJButton.addActionListener(new ActionListener() {
			//最开始的页面	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					//打开手术室信息界面
					operation_room_frame ope=new operation_room_frame("hauznhe");
		
							
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		
		
    }
    
    
}
