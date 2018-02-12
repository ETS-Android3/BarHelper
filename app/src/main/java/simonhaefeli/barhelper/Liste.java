package simonhaefeli.barhelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by simon on 10.07.17.
 */

public class Liste {
    private List<Product> products;
    private String name;
    public Liste(String name){
        this.name=name;
        products=new ArrayList<>();
    }
    public Liste(){
        products = new ArrayList<>();
    }
    public void setName(String name){
        this.name=name;
    }
    public void addProduct(Product p){
        products.add(p);
    }
    public String getName(){
        return name;
    }
    public List<Product> getProducts(){
        return new ArrayList<>(products);
    }

}
