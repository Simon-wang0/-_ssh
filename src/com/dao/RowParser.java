package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowParser {
	Object parseRow(ResultSet rs) throws SQLException;
}
