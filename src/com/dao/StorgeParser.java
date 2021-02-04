package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Storage;

public class StorgeParser implements RowParser {

	public Object parseRow(ResultSet rs) throws SQLException {
		Storage s = new Storage();
		s.setId(rs.getInt("storageid"));
		s.setProductId(rs.getInt("proid"));
		s.setAmount(rs.getInt("storageamount"));
		s.setInDate(rs.getDate("storagedate"));
		return s;
	}

}
