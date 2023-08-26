package poly.estore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "roles")
public class Role{
	@Id
	private String id;
	private String name;
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;
	public Role() {
		super();
	}
	public Role(String id, String name, List<Authority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.authorities = authorities;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	
	
}