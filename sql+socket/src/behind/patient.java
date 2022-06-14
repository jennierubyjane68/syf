package behind;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
 
 
public class patient{
	private int Patient_id;
	private String Patient_name;
	private String If_operat;
	
	public patient(){}
	
	public patient(int Patient_id,String Patient_name,String If_operat){
		super();
		this.Patient_id=Patient_id;
		this.Patient_name=Patient_name;
		this.If_operat=If_operat;
		}

	public String getPatient_name() {
		return Patient_name;
	}
	
	public int getPatient_id() {
		return Patient_id;
	}
	
	public String getIf_operat() {
		return If_operat;
	}
	
	
	public void setPatient_name(String Patient_name) {
		this.Patient_name=Patient_name;
	}
	
	public void setPatient_id(int Patient_id) {
		this.Patient_id=Patient_id;
	}
	
	public void setIf_operat(String If_operat) {
		this.If_operat=If_operat;
	}
	
	
	
	public String toString() {
		return 
			     "患者年龄"+getPatient_id()+','
			     +"患者姓名"+getPatient_name()+','
		      +"是否正在手术"+getIf_operat();
	}
		

 
}
 
 