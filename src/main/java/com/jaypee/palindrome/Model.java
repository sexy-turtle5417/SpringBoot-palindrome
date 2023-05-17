package com.jaypee.palindrome;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class Model {

    private final String URL = "jdbc:mysql://localhost/palindrome";
    private final String USR = "root";
    private final String PASS = "Xscvsdg5417!";

    Connection connection;
    Statement statement;
    PreparedStatement prepStatement;
    ResultSet resultSet;
    
    protected Model(){

        try{
            connection = DriverManager.getConnection(URL, USR, PASS);
        }
        catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void saveToDatabase(String string, boolean result){

        try{
            String SQL = "INSERT INTO submissions(user_input, is_palindrome) VALUES (?,?)";
            prepStatement = connection.prepareStatement(SQL);
            prepStatement.setString(1, string);
            prepStatement.setBoolean(2, result);

            prepStatement.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    
    }

   

}
