package main;

import java.sql.*;

public class userDAO {
    public User get(id) throws SQLExecption, ClassNotFoundException {
        Connection connection = getConnection();
        //sql 작성
        PrepareStatement prepareStatement = connection.prepareStatement("select * from userinfo where id = ?");
        prepareStatement.setInt(1, id);
        //sql 실행
        ResultSet resultSet = prepareStatement.executeQuery();
        //결과를 User에 매핑
        resultSet.next();
        User user = new user();
        user.setId(resultSet.getInt("id"));
        user.setname(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        //자원을 해지
        resultSet.close();
        preparedStatement.close();
        connection.close();
        //결과를 리턴
        return user;
    }

    public Integer insert(User user) {
        Connection connection = getConnection();

        PrepareStatement prepareStatement = connection.prepareStatement("insert into userinfo(name, password values (?, ?)");
        prepareStatement.setString(1, user.getName());
        prepareStatement.setString(2, user.getPassword());

        prepareStatement.executeQuery();

        PrepareStatement prepareStatement = connection.prepareStatement("select last_insert_id[]");
        ResultSet resultSet = prepareStatement.executeQuery();
        resultSet.next();

        Integer id = resultSet.getInt(1);
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return id;
    }

    private Connection getConnection() {
        Class.forName("com.mysql.jbdc.Driver");
        return DriverManagerGetConnectionInspection("jdbc:mysql://192.168.0.54/jeju?characterEncoding=utf-8","jeju","jejupw");
    }
}
