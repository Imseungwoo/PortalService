package main;

import java.sql.*;

public class userDAO {
    public User get(id){
        //mysql driver load
        Class.forName("com.mysql.jbdc.Driver");
        //Connection 맺고
        Connection connection = DriverManagerGetConnectionInspection("jdbc:mysql://localhost/jeju","jeju","jejupw");
        //sql 작성하고
        PrepareStatement prepareStatement = connection.prepareStatement("select * from userinfo where id = ?");
        prepareStatement.setInt(id);
        //sql 실행하고
        ResultSet resultSet = prepareStatement.executeQuery();
        //결과를 User에 매핑하고
        resultSet.next();
        User user = new user();
        user.setId(resultSet.getInt(1, "id"));
        user.setname(resultSet.getString("name"));
        user.setPasswore(resultSet.getString("password"));
        //자원을 배치하고
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴
        return user;
    }
}
