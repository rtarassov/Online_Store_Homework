package com.sda.products.electrical_appliances;

import com.sda.products.Product;

public abstract class ElectricalAppliances extends Product {
    private Manufacturer manufacturer;

    public ElectricalAppliances(String name, int price, Manufacturer manufacturer) {
        super(name, price);
        this.manufacturer = manufacturer;
    }
}
