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

	private Font laFont=new Font("宋体", Font.BOLD, 100);
	private Font btFont=new Font("宋体", Font.BOLD, 25);
	JButton addJButton=new JButton("添加");
	JButton deleteJButton=new JButton("删除");
	JButton updateJButton=new JButton("修改");
	JButton selectJButton=new JButton("查询");
	
	JLabel jlabel=new JLabel("手术室信息");

	client ct=new client();
	
    public operation_room_frame(String str) {
    	super(str);
    	this.setLayout(null);
    	this.setVisible(true);
		this.setLocationRelativeTo(null);
		///this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//对四个按钮进行排版
		
		this.add(jlabel);//患者ID
		jlabel.setBounds(150, 50, 550,100 );
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
			JTextField nameJTextField = new JTextField("是否正在手术");//通过患者姓名查询信息
			JButton selectJButton1=new JButton("查询");
			JTextField dataJTextField = new JTextField();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					Frame select_roomframe=new Frame("查询页面");
					select_roomframe.setLayout(null);
					select_roomframe.setVisible(true);
					select_roomframe.setLocationRelativeTo(null);
					
					select_roomframe.add(nameJTextField);//患者ID
					nameJTextField.setBounds(50, 100, 300,40 );
					nameJTextField.setFont(btFont);
					
					select_roomframe.add(selectJButton1);//患者ID
					selectJButton1.setBounds(400, 100, 120,40 );
					selectJButton1.setFont(btFont);
					
					select_roomframe.add(dataJTextField);//患者ID
					dataJTextField.setBounds(50, 200,600,300 );
					dataJTextField.setFont(btFont);
					
					selectJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String panameString=nameJTextField.getText().toString();//将患者姓名框里的数字读取
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
					//安排查询按钮的行为监听
					//查询按钮的行为监听为根据姓名找到所有信息，在下面的Jtext显示所有信息。
					
				
			
				
			}
		});
		
	   deleteJButton.addActionListener(new ActionListener() {
			//与查找框相比只改变姓名为id，且没有下面的框
		 //  JLabel pateleJLabel=new JLabel("患者电话");
			JTextField teleJTextField = new JTextField("手术室编号");//通过患者姓名查询信息
			JButton deleteJButton1=new JButton("删除");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					Frame delete_operationtframe=new Frame("删除页面");
					delete_operationtframe.setLayout(null);
					delete_operationtframe.setVisible(true);
					delete_operationtframe.setLocationRelativeTo(null);
					
					delete_operationtframe.add(teleJTextField);//患者ID
					teleJTextField.setBounds(50, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					delete_operationtframe.add(deleteJButton1);//患者ID
					deleteJButton1.setBounds(400, 100, 120,40 );
					deleteJButton1.setFont(btFont);
					
					deleteJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String panameString=teleJTextField.getText().toString();//将患者姓名框里的数字读取
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
			JTextField Ope_room_idJTextField=new JTextField("手术室编号");
			JTextField If_operatJTextField=new JTextField("是否正在手术");
			JTextField patientJTextField=new JTextField("患者编号");
			JTextField  MainDoctor_idJTextField=new JTextField("主刀医生编号");

			JTextField teleJTextField = new JTextField("手术室编号");//通过患者姓名查询信息

			JButton updateJButton1=new JButton("修改");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
					Frame updata_operaframe=new Frame("修改页面");
					updata_operaframe.setLayout(null);
					updata_operaframe.setVisible(true);
					updata_operaframe.setLocationRelativeTo(null);
					
					updata_operaframe.add(teleJTextField);//患者电话查询
					teleJTextField.setBounds(100, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					
					updata_operaframe.add(Ope_room_idJTextField);//患者姓名
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

				
     				updata_operaframe.add(updateJButton1);//患者ID
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
			
			JTextField Ope_room_idJTextField=new JTextField("手术室编号");
			JTextField If_operatJTextField=new JTextField("是否正在手术");
			JTextField patientJTextField=new JTextField("患者编号");
			JTextField  MainDoctor_idJTextField=new JTextField("主刀医生编号");

			
			JButton addJButton1=new JButton("添加");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Frame add_operationframe=new Frame("添加页面");
					add_operationframe.setLayout(null);
					add_operationframe.setVisible(true);
					add_operationframe.setLocationRelativeTo(null);
					
					add_operationframe.add(Ope_room_idJTextField);//患者姓名
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


                    add_operationframe.add(addJButton1);//患者ID
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
