package com.kashu.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.kashu.entity.Customer;

public class CustomerMapper implements RowMapper<Customer>{

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getLong("ID"));
		customer.setName(rs.getString("NAME"));
		customer.setEmail(rs.getString("EMAIL"));
		customer.setCreated_date(rs.getDate("CREATED_DATE"));
		return customer;
	}

}
