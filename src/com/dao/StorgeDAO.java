package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.model.Storage;

public class StorgeDAO {
	private RowParser parser = new StorgeParser();

	private List<String> list = new ArrayList<String>() {
		{
			add("aaaaaaaa");
			add("bbbbbbbb");
		}
	};

	public void add(Storage s) {
		String sql = "insert into storages(proid,storageamount,storagedate) values(?,?,?)";
		int key = DBUtil.updateWithAutoGen(sql, s.getProductId(), s.getAmount(), s
				.getInDate());
		s.setId(key);
	}

	@SuppressWarnings("unchecked")
	public List<Storage> list() {
		String sql = "select storageid,proid,storageamount,storagedate from storages";
		return DBUtil.query(sql, parser);

	}

	public Storage get(int id) {
		String sql = "select storageid,proid,storageamount,storagedate from storages where storageid=?";
		return (Storage) DBUtil.unique(sql, parser, id);
	}

	public void update(Storage s) {
		String sql = "update storages set storageamount=? where storageid=?";
		DBUtil.update(sql, s.getAmount(), s.getId());

	}

	public void delete(int id) {
		String sql = "delete storages where storageid=?";
		DBUtil.update(sql, id);
	}

	public Storage findByProductId(int ProductId) {
		String sql = "select storageid,proid,storageamount,storagedate from storages where proid=?";
		return (Storage) DBUtil.unique(sql, parser, ProductId);
	}

	@SuppressWarnings("unchecked")
	
	
	public List<Storage> findProductInStore() {//查找书籍全部商品信息
		String sql = "select  p.proid as proid, proname,prokind,exhost,proprice,storageamount,storagedate,p.proid as sid"
				+ " from   products p ,storages s"
				+ " where p.proid=s.proid  and storageamount>0";
	 
		List<Storage> storageList = DBUtil.query(sql, new RowParser() {

			public Object parseRow(ResultSet rs) throws SQLException {
				Storage s = new Storage();
				Product b = new Product();
				s.setProduct(b);
				b.setId(rs.getInt("proid"));
				b.setName(rs.getString("proname"));
				b.setProkind(rs.getString("prokind"));
				b.setExhost(rs.getString("exhost"));
				b.setPrice(rs.getDouble("proprice"));

				s.setId(rs.getInt("sid"));
				s.setAmount(rs.getInt("storageamount"));
				s.setInDate(rs.getDate("storagedate"));
				return s;
			}
		});

		return storageList;
	}
}
