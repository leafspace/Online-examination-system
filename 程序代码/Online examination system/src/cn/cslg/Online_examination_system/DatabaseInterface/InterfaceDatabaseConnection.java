package cn.cslg.Online_examination_system.DatabaseInterface;

import java.sql.ResultSet;

/**
 * Created by Administrator on 2017/5/20.
 * LastEdit: 2017-5-22
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 */
public interface InterfaceDatabaseConnection {
    void allClose();

    int update(String sql);
    ResultSet query(String sql);
}