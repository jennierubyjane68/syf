package behind;
import java.io.*;import java.net.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class server {
	private static ServerSocket server;
	
	public static void main(String[] args) throws IOException{
		server= new ServerSocket(1100);
		System.out.println("�����������ɹ����ȴ��û�����...");//�ȴ��û����룬ֱ�����û�����Ϊֹ��Socket�����ʾ�ͻ���
		Socket client =server.accept();//�õ�����ͻ��˵�IP��ַ

		System.out.println("�пͻ��˽��룬�ͻ�IP��" +client.getInetAddress());

		InputStream in= client.getInputStream();//�ӿͻ����������������������ڽ����������������

		OutputStream out= client.getOutputStream();//�ӿͻ���������������������������ݷ��͵�������

		byte[] bt = new byte[1024];//����һ���ֽ����飬�����洢��������

		int len = in.read(bt);//����������д���ֽ�����

		String data = new String(bt, 0 , len);//����������ת��Ϊ�ַ�������

		System.out.println("���Կͻ��˵���Ϣ��" +data);
		
		out.write(sql(data).getBytes());//�����������ݷ���(���ֽ�������ʽ)

		client.close();//�ر��׽���
		
	}

	public static String sql(String data) {
		String[] tokens=new String[10];
		String result=null;
		
		Connect connect = new Connect();
	    Connection con = connect.getConnection();
	    
	    doctor doctor=new doctor();
	    patient pa=new patient();
	    operation_room ope=new operation_room();
	    
	    tokens=data.split(",");
	
		if(tokens[0].equals("doctor_select")) {
			try {
				String sql="select * from doctor where If_operat=?";
				PreparedStatement pStatement=con.prepareStatement(sql);
				pStatement .setString(1, tokens[1]);
				ResultSet Set=pStatement.executeQuery();
				
				System.out.print("adasd");
				
				while (Set.next()) {//�ĳɳ���ѯ����
					doctor.setDoctor_id(Set.getInt("Doctor_id")) ;
					doctor.setDoctor_name(Set.getString("Doctor_name")) ;
					doctor.setIf_operat(Set.getString("If_operat")) ;
					doctor.setOpe_room_id(Set.getInt("Ope_room_id"));
					result=result+doctor.toString()+'\'';	
				}
				System.out.print("ad");
			}catch(Exception e2) {
				
			}
		}else if(tokens[0].equals("doctor_delete")) {
			
			try {
				String s1="delete from doctor where Doctor_id=?";
				PreparedStatement ps=con.prepareStatement(s1);
				ps.setString(1, tokens[1]);
				ps.executeUpdate();
				result="ɾ���ɹ�";
				}catch(Exception e2) {
					
				}

		}else if(tokens[0].equals("doctor_update")) {
			try {
				
				String s1="update doctor set Doctor_id=?,Doctor_name=?,If_operat=?,Ope_room_id=? where Doctor_id=?";
				PreparedStatement pStatement=con.prepareStatement(s1);
				String teleText=tokens[1];
				String Doctor_idText=tokens[2];
				String Doctor_nameText=tokens[3];
				String If_operatText=tokens[4];
				String Ope_room_idText=tokens[5];
				
				

				pStatement.setString(1, Doctor_idText);
				pStatement.setString(2, Doctor_nameText);
				pStatement.setString(3, If_operatText);
				pStatement.setString(4, Ope_room_idText);
				pStatement.setString(5, teleText);
				
				pStatement.executeUpdate();
				
				result="�޸ĳɹ�";

			}catch(Exception e2) {
				
			}
		}else if(tokens[0].equals("doctor_add")) {
			try {
				String s1="insert into doctor values(?,?,?,?)";
				PreparedStatement pStatement=con.prepareStatement(s1);
				String Doctor_idText=tokens[1];
				String Doctor_nameText=tokens[2];
				String If_operatText=tokens[3];
				String Ope_room_idText=tokens[4];
				
				pStatement.setString(1, Doctor_idText);
				pStatement.setString(2, Doctor_nameText);
				pStatement.setString(3, If_operatText);
				pStatement.setString(4, Ope_room_idText);
				
				pStatement.executeUpdate();
				result="��ӳɹ�";

			}catch(Exception e2) {
				
			}
		}else if(tokens[0].equals("patient_select")) {
			try {
				String panameString=tokens[1];//������������������ֶ�ȡ
				String sql="select * from patient where patient_name=?";
				PreparedStatement pStatement=con.prepareStatement(sql);
				pStatement .setString(1, panameString);
				ResultSet Set=pStatement.executeQuery();
				
				while (Set.next()) {
					pa.setPatient_id(Set.getInt("Patient_id")) ;
					pa.setPatient_name(Set.getString("Patient_name")) ;
					pa.setIf_operat(Set.getString("If_operat")) ;
					result=result+pa.toString()+'\n';	
				}
			}catch(Exception e2) {
				
			}
			
		}else if(tokens[0].equals("patient_delete")) {
			try {
				String s1="delete from patient where Patient_id=?";
				PreparedStatement ps=con.prepareStatement(s1);
				String teleJText=tokens[1];
				ps.setString(1, teleJText);
				ps.executeUpdate();
				result="ɾ���ɹ�";	
				}catch(Exception e2) {
					
				}
			
		}else if(tokens[0].equals("patient_update")) {
			try {
				
				String s1="update patient set Patient_id=?,Patient_name=?,If_operat=? where Patient_id=?";
				PreparedStatement pStatement=con.prepareStatement(s1);
				String teleText=tokens[1];
				String Patient_idText=tokens[2];
				String Patient_nameText=tokens[3];
				String If_operatText=tokens[4];
				

				pStatement.setString(1, Patient_idText);
				pStatement.setString(2, Patient_nameText);
				pStatement.setString(3, If_operatText);
				pStatement.setString(4, teleText);
				
				pStatement.executeUpdate();
				
				result="�޸ĳɹ�";

			}catch(Exception e2) {
				
			}
		}else if(tokens[0].equals("patient_add")) {
			try {
				String s1="insert into patient values(?,?,?)";
				PreparedStatement pStatement=con.prepareStatement(s1);
				String Patient_nameText=tokens[1];
				String Patient_ageText=tokens[2];
				String If_operatText=tokens[3];
			
	
				pStatement.setString(1, Patient_nameText);
				pStatement.setString(2, Patient_ageText);
				pStatement.setString(3, If_operatText);
		

				pStatement.executeUpdate();
				result="��ӳɹ�";
			
			}catch(Exception e2) {
				
			}
		}else if(tokens[0].equals("operation_select")) {
			try {
				String sql="select * from operation_room where If_operat=?";
				PreparedStatement pStatement=con.prepareStatement(sql);
				pStatement .setString(1, tokens[1]);
				ResultSet Set=pStatement.executeQuery();
				
				while (Set.next()) {//�ĳɳ���ѯ����
					ope.setOpe_room_id(Set.getInt("Ope_room_id")) ;
					ope.setIf_operat(Set.getString("If_operat")) ;
					ope.setMainDoctor_id(Set.getInt("MainDoctor_id"));
					ope.setPatient_id(Set.getInt("Patient_id"));
					
					result=result+ope.toString()+'\'';	
				}
				
			}catch(Exception e2) {
				
			}
		}else if(tokens[0].equals("operation_delete")) {
			try {
				String s1="delete from operation_room where Ope_room_id=?";
				PreparedStatement ps=con.prepareStatement(s1);
				String teleJText=tokens[1];
				ps.setString(1, teleJText);
				ps.executeUpdate();
				result="ɾ���ɹ�";	
				}catch(Exception e2) {
					
				}
		}else if(tokens[0].equals("operation_update")) {
			try {
				
				String s1="update operation_room set Ope_room_id=?,If_operat=?,MainDoctor_id=?, Patient_id=? where Ope_room_id=?";
				PreparedStatement pStatement=con.prepareStatement(s1);
				String teleText=tokens[1];
				String Ope_room_idText=tokens[2];
				String If_operatText=tokens[3];
				String MainDoctor_idText=tokens[4];
				String Patient_idText=tokens[5];
			
				pStatement.setString(1, Ope_room_idText);
				pStatement.setString(2, If_operatText);
				pStatement.setString(3, MainDoctor_idText);
				pStatement.setString(4, Patient_idText);
		    	pStatement.setString(5, teleText);
		    	
				
				pStatement.executeUpdate();
				
				result="�޸ĳɹ�";

			}catch(Exception e2) {
				
			}
		}else if(tokens[0].equals("operation_add")) {
			try {
				String s1="insert into operation_room values(?,?,?,?)";
				PreparedStatement pStatement=con.prepareStatement(s1);
				String Ope_room_idText=tokens[1];
				String If_operatText=tokens[2];
				String MainDoctor_idText=tokens[3];
				String Patient_idText=tokens[4];
				

				pStatement.setString(1, Ope_room_idText);
				pStatement.setString(2, If_operatText);
				pStatement.setString(3, MainDoctor_idText);
				pStatement.setString(4, Patient_idText);
	
				pStatement.executeUpdate();
			    result="��ӳɹ�";

			}catch(Exception e2) {
				
			}
		}
		return result;
	}
}
