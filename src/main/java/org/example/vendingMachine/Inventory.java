package org.example.vendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {

    private Map<Product, Integer> productInventoryMap;

    public Inventory() {
        productInventoryMap = new ConcurrentHashMap<>();
    }

    public void addAndUpdateProduct(Product product, Integer quantity) {
        productInventoryMap.put(product, quantity);
    }

    public void removeProduct(Product product) {
        productInventoryMap.remove(product);
    }

    public Integer getInventory(Product product) {
        return productInventoryMap.getOrDefault(product, 0);
    }

    public Boolean isAvailable(Product product) {
        return productInventoryMap.containsKey(product) && productInventoryMap.get(product) > 0;
    }
}
