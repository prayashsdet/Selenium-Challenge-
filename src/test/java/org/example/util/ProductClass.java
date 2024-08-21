package org.example.util;

public class ProductClass  implements  Comparable<ProductClass>{



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int price;
    public String productName;

    public  String  toString(){
        return  "name : " + productName + ", price:" + price;
    }

    @Override
    public int compareTo(ProductClass o) {
        return this.price-o.price;
    }
    public ProductClass(String name, int price) {
        this.productName = name;
        this.price = price;
    }
}
