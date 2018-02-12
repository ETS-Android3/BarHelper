package simonhaefeli.barhelper;

/**
 * Created by simon on 10.07.17.
 */

public class Product {
    private String name;
    private int price;
    private String pathToImage;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }
    public Product(String name, int price, String path){
        this.name = name;
        this.price= price;
        this.pathToImage= path;

    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String s = name+" , "+(int)price+"CHF";
        return s;
    }
}
