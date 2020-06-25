package com.unisys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.unisys.model.Customer;

public class CustomerDao {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:h2:tcp://localhost/~/jspdemo";
		String user = "vinod";
		String password = "Welcome#123";
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection(url, user, password);
	}

	public List<Customer> getAllCustomers() {

		List<Customer> list = new ArrayList<>();

		try {

			try (Connection conn = getConnection();
					PreparedStatement stmt = conn.prepareStatement("select * from customers");
					ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					Customer c = new Customer();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setEmail(rs.getString("email"));
					c.setPhone(rs.getString("phone"));
					c.setCity(rs.getString("phone"));
					list.add(c);
				}

			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return list;
	}

	public void deleteCustomer(Integer id) {
		try {

			try (Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("delete from customers where id=?");) {
				stmt.setInt(1, id);
				stmt.execute();
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
