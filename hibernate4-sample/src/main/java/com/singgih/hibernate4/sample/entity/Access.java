package com.singgih.hibernate4.sample.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.google.common.base.Objects;

@Entity
@Table(name = "app_access")
public class Access extends BaseEntity {
	@Column(name = "name", nullable = false)
	private String name;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "app_role_access", joinColumns = { @JoinColumn(name = "access_id") }, inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> grantedRoles;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getGrantedRoles() {
		return grantedRoles;
	}

	public void setGrantedRoles(List<Role> grantedRoles) {
		this.grantedRoles = grantedRoles;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(getClass())
				.add("id", id)
				.add("name", name)
				.toString();
	}
}
