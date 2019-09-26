package com.joka.batisdemo.ibatis.dao;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * Created on 2019/9/26 14:46.
 *
 * @author zhaozengjie
 * Description :
 */
public class BaseDao<T> {

    private static Logger logger = LoggerFactory.getLogger(BaseDao.class);

    private SqlMapClient sqlMapClient;

    private SqlMapExecutor executor;

    public BaseDao(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
        SqlMapSession session = this.sqlMapClient.openSession();
        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Opened SqlMapSession [" + session + "] for iBATIS operation");
        }

        this.executor = session;
    }

    protected List<T> executeQueryForList(final String statementName, final Object parameterObject) {

        try {
            long startTime = System.currentTimeMillis();
            Object returnObject = executor.queryForList(statementName, parameterObject);
            long endTime = System.currentTimeMillis();

            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Sql " + statementName + " executed on databases. Run time estimated: " + (endTime - startTime) + "ms");
            }

            if (returnObject != null) {
                if (returnObject instanceof List) {
                    return (List<T>) returnObject;
                } else {
                    throw new SQLException("Can't Case to List");
                }
            }
            throw new SQLException("No result");
        } catch (SQLException e) {
            logger.error("", e);
        }
        return null;
    }

    protected T executeQueryForObject(final String statementName, final Object parameterObject) {

        try {
            long startTime = System.currentTimeMillis();
            Object returnObject = executor.queryForObject(statementName, parameterObject);
            long endTime = System.currentTimeMillis();

            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Sql " + statementName + " executed on databases. Run time estimated: " + (endTime - startTime) + "ms");
            }

            if (returnObject != null) {
                return (T) returnObject;
            }
            throw new SQLException("No result");
        } catch (SQLException e) {
            logger.error("", e);
        }
        return null;
    }

    protected T insert(final String statementName, final Object parameterObject) {

        try {
            T insert = (T) this.executor.insert(statementName, parameterObject);
            return insert;
        } catch (SQLException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        }
    }

    protected int update(final String statementName, final Object parameterObject) {

        try {
            int insert = this.executor.update(statementName, parameterObject);
            return insert;
        } catch (SQLException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        }
    }

}
