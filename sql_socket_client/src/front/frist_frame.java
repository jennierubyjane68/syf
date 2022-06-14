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

	private Font laFont=new Font("����", Font.BOLD, 100);
	private Font btFont=new Font("����", Font.BOLD, 25);
	JButton doctorJButton=new JButton("ҽ����Ϣ");
	JButton patientJButton=new JButton("������Ϣ");
	JButton operation_roomJButton=new JButton("��������Ϣ");
	
	
	JLabel jlabel=new JLabel("�����Ұ���ϵͳ");
    
    public frist_frame(String str) {
    	super(str);
    	this.setLayout(null);
    	this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ĸ���ť�����Ű�
		
		this.add(jlabel);//����ID
		jlabel.setBounds(50, 50, 750,100 );
		jlabel.setFont(laFont);
		
		this.add(doctorJButton);//���Ұ�ť
		doctorJButton.setBounds(150, 300, 180, 50);
		doctorJButton.setFont(btFont);
		
		
		this.add(patientJButton);//��Ӱ�ť
		patientJButton.setBounds(350, 300, 180, 50);
		patientJButton.setFont(btFont);
		
		this.add(operation_roomJButton);//ɾ����ť
		operation_roomJButton.setBounds(550, 300, 180, 50);
		operation_roomJButton.setFont(btFont);
		
		
		
		doctorJButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//��ҽ����Ϣ����
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
					//�򿪲�����Ϣ����
					patient_frame pat=new patient_frame("hauznhe");
				}
					
				 catch (Exception e2) {
					System.out.println(e2);
				}
			
				
			}
		});
		
		operation_roomJButton.addActionListener(new ActionListener() {
			//�ʼ��ҳ��	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					//����������Ϣ����
					operation_room_frame ope=new operation_room_frame("hauznhe");
		
							
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		
		
    }
    
    
}
