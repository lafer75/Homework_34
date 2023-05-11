package com.example.home_work_34.control.controller;
import com.example.home_work_34.variables.entity.Product;
import com.example.home_work_34.control.setting.CartSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartSetting cartSetting;

    @PostMapping("/add/product/{cart_id}/{product_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductById(
            @PathVariable("cart_id") Integer cart_id,
            @PathVariable("product_id") Integer product_id){
        cartSetting.addProductToCartById(cart_id,product_id);
    }

    @GetMapping("/delete/product/{cart_id}")
    public void deleteProductById(@PathVariable("cart_id") Integer cart_id){
        cartSetting.deleteById(cart_id);
    }

    @GetMapping("/{cart_id}")
    public List<Product> findProductsById(@PathVariable("cart_id") Integer cart_id){
        return cartSetting.findProductsById(cart_id)
                .orElseThrow(() -> new IllegalArgumentException("Немаэ продукта у кошику за таким id:" + cart_id));
    }
}
