package esoft.order.model;

import esoft.abs.model.Product;
import esoft.abs.model.Item;

public class SimpleProduct implements Product {
    private int id;
    private double cost;
    private Item item;
    private int quantityOnHand;
    private int idStock;

    public SimpleProduct(int id, double cost, Item item, int quantityOnHand, int idStock) {
        this.id = id;
        this.cost = cost;
        this.item = item;
        this.quantityOnHand = quantityOnHand;
        this.idStock = idStock;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public Item getItem() {
        return item;
    }

    @Override
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    @Override
    public int getIdStock() {
        return idStock;
    }
}
