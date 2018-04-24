package org.mum.wap.dao;
import org.mum.wap.model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    public static User getUser(int pId) {

        Helper.makeJDBCConnection();
        ResultSet rs=Helper.getDataFromDB("SELECT * from user WHERE id = "+pId);

        return toUser(rs);
    }

    public static User getUser(String pUserName,String pPassword) {

        Helper.makeJDBCConnection();
        ResultSet rs=Helper.getDataFromDB("SELECT * from user WHERE username = lower('"+pUserName.toLowerCase()+"') AND password= '"+pPassword+"'");

        return toUser(rs);
    }

   static User toUser(ResultSet rs){

       User user =null;
        try {

            while (rs.next()) {
                String name = rs.getString("name");
                String username = rs.getString("username");
                int id = rs.getInt("ID");
                String password = rs.getString("password");
                String imgUrl = rs.getString("img");

                user= new User(id,  name,  username,  password,  imgUrl);
            }
            Helper.closeConnection();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return user;

    }
}
