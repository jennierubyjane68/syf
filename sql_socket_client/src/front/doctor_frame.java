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

	public JLabel jlabel=new JLabel("医生信息");
	private Font laFont=new Font("宋体", Font.BOLD, 100);
	private Font btFont=new Font("宋体", Font.BOLD, 25);
	JButton addJButton=new JButton("添加");
	JButton deleteJButton=new JButton("删除");
	JButton updateJButton=new JButton("修改");
	JButton selectJButton=new JButton("查询");
	
	client ct=new client();


    public doctor_frame(String str) {
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
			JTextField nameJTextField = new JTextField("是否正在手术");//通过患者姓名查询信息
			JButton selectJButton1=new JButton("查询");
			JTextField dataJTextField = new JTextField();
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					Frame select_doctorframe=new Frame("查询页面");
					select_doctorframe.setLayout(null);
					select_doctorframe.setVisible(true);
					select_doctorframe.setLocationRelativeTo(null);
					
					select_doctorframe.add(nameJTextField);//患者ID
					nameJTextField.setBounds(50, 100, 300,40 );
					nameJTextField.setFont(btFont);
					
					select_doctorframe.add(selectJButton1);//患者ID
					selectJButton1.setBounds(400, 100, 120,40 );
					selectJButton1.setFont(btFont);
					
					select_doctorframe.add(dataJTextField);//患者ID
					dataJTextField.setBounds(50, 200,600,300 );
					dataJTextField.setFont(btFont);
					
					selectJButton1.addActionListener(new ActionListener() {
						  
						public void actionPerformed(ActionEvent e) {
							
							String panameString=nameJTextField.getText().toString();//将患者姓名框里的数字读取
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
					//安排查询按钮的行为监听
					//查询按钮的行为监听为根据姓名找到所有信息，在下面的Jtext显示所有信息。
					
						}
			
						});
			}
		});
		
	   deleteJButton.addActionListener(new ActionListener() {
			//与查找框相比只改变姓名为id，且没有下面的框
		 //  JLabel pateleJLabel=new JLabel("患者电话");
			JTextField teleJTextField = new JTextField("医生编号");//通过患者姓名查询信息
			JButton deleteJButton1=new JButton("删除");
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					Frame delete_doctortframe=new Frame("删除页面");
					delete_doctortframe.setLayout(null);
					delete_doctortframe.setVisible(true);
					delete_doctortframe.setLocationRelativeTo(null);
					
					delete_doctortframe.add(teleJTextField);//患者ID
					teleJTextField.setBounds(50, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					delete_doctortframe.add(deleteJButton1);//患者ID
					deleteJButton1.setBounds(400, 100, 120,40 );
					deleteJButton1.setFont(btFont);
					
					deleteJButton1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							String panameString=teleJTextField.getText().toString();//将患者姓名框里的数字读取
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
			
			JTextField Doctor_idJTextField=new JTextField("医生编号");
			JTextField Doctor_nameJTextField=new JTextField("医生姓名");
			JTextField If_operatJTextField=new JTextField("是否正在手术");
			JTextField Ope_room_idJTextField=new JTextField("手术室编号");
			JTextField teleJTextField = new JTextField("医生编号");//通过患者姓名查询信息

			JButton updateJButton1=new JButton("修改");
			
			@Override
			public void actionPerformed(ActionEvent e) {

					Frame updata_patientframe=new Frame("修改页面");
					updata_patientframe.setLayout(null);
					updata_patientframe.setVisible(true);
					updata_patientframe.setLocationRelativeTo(null);
					
					updata_patientframe.add(teleJTextField);//患者电话查询
					teleJTextField.setBounds(100, 100, 300,40 );
					teleJTextField.setFont(btFont);
					
					
					updata_patientframe.add(Doctor_idJTextField);//患者姓名
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


					updata_patientframe.add(updateJButton1);//患者ID
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
			
			JTextField Doctor_idJTextField=new JTextField("医生编号");
			JTextField Doctor_nameJTextField=new JTextField("医生姓名");
			JTextField If_operatJTextField=new JTextField("是否正在手术");
			JTextField Ope_room_idJTextField=new JTextField("手术室编号");

		
			
			JButton addJButton1=new JButton("添加");
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Frame add_doctorframe=new Frame("添加页面");
					add_doctorframe.setLayout(null);
					add_doctorframe.setVisible(true);
					add_doctorframe.setLocationRelativeTo(null);
					
					add_doctorframe.add(Doctor_idJTextField);//患者姓名
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

			        add_doctorframe.add(addJButton1);//患者ID
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
