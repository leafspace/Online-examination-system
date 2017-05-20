package cn.cslg.Online_examination_system.DatabaseFactory;

import cn.cslg.Online_examination_system.DatabaseConnector.MySqlDatabaseConnection;
import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseConnection;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-20
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */

public class DatabaseConnectionFactory {
	private InterfaceDatabaseConnection databaseConnection;

	/**
	 * @function 初始化属性
	 */
	public DatabaseConnectionFactory() {
		// TODO implement here
		this.databaseConnection = null;
	}

	/**
	 * @param flag 标明连接数据库接口类型
	 * @return databaseConnection 数据库连接类
	 * @function 获取数据连接
	 */
	public InterfaceDatabaseConnection getDatabaseConnection(String flag) {
		if(flag.equals("MySQL")) {
			this.databaseConnection = new MySqlDatabaseConnection();
		} else if(flag.equals("SQL Server")){
			this.databaseConnection = new MySqlDatabaseConnection();                               //在此处暂时放置出品MYSQL CONNECTION
		} else {
			this.databaseConnection = new MySqlDatabaseConnection();                               //在此处暂时放置出品MYSQL CONNECTION
		}
		return this.databaseConnection;
	}

}