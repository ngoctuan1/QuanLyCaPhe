/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.sql.*;

/**
 *
 * @author tt
 */
public class MySQLConnect {
    String host = "";
    String userName = "";
    String password = ""; 
    String Database = "";
    
    Connection connect = null;
    Statement statement = null;
    ResultSet result = null;

    public MySQLConnect(String host, String userName, String password, String Database)
    {
        this.host = host;
        this.userName = userName;
        this.password = password;
        this.Database = Database;
    }
    
    protected void driverTest() throws Exception
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(java.lang.ClassNotFoundException e)
        {
            throw new Exception("MySQL JDBC Driver not found ...");
        }
    }
    
    protected Connection getConnect() throws Exception
    {
        if(this.connect == null)
        {
            // Kiểm tra Driver
            driverTest();
            
            // Tạo URL kết nối đến Database Server
            String url = "jdbc:mysql://" + this.host + ":3306/" + this.Database + "?useUnicode=true&characterEncoding=UTF-8";
            
            try
            {
                // Tạo Connection thông qua URL
                this.connect = DriverManager.getConnection(url, this.userName, this.password);
            }
            // Nếu ko thành công ném lỗi ra ngoài
            catch(java.sql.SQLException e)
            {
                throw new Exception("Khong the ket noi den Database Server:" + url + e.getMessage());
            }
        }
        
        return this.connect;
    }
    
    protected Statement getStatement() throws Exception
    {
        if(this.statement == null? true: this.statement.isClosed())
        {
            // Khởi tạo 1 statement mới
            this.statement = this.getConnect().createStatement();
        }
        return this.statement;
    }
    
    public ResultSet executeQuery(String query) throws Exception
    {
        try
        {
            this.result = getStatement().executeQuery(query);
        }
        catch(Exception e)
        {
            throw new Exception("Error: " + e.getMessage());
        }
        return this.result;
    }
    
    public int executeUpdate(String query) throws Exception
    {
        int res = Integer.MIN_VALUE;
        try
        {
            res = getStatement().executeUpdate(query);
        }
        catch(Exception e)
        {
            throw new Exception("Error: " + e.getMessage());
        }
        finally
        {
            // Đóng kết nối
            this.Close();
        }
        return res;
    }
    
    public void Close() throws SQLException
    {
        // Nếu result chưa đóng. Đóng result 
        if(this.result != null && !this.result.isClosed())
        {
            this.result.close();
            this.result = null;
        }
        
        // Nếu statement chưa đóng. Đóng statement 
        if(this.statement != null && !this.statement.isClosed())
        {
            this.statement.close();
            this.statement = null;
        }
        
        // Nếu connection chưa đóng. Đóng connection
        if(this.connect != null && !this.connect.isClosed())
        {
            this.connect.close();
            this.connect = null;
        }
    }
}
