package simonhaefeli.barhelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by simon on 10.07.17.
 */

public class createList_activity extends Activity{
    Liste listeProducts = new Liste();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createlist);



        //AJOUTER UN PRODUIT
        Button ajouterProduit = (Button) findViewById(R.id.ajout);

        final EditText editName = (EditText)findViewById(R.id.prodname);
        final EditText editPrice = (EditText) findViewById(R.id.prodprice);

        ajouterProduit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String priceProductStr = editPrice.getText().toString();
                final int priceProduct = Integer.parseInt(priceProductStr);
                final String nameProduct = editName.getText().toString();

                Product prod = new Product(nameProduct, priceProduct);
                listeProducts.addProduct(prod);

            }
        });


        //VALIDER LISTE
        Button validerList = (Button)findViewById(R.id.valider);
        final EditText editListName = (EditText)findViewById(R.id.listname);

        validerList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String nameListe = editListName.getText().toString();
                listeProducts.setName(nameListe);
                MainActivity.createdListsNames.add(listeProducts.getName());
                MainActivity.createdLists.add(listeProducts);
                Intent i=new Intent(createList_activity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

}
