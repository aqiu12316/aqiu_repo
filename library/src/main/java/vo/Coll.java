package vo;

import java.io.InputStream;

public class Coll {
	

	
	private String collId;
	private String collName;
	
	private String image;
	
  
	private String description;
	private String dynasty;
	private String address;
	private String inTime;
	private String status;
	//增加了一个属性 type 生成了get set方法
	 private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public  String getCollId() {
		return collId;
	}
	public void setCollId(String collId) {
		this.collId = collId;
	}
	public String getCollName() {
		return collName;
	}
	public void setCollName(String collName) {
		this.collName = collName;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDynasty() {
		return dynasty;
	}
	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIdrepair() {
		return idrepair;
	}
	public void setIdrepair(String idrepair) {
		this.idrepair = idrepair;
	}
	private String idrepair;
}
