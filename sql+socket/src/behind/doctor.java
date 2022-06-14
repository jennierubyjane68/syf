package behind;


import java.io.Serializable;
import java.util.Date;

public class doctor  {

	private int Doctor_id;
	private String Doctor_name;
	private String If_operat;
	private int Ope_room_id;
	
	public int getDoctor_id() {
		return Doctor_id;
	}
	
	public String getDoctor_name() {
		return Doctor_name;
	}
	
	public String getIf_operat() {
		return If_operat;
	}
	
	public int getOpe_room_id() {
		return Ope_room_id;
	}
	
	public void setDoctor_id(int Doctor_id) {
		this.Doctor_id=Doctor_id;
	}
	
	public void setDoctor_name(String Doctor_name) {
		this.Doctor_name=Doctor_name;
	}
	
	public void setIf_operat(String If_operat) {
		this.If_operat=If_operat;
	}
	
	public void setOpe_room_id(int Ope_room_id) {
		this.Ope_room_id=Ope_room_id;
	}
	
	public String toString() {
		return "医生编号"+getDoctor_id()+','
		      +"医生姓名"+getDoctor_name()+','
		      +"是否正在手术"+getIf_operat()+','
		      +"手术室编号"+getOpe_room_id();
	}
}
