package front;

import java.awt.Color;
import java.awt.Font;
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



public class operation_room_frame extends Frame{

	private Font laFont=new Font("����", Font.BOLD, 100);
	private Font btFont=new Font("����", Font.BOLD, 25);
	JButton addJButton=new JButton("���");
	JButton deleteJButton=new JButton("ɾ��");
	JButton updateJButton=new JButton("�޸�");
	JButton selectJButton=new JButton("��ѯ");
	
	JLabel jlabel=new JLabel("��������Ϣ");

	client ct=new client();
	
    public operation_room_frame(String str) {
    	super(str);
    	this.setLayout(null);
    	this.setVisible(true);
		this.setLocationRelativeTo(null);
		///this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ĸ���ť�����Ű�
		
		this.add(jlabel);//����ID
		jlabel.setBounds(150, 50, 550,100 );
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
				
					Frame select_roomframe=new Frame("��ѯҳ��");
					select_roomframe.setLayout(null);
					select_roomframe.setVisible(true);
					select_roomframe.setLocationRelativeTo(null);
					
					select_roomframe.add(nameJTextField);//����ID
					nameJTextField.setBounds(50, 100, 300,40 );
					nameJTextField.setFont(btFont);
					
					select_roomframe.add(selectJButton1);//����ID
					selectJButton1.setBounds(400, 100, 120,40 );
					selectJButton1.setFont(btFont);
					
					select_roomframe.add(dataJTextField);//����ID
					dataJTextField.setBounds(50, 200,600,300 );
					dataJTextField.setFont(btFont);
					
					selectJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String panameString=nameJTextField.getText().toString();//������������������ֶ�ȡ
							String str = null;
							try {
								str = ct.client("operation_select"+','+panameString);
							} catch (UnknownHostException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							dataJTextField.setText(str);
							
						}
					});
					//���Ų�ѯ��ť����Ϊ����
					//��ѯ��ť����Ϊ����Ϊ���������ҵ�������Ϣ���������Jtext��ʾ������Ϣ��
					
				
			
				
			}
		});
		
	   deleteJButton.addActionListener(new ActionListener() {
			//����ҿ����ֻ�ı�����Ϊid����û������Ŀ�
		 //  JLabel pateleJLabel=new JLabel("���ߵ绰");
			JTextField teleJTextField = new JTextField("�����ұ��");//ͨ������������ѯ��Ϣ
			JButton deleteJButton1=new JButton("ɾ��");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					Frame delete_operationtframe=new Frame("ɾ��ҳ��");
					delete_operationtframe.setLayout(null);
					delete_operationtframe.setVisible(true);
					delete_operationtframe.setLocationRelativeTo(null);
					
					delete_operationtframe.add(teleJTextField);//����ID
					teleJTextField.setBounds(50, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					delete_operationtframe.add(deleteJButton1);//����ID
					deleteJButton1.setBounds(400, 100, 120,40 );
					deleteJButton1.setFont(btFont);
					
					deleteJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String panameString=teleJTextField.getText().toString();//������������������ֶ�ȡ
							String str = null;
							try {
								str = ct.client("operation_delete"+','+panameString);
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
			JTextField Ope_room_idJTextField=new JTextField("�����ұ��");
			JTextField If_operatJTextField=new JTextField("�Ƿ���������");
			JTextField patientJTextField=new JTextField("���߱��");
			JTextField  MainDoctor_idJTextField=new JTextField("����ҽ�����");

			JTextField teleJTextField = new JTextField("�����ұ��");//ͨ������������ѯ��Ϣ

			JButton updateJButton1=new JButton("�޸�");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
					Frame updata_operaframe=new Frame("�޸�ҳ��");
					updata_operaframe.setLayout(null);
					updata_operaframe.setVisible(true);
					updata_operaframe.setLocationRelativeTo(null);
					
					updata_operaframe.add(teleJTextField);//���ߵ绰��ѯ
					teleJTextField.setBounds(100, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					
					updata_operaframe.add(Ope_room_idJTextField);//��������
					Ope_room_idJTextField.setBounds(100,160, 200, 50);
					Ope_room_idJTextField.setFont(btFont);

					updata_operaframe.add(If_operatJTextField);
					If_operatJTextField.setBounds(330, 160, 200, 50);
					If_operatJTextField.setFont(btFont);

					updata_operaframe.add(patientJTextField);
					patientJTextField.setBounds(330, 250, 200, 50);
					patientJTextField.setFont(btFont);
					
			
                    updata_operaframe.add(MainDoctor_idJTextField);
     				MainDoctor_idJTextField.setBounds(100, 250, 200, 50);
     				MainDoctor_idJTextField.setFont(btFont);

				
     				updata_operaframe.add(updateJButton1);//����ID
					updateJButton1.setBounds(330, 340, 120,50 );
					updateJButton1.setFont(btFont);

					updateJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							String teleText=teleJTextField.getText().toString();
							String Ope_room_idText=Ope_room_idJTextField.getText().toString();
							String If_operatText=If_operatJTextField.getText().toString();
							String patient_idText=patientJTextField.getText().toString();
							String MainDoctor_idText=MainDoctor_idJTextField.getText().toString();

							
							String str=null;
							
							try {
								str = ct.client("operation_update"+','+teleText+','+Ope_room_idText+','+If_operatText+','+MainDoctor_idText+','+patient_idText);
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
			
			JTextField Ope_room_idJTextField=new JTextField("�����ұ��");
			JTextField If_operatJTextField=new JTextField("�Ƿ���������");
			JTextField patientJTextField=new JTextField("���߱��");
			JTextField  MainDoctor_idJTextField=new JTextField("����ҽ�����");

			
			JButton addJButton1=new JButton("���");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Frame add_operationframe=new Frame("���ҳ��");
					add_operationframe.setLayout(null);
					add_operationframe.setVisible(true);
					add_operationframe.setLocationRelativeTo(null);
					
					add_operationframe.add(Ope_room_idJTextField);//��������
					Ope_room_idJTextField.setBounds(100,160, 200, 50);
					Ope_room_idJTextField.setFont(btFont);

					add_operationframe.add(If_operatJTextField);
					If_operatJTextField.setBounds(330, 160, 200, 50);
					If_operatJTextField.setFont(btFont);

					
                    add_operationframe.add(MainDoctor_idJTextField);
                    MainDoctor_idJTextField.setBounds(100, 250, 200, 50);
                    MainDoctor_idJTextField.setFont(btFont);
                    
                    add_operationframe.add(patientJTextField);
                    patientJTextField.setBounds(330, 250, 200, 50);
                    patientJTextField.setFont(btFont);


                    add_operationframe.add(addJButton1);//����ID
					addJButton1.setBounds(330, 340, 120,50 );
					addJButton1.setFont(btFont);

					addJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String Ope_room_idText=Ope_room_idJTextField.getText().toString();
							String If_operatText=If_operatJTextField.getText().toString();
							String MainDoctor_idText=MainDoctor_idJTextField.getText().toString();
							String patientText=patientJTextField.getText().toString();

							
							String str=null;
							
							try {
								str = ct.client("operation_add"+','+Ope_room_idText+','+If_operatText+','+MainDoctor_idText+','+patientText);
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
