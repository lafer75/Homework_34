package com.example.home_work_34.mapper;

import com.example.home_work_34.variables.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Row implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("login"),
                (double) rs.getInt("cost")
        );
    }
}
