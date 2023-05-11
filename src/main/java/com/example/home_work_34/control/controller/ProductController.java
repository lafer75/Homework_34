package com.example.home_work_34.control.controller;

import com.example.home_work_34.variables.entity.Product;
import com.example.home_work_34.control.setting.ProductSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductSetting productSetting;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
        productSetting.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Integer id) {
        return productSetting.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Немає продукта за таким id:" + id));
    }

    @GetMapping("/get/all")
    public List<Product> findAllProducts() {
        return productSetting.findAllProducts();
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable("id") Integer id){
        productSetting.deleteProductById(id);
    }
}
