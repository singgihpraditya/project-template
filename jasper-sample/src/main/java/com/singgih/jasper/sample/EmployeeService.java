package com.singgih.jasper.sample;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

	public List<Address> getAddressList() {
		List<Address> dataBeanList = new ArrayList<Address>();
		for (int i = 0; i < 10; i++) {
			dataBeanList.add(new Address("foo", "bar"));
		}
		return dataBeanList;
	}

	public List<Employee> getEmployeeList() {
		List<Employee> dataBeanList = new ArrayList<Employee>();
		for (int i = 0; i < 1000; i++) {
			dataBeanList.add(produce("Albert Einstein", "Engineer", "Ulm", "Germany"));
		}
		return dataBeanList;
	}

	private Employee produce(String name, String occupation, String place, String country) {
		Employee dataBean = new Employee();

		dataBean.setName(name);
		dataBean.setOccupation(occupation);
		dataBean.setPlace(place);
		dataBean.setCountry(country);

		return dataBean;
	}

}
