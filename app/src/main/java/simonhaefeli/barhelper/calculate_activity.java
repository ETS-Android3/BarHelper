package simonhaefeli.barhelper;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import static simonhaefeli.barhelper.MainActivity.createdLists;
import static simonhaefeli.barhelper.MainActivity.indexSelected;

/**
 * Created by simon on 11.07.17.
 */

public class calculate_activity extends Activity{
    int sommeTotale = 0;
    boolean positiveMode;
    List<Tuple<Product,Integer>> productToQuantity = initializeOrder(createdLists.get(indexSelected).getProducts());
    List<String> prodsToDisplay;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        positiveMode = true;

        TextView listName = (TextView) findViewById(R.id.listnameCalc);
        listName.setText(createdLists.get(indexSelected).getName());


        final ListView prods = (ListView) findViewById(R.id.products);
        int color = Color.argb(33,0, 255, 0);
        prods.setBackgroundColor( color );

        prodsToDisplay=displayProds();
        adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                prodsToDisplay
        );
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        prods.setAdapter(adapter);

        prods.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                updateTotal(position);
            }
        });

        Button reinit = (Button)findViewById(R.id.reinit);
        reinit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                updateTotalTo0();
            }
        });

        final Button remove = (Button)findViewById(R.id.remove);
        remove.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(positiveMode){
                    positiveMode = false;
                    int color = Color.argb(33,255,0,0);
                    prods.setBackgroundColor( color );
                }
                else{
                    positiveMode = true;
                    int color = Color.argb(33,0, 255, 0);
                    prods.setBackgroundColor( color );
                }

            }
        });

    }
    private void updateTotal(int index){
        TextView tot = (TextView) findViewById(R.id.total);
        Product prod = productToQuantity.get(index).getX();
        if(positiveMode){
            sommeTotale += prod.getPrice();
            productToQuantity.get(index).setY(productToQuantity.get(index).getY()+1);
        }
        else{
            sommeTotale -= prod.getPrice();
            productToQuantity.get(index).setY(productToQuantity.get(index).getY()-1);
        }

        String s = "Total : "+(sommeTotale);
        tot.setText(s);
        prodsToDisplay.clear();
        for(Tuple<Product, Integer> entry: productToQuantity){
            String a = entry.getX().getName()+" , "+(int)entry.getX().getPrice()+"CHF\t\t\t\t\t\t"+entry.getY();
            prodsToDisplay.add(a);
        }
        adapter.notifyDataSetChanged();

    }
    private void updateTotalTo0(){
        TextView tot = (TextView) findViewById(R.id.total);
        sommeTotale = 0;
        String s = "Total : "+(sommeTotale);
        tot.setText(s);
        for(Tuple<Product, Integer> entry: productToQuantity){
            entry.setY(0);
        }
        prodsToDisplay.clear();
        for(Tuple<Product, Integer> entry: productToQuantity){
            String a = entry.getX().toString()+"\t\t\t\t\t\t"+entry.getY();
            prodsToDisplay.add(a);
        }
        adapter.notifyDataSetChanged();

    }

    private List<Tuple<Product, Integer>> initializeOrder(List<Product> products){
        List<Tuple<Product, Integer>> mapping = new ArrayList<>();
        for(Product p: products){
            mapping.add(new Tuple(p,0));
        }
        return mapping;
    }

    private List<String> displayProds(){
        List<String> toDisplay = new ArrayList<>();
        for(Tuple<Product,Integer> entry: productToQuantity){
            String s = entry.getX().toString()+"\t\t\t\t\t\t"+entry.getY();
            toDisplay.add(s);
        }
        return toDisplay;
    }

}
