
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import db.DBUtil;
import entity.Product;

public class PagingDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	// dem so luong account trong db
	public int getTotalProduct() throws SQLException {
		try {
			conn = DBUtil.makeConnection();
			
			System.out.println("conn" + conn);
			
			String sql = "select count(*) as total_product from product;";
			ps = conn.prepareStatement(sql);
			
			System.out.println("ps" + ps);
			
			rs= ps.executeQuery(); 
			
			System.out.println("rs" + rs);
			
			System.out.println("rs next" + rs.next());
			
			if(rs.next()) {
				return rs.getInt("total_product"); // select count(*) chi co 1 ket qua
			}
			else {
				return 0;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return 0;
	}
	
	public List<Product> pagingProduct(int page) throws SQLException {
		List<Product> products = new ArrayList<>();
		Product product = null;
		
		
		try {
			conn = DBUtil.makeConnection();
			String sql = "select * from product order by id limit 4 offset ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (page-1)*4); // truyen (page-1)*4 vao offset ?
			
			System.out.println("ps" + ps);
			
			rs= ps.executeQuery(); 
			
			while(rs.next()) {
				product = new Product();
				product.setProductId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setDescription(rs.getString("description"));
				products.add(product);
			}
			return products;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
		return null;
	}

}
