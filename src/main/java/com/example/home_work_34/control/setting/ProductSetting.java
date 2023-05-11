package com.example.home_work_34.control.setting;

import com.example.home_work_34.variables.entity.Product;
import com.example.home_work_34.variables.repository.ProductDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductSetting {

    private final ProductDao productDao;
    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }
    public Optional<Product> findById(Integer id) {
        return this.productDao.findById(id);
    }

    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }

    public void deleteProductById(Integer id) {
        this.productDao.deleteProductById(id);
    }
}