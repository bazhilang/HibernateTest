import java.sql.Blob;
import java.util.Date;

//学生类
public class Students {

	private int sid; // 学号
	private String sname; // 姓名
	private String gender;// 性别
	private Date birthday;// 出生日期
	private Address address;// 地址
	private Blob spicture;

	public Students() {

	}

	public Students(int sid, String sname, String gender, Date birthday) {
		// super();
		this.sid = sid;
		this.sname = sname;
		this.gender = gender;
		this.birthday = birthday;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Blob getSpicture() {
		return spicture;
	}

	public void setSpicture(Blob spicture) {
		this.spicture = spicture;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
