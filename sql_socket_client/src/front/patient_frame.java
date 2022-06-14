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

	private Font laFont=new Font("宋体", Font.BOLD, 100);
	private Font btFont=new Font("宋体", Font.BOLD, 25);
	JButton addJButton=new JButton("添加");
	JButton deleteJButton=new JButton("删除");
	JButton updateJButton=new JButton("修改");
	JButton selectJButton=new JButton("查询");
	
	JLabel jlabel=new JLabel("患者信息");

	client ct=new client();
    
    public patient_frame(String str) {
    	super(str);
    	this.setLayout(null);
    	this.setVisible(true);
		this.setLocationRelativeTo(null);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//对四个按钮进行排版
		
		this.add(jlabel);//患者ID
		jlabel.setBounds(200, 50, 450,100 );
		jlabel.setFont(laFont);
		
		this.add(selectJButton);//查找按钮
		selectJButton.setBounds(120, 300, 120, 50);
		selectJButton.setFont(btFont);
		
		
		this.add(addJButton);//添加按钮
		addJButton.setBounds(260, 300, 120, 50);
		addJButton.setFont(btFont);
		
		this.add(deleteJButton);//删除按钮
		deleteJButton.setBounds(400, 300, 120, 50);
		deleteJButton.setFont(btFont);
		
		
		this.add(updateJButton);//更新按钮
		updateJButton.setBounds(540, 300, 120, 50);
		updateJButton.setFont(btFont);
		
		selectJButton.addActionListener(new ActionListener() {
			JLabel panameJLabel=new JLabel("患者姓名");
			JTextField nameJTextField = new JTextField("患者姓名");//通过患者姓名查询信息
			JButton selectJButton1=new JButton("查询");
			JTextField dataJTextField = new JTextField();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					Frame select_patientframe=new Frame("查询页面");
					select_patientframe.setLayout(null);
					select_patientframe.setVisible(true);
					select_patientframe.setLocationRelativeTo(null);
					
					select_patientframe.add(nameJTextField);//患者ID
					nameJTextField.setBounds(50, 100, 300,40 );
					nameJTextField.setFont(btFont);
					
					select_patientframe.add(selectJButton1);//患者ID
					selectJButton1.setBounds(400, 100, 120,40 );
					selectJButton1.setFont(btFont);
					
					select_patientframe.add(dataJTextField);//患者ID
					dataJTextField.setBounds(50, 200,600,300 );
					dataJTextField.setFont(btFont);
					
					selectJButton1.addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
								String panameString=nameJTextField.getText().toString();//将患者姓名框里的数字读取
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
					//安排查询按钮的行为监听
					//查询按钮的行为监听为根据姓名找到所有信息，在下面的Jtext显示所有信息。
					
				}
		});
		
	   deleteJButton.addActionListener(new ActionListener() {
			//与查找框相比只改变姓名为id，且没有下面的框
		 //  JLabel pateleJLabel=new JLabel("患者电话");
			JTextField teleJTextField = new JTextField("患者编号");//通过患者姓名查询信息
			JButton deleteJButton1=new JButton("删除");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
					Frame delete_patientframe=new Frame("删除页面");
					delete_patientframe.setLayout(null);
					delete_patientframe.setVisible(true);
					delete_patientframe.setLocationRelativeTo(null);
					
					delete_patientframe.add(teleJTextField);//患者ID
					teleJTextField.setBounds(50, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					delete_patientframe.add(deleteJButton1);//患者ID
					deleteJButton1.setBounds(400, 100, 120,40 );
					deleteJButton1.setFont(btFont);
					
					deleteJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							

							String panameString=teleJTextField.getText().toString();//将患者姓名框里的数字读取
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
			
			JTextField panameJTextField=new JTextField("患者姓名");
			JTextField paidJTextField=new JTextField("患者编号");
			JTextField If_operatJTextField=new JTextField("是否正在手术");
			JTextField PaidJTextField = new JTextField("患者编号");//通过患者姓名查询信息

			JButton updateJButton1=new JButton("修改");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
					Frame updata_patientframe=new Frame("修改页面");
					updata_patientframe.setLayout(null);
					updata_patientframe.setVisible(true);
					updata_patientframe.setLocationRelativeTo(null);
					
					updata_patientframe.add(PaidJTextField);//患者电话查询
					PaidJTextField.setBounds(100, 100, 300,40 );
					PaidJTextField.setFont(btFont);
					
					
					updata_patientframe.add(panameJTextField);//患者姓名
					panameJTextField.setBounds(330, 160, 200, 50);
					panameJTextField.setFont(btFont);

					updata_patientframe.add(paidJTextField);
					paidJTextField.setBounds(100,160, 200, 50);
					paidJTextField.setFont(btFont);

					updata_patientframe.add(If_operatJTextField);
                    If_operatJTextField.setBounds(560, 160, 200, 50);
                    If_operatJTextField.setFont(btFont);

                 
					updata_patientframe.add(updateJButton1);//患者ID
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
			
			JTextField panameJTextField=new JTextField("患者姓名");
			JTextField paidJTextField=new JTextField("患者编号");
			JTextField If_operatJTextField=new JTextField("是否正在手术");

			JButton addJButton1=new JButton("添加");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
					Frame add_patientframe=new Frame("添加页面");
					add_patientframe.setLayout(null);
					add_patientframe.setVisible(true);
					add_patientframe.setLocationRelativeTo(null);
					
					add_patientframe.add(panameJTextField);//患者姓名
					panameJTextField.setBounds(330,160, 200, 50);
					panameJTextField.setFont(btFont);

					add_patientframe.add(paidJTextField);//患者姓名
					paidJTextField.setBounds(100,160, 200, 50);
					paidJTextField.setFont(btFont);

					add_patientframe.add(If_operatJTextField);
                    If_operatJTextField.setBounds(560, 160, 200, 50);
                    If_operatJTextField.setFont(btFont);


			        add_patientframe.add(addJButton1);//患者ID
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
    
