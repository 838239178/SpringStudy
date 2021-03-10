package cn.demo.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyHandler extends BaseTypeHandler<Integer> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer integer, JdbcType jdbcType) throws SQLException {
        
    }

    @Override
    public Integer getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Integer getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Integer getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
