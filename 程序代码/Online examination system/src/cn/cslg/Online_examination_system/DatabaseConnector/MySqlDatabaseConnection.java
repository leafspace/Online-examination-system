package cn.cslg.Online_examination_system.DatabaseConnector;

import java.sql.*;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseConnection;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public class MySqlDatabaseConnection implements InterfaceDatabaseConnection {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String userPassword = "123456";
	private static String dbName = "online_examination_system";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public MySqlDatabaseConnection() {
		this.getConnection();
	}

	public Connection getConnection() {
		try {
			String url = "jdbc:mysql://192.168.198.129:3306/" + dbName + "?useUnicode=true&characterEncoding=utf8&user=" + userName + "&password=" + userPassword;
			Class.forName(driverName);                                                             //加载数据库驱动程序类
			this.connection = DriverManager.getConnection(url);                                    //获取数据库链接
			return this.connection;
		} catch (ClassNotFoundException e) {
			System.out.println("Error (MySqlDatabaseConnection) : No Mysql driver !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(String sql) {
		try {
			preparedStatement = this.connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet query(String sql){
		try {
			preparedStatement = this.connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void allClose(){
		try{
			if(this.preparedStatement != null){
				preparedStatement.close();
			}
			if(this.connection != null){
				connection.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
}
