package simonhaefeli.barhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    public static List<String> createdListsNames = new ArrayList<>();
    public static List<Liste> createdLists = new ArrayList<>();
    public static int indexSelected = 0;
    static{
        //PALEO 2017 initialisation
        initForPaleo2017();
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //LISTE DEROULANTE
        final ListView lists = (ListView) findViewById(R.id.listview);

        lists.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                indexSelected = getIndexOfList(lists.getItemAtPosition(position).toString());
                Intent intent = new Intent(MainActivity.this, calculate_activity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                createdListsNames
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lists.setAdapter(adapter);


        //CREER UNE NOUVELLE LISTE BOUTON
        Button buttonCreateNew =  (Button)findViewById(R.id.button);
        buttonCreateNew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, createList_activity.class);
                startActivity(i);
            }
        });
    }

    private int getIndexOfList(String name){
        for(int i=0; i<createdListsNames.size();i++){
            if(createdListsNames.get(i).equals(name)){
                return i;
            }
        }
        return -1;
    }

    private static void initForPaleo2017(){
        //Liste compressée
        createdListsNames.add("Paleo 2017");
        Liste paleo2017liste = new Liste();
        paleo2017liste.setName("Paleo 2017");
        paleo2017liste.addProduct(new Product("Retour Gobelet",-2));
        paleo2017liste.addProduct(new Product("Bière blonde",6));
        paleo2017liste.addProduct(new Product("Bière blanche",7));
        paleo2017liste.addProduct(new Product("Lime Cut",7));
        paleo2017liste.addProduct(new Product("Eve Litchi",7));
        paleo2017liste.addProduct(new Product("Bière Brunette",7));
        paleo2017liste.addProduct(new Product("Cardinal original draft",7));
        paleo2017liste.addProduct(new Product("Henniez PET 5dl",4));
        paleo2017liste.addProduct(new Product("PET 5dl sans alcool" ,4));
        paleo2017liste.addProduct(new Product("Henniez bleu gobelet",5));
        paleo2017liste.addProduct(new Product("Henniez Mango gobelet",5));
        paleo2017liste.addProduct(new Product("Jus de pomme gobelet",5));
        paleo2017liste.addProduct(new Product("Feldschlösschen sans alcool",5));
        paleo2017liste.addProduct(new Product("Porte gobelet individuel",2));
        paleo2017liste.addProduct(new Product("Porte gobelets 6 places",4));
        createdLists.add(paleo2017liste);

    }

}
