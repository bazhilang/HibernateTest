package cn.itcast.bazhilang.k_query_hql;

import java.util.HashSet;
import java.util.Set;

public class Department {

	private Integer id;
	private String name;
	private Set<Emplyee> emplyee = new HashSet<Emplyee>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Emplyee> getEmplyee() {
		return emplyee;
	}
	public void setEmplyee(Set<Emplyee> emplyee) {
		this.emplyee = emplyee;
	}
	
	
}
