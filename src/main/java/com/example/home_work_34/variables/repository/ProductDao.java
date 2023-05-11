package com.example.home_work_34.variables.repository;
import com.example.home_work_34.variables.entity.Product;
import com.example.home_work_34.mapper.Row;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;

    public Optional<Product> findById(Integer id) {
        try {
            return Optional.ofNullable(this.jdbcTemplate.queryForObject(
                    "SELECT * FROM \"Products\" WHERE \"id\" = ?", new Row(), id));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<Product> findAllProducts() {
        return this.jdbcTemplate.query(
                "SELECT * FROM public.\"Products\"",
                (rs, rowNum) -> new Product(
                        rs.getInt("id"),
                        rs.getString("login"),
                        (double) rs.getInt("cost"))
        );
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO public.\"Products\" (login, cost) VALUES (?, ?)";
        jdbcTemplate.update(sql, product.getLogin(), product.getCost());
    }

    public void deleteProductById(Integer id) {
        String sql = "DELETE FROM \"Products\" WHERE \"id\" = ?";
        Object[] args = new Object[]{id};
        this.jdbcTemplate.update(sql, args);
    }
}

