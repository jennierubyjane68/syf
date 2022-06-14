package front;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class doctor_frame extends Frame{

	public JLabel jlabel=new JLabel("ҽ����Ϣ");
	private Font laFont=new Font("����", Font.BOLD, 100);
	private Font btFont=new Font("����", Font.BOLD, 25);
	JButton addJButton=new JButton("���");
	JButton deleteJButton=new JButton("ɾ��");
	JButton updateJButton=new JButton("�޸�");
	JButton selectJButton=new JButton("��ѯ");
	
	client ct=new client();


    public doctor_frame(String str) {
    	super(str);
    	this.setLayout(null);
    	this.setVisible(true);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ĸ���ť�����Ű�
		
		this.add(jlabel);//����ID
		jlabel.setBounds(200, 50, 450,100 );
		jlabel.setFont(laFont);
		
		this.add(selectJButton);//���Ұ�ť
		selectJButton.setBounds(120, 300, 120, 50);
		selectJButton.setFont(btFont);
		
		
		this.add(addJButton);//��Ӱ�ť
		addJButton.setBounds(260, 300, 120, 50);
		addJButton.setFont(btFont);
		
		this.add(deleteJButton);//ɾ����ť
		deleteJButton.setBounds(400, 300, 120, 50);
		deleteJButton.setFont(btFont);
		
		
		this.add(updateJButton);//���°�ť
		updateJButton.setBounds(540, 300, 120, 50);
		updateJButton.setFont(btFont);
		
		selectJButton.addActionListener(new ActionListener() {
			JTextField nameJTextField = new JTextField("�Ƿ���������");//ͨ������������ѯ��Ϣ
			JButton selectJButton1=new JButton("��ѯ");
			JTextField dataJTextField = new JTextField();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					Frame select_doctorframe=new Frame("��ѯҳ��");
					select_doctorframe.setLayout(null);
					select_doctorframe.setVisible(true);
					select_doctorframe.setLocationRelativeTo(null);
					
					select_doctorframe.add(nameJTextField);//����ID
					nameJTextField.setBounds(50, 100, 300,40 );
					nameJTextField.setFont(btFont);
					
					select_doctorframe.add(selectJButton1);//����ID
					selectJButton1.setBounds(400, 100, 120,40 );
					selectJButton1.setFont(btFont);
					
					select_doctorframe.add(dataJTextField);//����ID
					dataJTextField.setBounds(50, 200,600,300 );
					dataJTextField.setFont(btFont);
					
					selectJButton1.addActionListener(new ActionListener() {
						  
						public void actionPerformed(ActionEvent e) {
							
							String panameString=nameJTextField.getText().toString();//������������������ֶ�ȡ
							String str = null;
							try {
								str = ct.client("doctor_select"+','+panameString);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							dataJTextField.setText(str);
					//���Ų�ѯ��ť����Ϊ����
					//��ѯ��ť����Ϊ����Ϊ���������ҵ�������Ϣ���������Jtext��ʾ������Ϣ��
					
						}
			
						});
			}
		});
		
	   deleteJButton.addActionListener(new ActionListener() {
			//����ҿ����ֻ�ı�����Ϊid����û������Ŀ�
		 //  JLabel pateleJLabel=new JLabel("���ߵ绰");
			JTextField teleJTextField = new JTextField("ҽ�����");//ͨ������������ѯ��Ϣ
			JButton deleteJButton1=new JButton("ɾ��");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					Frame delete_doctortframe=new Frame("ɾ��ҳ��");
					delete_doctortframe.setLayout(null);
					delete_doctortframe.setVisible(true);
					delete_doctortframe.setLocationRelativeTo(null);
					
					delete_doctortframe.add(teleJTextField);//����ID
					teleJTextField.setBounds(50, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					delete_doctortframe.add(deleteJButton1);//����ID
					deleteJButton1.setBounds(400, 100, 120,40 );
					deleteJButton1.setFont(btFont);
					
					deleteJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String panameString=teleJTextField.getText().toString();//������������������ֶ�ȡ
							String str = null;
							try {
								str = ct.client("doctor_delete"+','+panameString);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null, str);
					
						}
					});	
				
					
			
				
			}
		});
		
		updateJButton.addActionListener(new ActionListener() {
			
			JTextField Doctor_idJTextField=new JTextField("ҽ�����");
			JTextField Doctor_nameJTextField=new JTextField("ҽ������");
			JTextField If_operatJTextField=new JTextField("�Ƿ���������");
			JTextField Ope_room_idJTextField=new JTextField("�����ұ��");
			JTextField teleJTextField = new JTextField("ҽ�����");//ͨ������������ѯ��Ϣ

			JButton updateJButton1=new JButton("�޸�");
			
			@Override
			public void actionPerformed(ActionEvent e) {

					Frame updata_patientframe=new Frame("�޸�ҳ��");
					updata_patientframe.setLayout(null);
					updata_patientframe.setVisible(true);
					updata_patientframe.setLocationRelativeTo(null);
					
					updata_patientframe.add(teleJTextField);//���ߵ绰��ѯ
					teleJTextField.setBounds(100, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					
					updata_patientframe.add(Doctor_idJTextField);//��������
					Doctor_idJTextField.setBounds(100,160, 200, 50);
					Doctor_idJTextField.setFont(btFont);

					updata_patientframe.add(Doctor_nameJTextField);
					Doctor_nameJTextField.setBounds(330, 160, 200, 50);
					Doctor_nameJTextField.setFont(btFont);

					updata_patientframe.add(If_operatJTextField);
                    If_operatJTextField.setBounds(100, 250, 200, 50);
                    If_operatJTextField.setFont(btFont);

					updata_patientframe.add(Ope_room_idJTextField);
					Ope_room_idJTextField.setBounds(330, 250, 200, 50);
					Ope_room_idJTextField.setFont(btFont);


					updata_patientframe.add(updateJButton1);//����ID
					updateJButton1.setBounds(330, 340, 120,50 );
					updateJButton1.setFont(btFont);

					updateJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String teleText=teleJTextField.getText().toString();
							String Patient_idText=Doctor_idJTextField.getText().toString();
							String Patient_nameText=Doctor_nameJTextField.getText().toString();
							String If_operatText=If_operatJTextField.getText().toString();
							String Ope_room_idText=Ope_room_idJTextField.getText().toString();

							String str=null;
							
							try {
								str = ct.client("doctor_update"+','+teleText+','+Patient_idText+','+Patient_nameText+','+If_operatText+','+Ope_room_idText);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								
							JOptionPane.showMessageDialog(null, str);

						}
					});
				
			}
		});
		addJButton.addActionListener(new ActionListener() {
			
			JTextField Doctor_idJTextField=new JTextField("ҽ�����");
			JTextField Doctor_nameJTextField=new JTextField("ҽ������");
			JTextField If_operatJTextField=new JTextField("�Ƿ���������");
			JTextField Ope_room_idJTextField=new JTextField("�����ұ��");

		
			
			JButton addJButton1=new JButton("���");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Frame add_doctorframe=new Frame("���ҳ��");
					add_doctorframe.setLayout(null);
					add_doctorframe.setVisible(true);
					add_doctorframe.setLocationRelativeTo(null);
					
					add_doctorframe.add(Doctor_idJTextField);//��������
					Doctor_idJTextField.setBounds(100,160, 200, 50);
					Doctor_idJTextField.setFont(btFont);

					add_doctorframe.add(Doctor_nameJTextField);
					Doctor_nameJTextField.setBounds(330, 160, 200, 50);
					Doctor_nameJTextField.setFont(btFont);

					add_doctorframe.add(If_operatJTextField);
                    If_operatJTextField.setBounds(100, 240, 200, 50);
                    If_operatJTextField.setFont(btFont);
                    
                    add_doctorframe.add(Ope_room_idJTextField);
                    Ope_room_idJTextField.setBounds(330, 240, 200, 50);
                    Ope_room_idJTextField.setFont(btFont);

			        add_doctorframe.add(addJButton1);//����ID
					addJButton1.setBounds(330, 340, 120,50 );
					addJButton1.setFont(btFont);

					addJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String Patient_idText=Doctor_idJTextField.getText().toString();
							String Patient_nameText=Doctor_nameJTextField.getText().toString();
							String If_operatText=If_operatJTextField.getText().toString();
							String Ope_room_idText=Ope_room_idJTextField.getText().toString();

							String str=null;
							
							try {
								str = ct.client("doctor_add"+','+Patient_idText+','+Patient_nameText+','+If_operatText+','+Ope_room_idText);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
								
							JOptionPane.showMessageDialog(null, str);
						}
					});
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
    
	
}
}
