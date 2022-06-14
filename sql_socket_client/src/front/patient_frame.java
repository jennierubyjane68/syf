package front;


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



public class patient_frame extends Frame{

	private Font laFont=new Font("����", Font.BOLD, 100);
	private Font btFont=new Font("����", Font.BOLD, 25);
	JButton addJButton=new JButton("���");
	JButton deleteJButton=new JButton("ɾ��");
	JButton updateJButton=new JButton("�޸�");
	JButton selectJButton=new JButton("��ѯ");
	
	JLabel jlabel=new JLabel("������Ϣ");

	client ct=new client();
    
    public patient_frame(String str) {
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
			JLabel panameJLabel=new JLabel("��������");
			JTextField nameJTextField = new JTextField("��������");//ͨ������������ѯ��Ϣ
			JButton selectJButton1=new JButton("��ѯ");
			JTextField dataJTextField = new JTextField();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					Frame select_patientframe=new Frame("��ѯҳ��");
					select_patientframe.setLayout(null);
					select_patientframe.setVisible(true);
					select_patientframe.setLocationRelativeTo(null);
					
					select_patientframe.add(nameJTextField);//����ID
					nameJTextField.setBounds(50, 100, 300,40 );
					nameJTextField.setFont(btFont);
					
					select_patientframe.add(selectJButton1);//����ID
					selectJButton1.setBounds(400, 100, 120,40 );
					selectJButton1.setFont(btFont);
					
					select_patientframe.add(dataJTextField);//����ID
					dataJTextField.setBounds(50, 200,600,300 );
					dataJTextField.setFont(btFont);
					
					selectJButton1.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
								String panameString=nameJTextField.getText().toString();//������������������ֶ�ȡ
								String str = null;
								try {
									str = ct.client("patient_select"+','+panameString);
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
			JTextField teleJTextField = new JTextField("���߱��");//ͨ������������ѯ��Ϣ
			JButton deleteJButton1=new JButton("ɾ��");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
					Frame delete_patientframe=new Frame("ɾ��ҳ��");
					delete_patientframe.setLayout(null);
					delete_patientframe.setVisible(true);
					delete_patientframe.setLocationRelativeTo(null);
					
					delete_patientframe.add(teleJTextField);//����ID
					teleJTextField.setBounds(50, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					delete_patientframe.add(deleteJButton1);//����ID
					deleteJButton1.setBounds(400, 100, 120,40 );
					deleteJButton1.setFont(btFont);
					
					deleteJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							

							String panameString=teleJTextField.getText().toString();//������������������ֶ�ȡ
							String str = null;
							try {
								str = ct.client("patient_delete"+','+panameString);
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
			
			JTextField panameJTextField=new JTextField("��������");
			JTextField paidJTextField=new JTextField("���߱��");
			JTextField If_operatJTextField=new JTextField("�Ƿ���������");
			JTextField PaidJTextField = new JTextField("���߱��");//ͨ������������ѯ��Ϣ

			JButton updateJButton1=new JButton("�޸�");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
					Frame updata_patientframe=new Frame("�޸�ҳ��");
					updata_patientframe.setLayout(null);
					updata_patientframe.setVisible(true);
					updata_patientframe.setLocationRelativeTo(null);
					
					updata_patientframe.add(PaidJTextField);//���ߵ绰��ѯ
					PaidJTextField.setBounds(100, 100, 300,40 );
					PaidJTextField.setFont(btFont);
					
					
					updata_patientframe.add(panameJTextField);//��������
					panameJTextField.setBounds(330, 160, 200, 50);
					panameJTextField.setFont(btFont);

					updata_patientframe.add(paidJTextField);
					paidJTextField.setBounds(100,160, 200, 50);
					paidJTextField.setFont(btFont);

					updata_patientframe.add(If_operatJTextField);
                    If_operatJTextField.setBounds(560, 160, 200, 50);
                    If_operatJTextField.setFont(btFont);

                 
					updata_patientframe.add(updateJButton1);//����ID
					updateJButton1.setBounds(330, 340, 120,50 );
					updateJButton1.setFont(btFont);

					updateJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {String paidText=PaidJTextField.getText().toString();
						String Patient_idText=paidJTextField.getText().toString();
						String Patient_nameText=panameJTextField.getText().toString();
						String If_operatText=If_operatJTextField.getText().toString();
						
						String str=null;
						
						try {
							str = ct.client("patient_update"+','+paidText+','+Patient_idText+','+Patient_nameText+','+If_operatText);
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
			
			JTextField panameJTextField=new JTextField("��������");
			JTextField paidJTextField=new JTextField("���߱��");
			JTextField If_operatJTextField=new JTextField("�Ƿ���������");

			JButton addJButton1=new JButton("���");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
					Frame add_patientframe=new Frame("���ҳ��");
					add_patientframe.setLayout(null);
					add_patientframe.setVisible(true);
					add_patientframe.setLocationRelativeTo(null);
					
					add_patientframe.add(panameJTextField);//��������
					panameJTextField.setBounds(330,160, 200, 50);
					panameJTextField.setFont(btFont);

					add_patientframe.add(paidJTextField);//��������
					paidJTextField.setBounds(100,160, 200, 50);
					paidJTextField.setFont(btFont);

					add_patientframe.add(If_operatJTextField);
                    If_operatJTextField.setBounds(560, 160, 200, 50);
                    If_operatJTextField.setFont(btFont);


			        add_patientframe.add(addJButton1);//����ID
					addJButton1.setBounds(330, 340, 120,50 );
					addJButton1.setFont(btFont);

					addJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
							String Patient_idText=paidJTextField.getText().toString();
								String Patient_nameText=panameJTextField.getText().toString();
								String If_operatText=If_operatJTextField.getText().toString();
								
								String str=null;
								
								try {
									str = ct.client("patient_add"+','+Patient_idText+','+Patient_nameText+','+If_operatText);
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
    
    
    
}
		}
    
