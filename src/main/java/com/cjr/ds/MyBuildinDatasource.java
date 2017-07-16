package com.cjr.ds;

import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 * Created by Kong on 2017/7/14.
 */
public class MyBuildinDatasource implements BuildinDatasource {

    //  数据源名称
    private String name;
    //  数据源
    private DataSource datasource;

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBuildinDatasource.class);
    /**
     * 返回数据源名称
     * @return
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * 返回数据源的一个链接
     * @return
     */
    @Override
    public Connection getConnection() {
        try {
            return datasource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("数据源获取失败{}", e);
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataSource getDatasource() {
        return datasource;
    }

    public void setDatasource(DataSource datasource) {
        this.datasource = datasource;
    }
}
