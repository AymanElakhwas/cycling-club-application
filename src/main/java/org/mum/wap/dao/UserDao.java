package org.mum.wap.dao;
import org.mum.wap.model.User;

import javax.jws.soap.SOAPBinding;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {


    public static User getUser(int pId) {

        Helper.makeJDBCConnection();
        ResultSet rs=Helper.getDataFromDB("SELECT * from user WHERE id = "+pId);

        Helper.closeConnection();
        return toUser(rs).get(0);
    }

    public static User getUser(String pUserName,String pPassword) {

        Helper.makeJDBCConnection();
        ResultSet rs=Helper.getDataFromDB("SELECT * from user WHERE username = lower('"+pUserName.toLowerCase()+"') AND password= '"+pPassword+"'");


        User user= toUser(rs).get(0);
        Helper.closeConnection();
        return user;
    }

   static List<User> toUser(ResultSet rs){

       List<User> lstUser =new ArrayList<>();
        try {

            while (rs.next()) {
                String name = rs.getString("name");
                String username = rs.getString("username");
                int id = rs.getInt("ID");
                String password = rs.getString("password");
                String imgUrl = rs.getString("img");

                lstUser.add(new User(id,  name,  username,  password,  imgUrl));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return lstUser;

    }
}
