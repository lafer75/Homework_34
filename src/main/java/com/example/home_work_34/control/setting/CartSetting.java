package com.example.home_work_34.control.setting;

import com.example.home_work_34.variables.entity.Product;
import com.example.home_work_34.variables.repository.CartDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartSetting {

    private final CartDao cartDao;

    public void addProductToCartById(Integer cart_id, Integer product_id) {
        this.cartDao.addProductToCartById(cart_id, product_id);
    }

    public void deleteById(Integer cart_id) {
        this.cartDao.deleteById(cart_id);
    }

    public Optional<List<Product>> findProductsById(Integer cart_id) {
        return this.cartDao.findProductsById(cart_id);
    }

}