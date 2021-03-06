package ru.geekbrains.ee;

public class Product {

    private final int id;
    private final String title;
    private final int cost;

    public Product(int id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("id - %d | title - %s | cost - %d у.е", id, title, cost);
    }
}
