/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 84904
 */
public class Cart {
    private Map<String, Product> cart;

    public Cart() {
    }

    public Cart(Map<String, Product> cart) {
        this.cart = cart;
    }

    public Map<String, Product> getCart() {
        return cart;
    }

    public void setCart(Map<String, Product> cart) {
        this.cart = cart;
    }
    public boolean add(Product product) {
        boolean check = false;
        try {
            if(this.cart==null){
                this.cart = new HashMap<>();
            }
            if(this.cart.containsKey(product.getId())){
                int currentQuantity = this.cart.get(product.getId()).getQuantity();
                product.setQuantity(currentQuantity + product.getQuantity());
            }
            this.cart.put(product.getId(), product);
            check=true;
        } catch (Exception e) {
        }
        return check;
    }

    public boolean edit(String id, int quantity) {
        boolean check= false;
        try {
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    Product product = this.getCart().get(id);
                    product.setQuantity(quantity);
                    this.cart.replace(id, product);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
    public boolean remove(String id) {
        boolean check= false;
        try {
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    this.cart.remove(id);
                    check = true;
                }
            }
        } catch (Exception e) {
        }
        return check;
    }
}
