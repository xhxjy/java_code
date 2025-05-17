package test;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private int id;
    private double price;
    private String press;

    public Book() {
    }

    public Book(int id, double price, String press) {
        this.id = id;
        this.price = price;
        this.press = press;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return press
     */
    public String getPress() {
        return press;
    }

    /**
     * 设置
     * @param press
     */
    public void setPress(String press) {
        this.press = press;
    }

    public String toString() {
        return "Book{id = " + id + ", price = " + price + ", press = " + press + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Double.compare(price, book.price) == 0 && Objects.equals(press, book.press);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, press);
    }

    @Override
    public int compareTo(Book o) {
        return this.getId()-o.getId();
    }
}
