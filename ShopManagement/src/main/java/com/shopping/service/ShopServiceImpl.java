package com.shopping.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import com.shopping.model.Shop;

@Service
public class ShopServiceImpl implements ShopService {
        @Autowired
        private DataSource dataSource;
        private JdbcTemplate jdbcTemplate;
        private long generatedKey;
        private String rescuedstring;

        public void setDataSource(DataSource dataSource) {
                this.dataSource = dataSource;
                this.jdbcTemplate = new JdbcTemplate(dataSource);
        }
        
        public void addAShop(String name, String category, String address, String owner){
                
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("INSERT INTO shops(name,category,address,owner)VALUES(?,?,?,?)",name,category,address,owner );
                
        }
        
        public void deleteAShop(String name, Long id){
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update("DELETE FROM shops WHERE name='"+name+"' AND id="+id);
        }
        
        public List findShops(){
        	System.out.println("inside findShops ********");
            String sql = "SELECT * FROM shops order by id ";
            List shopList = new ArrayList();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.query(sql, new ResultSetExtractor() {
                    public List extractData(ResultSet rs) throws SQLException {
                    	System.out.println("before while ********");
                            while (rs.next()) {
                            	    Shop shop = new Shop();
                            	    
                            	    shop.setId(rs.getLong("id"));
                            	    shop.setName(rs.getString("name"));
                            	    shop.setCategory(rs.getString("category"));
                            	    shop.setAddress(rs.getString("address"));
                            	    shop.setOwner(rs.getString("Owner"));
                            	    

                                    shopList.add(shop);
                            }
                            return shopList;
                    }
            }
                            
            
    );
    System.out.println("shopList");
    return shopList;        
    }
/*
    public long getGeneratedKey(String name, String category, String address,String owner) {
            String sql ="INSERT INTO shops(name,category,address,owner)VALUES(?,?,?,?)";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            KeyHolder holder = new GeneratedKeyHolder();
 
            jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                    PreparedStatement statement = connection.prepareStatement(sql.toString(),
                                    Statement.RETURN_GENERATED_KEYS);
                    statement.setString(1, name);
                    statement.setString(2, category );
                    statement.setString(3, address);
                    statement.setString(4, owner);
                    return statement;
            }
            }, holder);
            generatedKey = holder.getKey().longValue();
            System.out.println("generated key is " + generatedKey);
            return generatedKey;
    }*/

}