public class Address {

	private String postcod;
	private String phone;
	private String daddress;
	
	public Address() {
		
	}

	public Address(String postcod, String phone, String daddress) {
//		super();
		this.postcod = postcod;
		this.phone = phone;
		this.daddress = daddress;
	}

	public String getPostcod() {
		return postcod;
	}

	public void setPostcod(String postcod) {
		this.postcod = postcod;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return daddress;
	}

	public void setAddress(String daddress) {
		this.daddress = daddress;
	}
	
	
}
