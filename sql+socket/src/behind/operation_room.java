package behind;


import java.io.Serializable;
import java.util.Date;

public class operation_room  {

	private   int Ope_room_id;
	private String If_operat;
	private  int MainDoctor_id;
	private  int Patient_id;
	
	public int getOpe_room_id() {
		return Ope_room_id;
	}
	
	public String getIf_operat() {
		return If_operat;
	}
	
	public int getPatient_id() {
		return Patient_id;
	}
	
	public int getMainDoctor_id() {
		return MainDoctor_id;
	}
	

	
	public void setOpe_room_id(int Ope_room_id) {
		this.Ope_room_id=Ope_room_id;
	}
	
	public void setIf_operat(String If_operat) {
		this.If_operat=If_operat;
	}
	
	public void setPatient_id(int Patient_id) {
		this.Patient_id=Patient_id;
	}
	
	public void setMainDoctor_id(int MainDoctor_id) {
		this.MainDoctor_id=MainDoctor_id;
	}
	
	
	
	public String toString() {
		return "手术室编号"+getOpe_room_id()+','
		      +"是否正在手术"+getIf_operat()+','
		      +"患者编号"+getPatient_id ()+','
		      +"主刀医生编号"+getMainDoctor_id();
	}
}
