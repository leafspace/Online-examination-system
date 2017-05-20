package cn.cslg.Online_examination_system.DatabaseFactory;

import cn.cslg.Online_examination_system.DatabaseInterface.InterfaceDatabaseProxy;
import cn.cslg.Online_examination_system.DatabaseProxy.MySqlDatabaseProxy;

/**
 * Created by Administrator on 2017/4/18.
 */
public class DatabaseProxyFactory {
    private InterfaceDatabaseProxy databaseProxy;

    public DatabaseProxyFactory() {
        this.databaseProxy = null;
    }

    public InterfaceDatabaseProxy getDatabaseProxy(String flag) {
        if(flag.equals("MySQL")) {
            this.databaseProxy = new MySqlDatabaseProxy();
        } else if(flag.equals("SQL Server")){
            this.databaseProxy = new MySqlDatabaseProxy();                     //在此处暂时放置出品MYSQL Proxy
        } else {
            this.databaseProxy = new MySqlDatabaseProxy();                     //在此处暂时放置出品MYSQL Proxy
        }
        return this.databaseProxy;
    }
}
