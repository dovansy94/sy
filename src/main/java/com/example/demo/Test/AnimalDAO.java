package com.example.demo.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnimalDAO {
    private Connection conn = null;
        public AnimalDAO() {

            String hostName = "localhost";

            String dbName = "test";
            String userName = "root";
            String password = "1234";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
                conn = DriverManager.getConnection(connectionURL, userName,
                        password);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

            public ArrayList<Cat> getAll(){
                ArrayList<Cat> listAnimal = new ArrayList<Cat>();
                String sql = "Select * from animal";
                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        Cat a = new Cat();
                        a.setId(rs.getInt(1));
                        a.setTenLoai(rs.getString(2));
                        a.setMauSac(rs.getString(3));
                        listAnimal.add(a);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                return listAnimal;
            }

}

