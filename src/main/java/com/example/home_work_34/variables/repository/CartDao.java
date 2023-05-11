package com.example.home_work_34.variables.repository;
import com.example.home_work_34.variables.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartDao {

    private final JdbcTemplate jdbcTemplate;

    public void addProductToCartById(Integer cartId, Integer productId) {
        String productNameSql = "SELECT \"login\" FROM \"Products\" WHERE \"id\" = " + productId;
        String productName = jdbcTemplate.queryForObject(productNameSql, String.class);

        String productPriceSql = "SELECT \"cost\" FROM \"Products\" WHERE \"id\" = " + productId;
        Integer productPrice = jdbcTemplate.queryForObject(productPriceSql, Integer.class);

        String insertSql = "INSERT INTO public.\"Carts\" (cart_id, product_id, product_login, product_cost) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertSql, cartId, productId, productName, productPrice);
    }

    public void deleteById(Integer cartId) {
        String deleteSql = "DELETE FROM \"Carts\" WHERE \"cart_id\" = ?";
        Object[] args = new Object[]{cartId};
        jdbcTemplate.update(deleteSql, args);
    }

    public Optional<List<Product>> findProductsById(Integer cartId) {
        try {
            String selectSql = "SELECT product_id, product_login, product_cost FROM public.\"Carts\" WHERE cart_id = " + cartId;
            List<Product> products = jdbcTemplate.query(selectSql, (rs, rowNum) -> new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_login"),
                    (double) rs.getInt("product_cost")
            ));
            return Optional.of(products);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}

