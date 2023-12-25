package com.example.test11.learn.design.template;

import cn.hutool.core.util.StrUtil;
import org.junit.Assert;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyJdbcTemplate {


    public <T> T query(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException{

        Assert.assertNotNull("SQL must not be null",sql);
        Assert.assertNotNull("ResultSetExtractor must not be null",rse);

        class QueryStatementCallback implements StatementCallback<T>, SqlProvider{

            @Override
            public String getSql() {
                return sql;
            }

            @Override
            public T doInStatement(Statement stmt) throws SQLException, DataAccessException {
                ResultSet rs =null;
                try {
                    rs = stmt.executeQuery(sql);
                    return rse.extractData(rs);
                } catch (DataAccessException e) {
                    throw new RuntimeException(e);
                } finally {
                    JdbcUtils.closeResultSet(rs);
                }
            }
        }
        return null;
    }
}
