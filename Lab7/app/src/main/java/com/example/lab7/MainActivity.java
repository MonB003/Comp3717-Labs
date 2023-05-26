package com.example.lab7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FragmentItem fragmentItem;

    String[] names;
    String[] prices;

    int[] fruitImages = {R.drawable.apple, R.drawable.banana, R.drawable.grapes,
            R.drawable.kiwifruit, R.drawable.orange, R.drawable.pineapple, R.drawable.strawberry,
            R.drawable.watermelon};

    int[] veggiesImages = {R.drawable.cabbage, R.drawable.carrot, R.drawable.cauliflower,
            R.drawable.lettuce, R.drawable.mushroom, R.drawable.onion, R.drawable.spinach,
            R.drawable.tomatoes};

    int[] seafoodImages = {R.drawable.clam, R.drawable.crab, R.drawable.fillet,
            R.drawable.mussel, R.drawable.salmon, R.drawable.shrimp, R.drawable.squid};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create initial blank fragment
        fragmentItem = new FragmentItem();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragmentItem);
        fragmentTransaction.commit();


        // Setup navigation menu
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigationDrawerOpen, R.string.navigationDrawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        RecyclerViewProduct recyclerViewProduct;
        switch(item.getItemId())  {
            case R.id.navFruits:
                names = getResources().getStringArray(R.array.fruitNames);
                prices = getResources().getStringArray(R.array.fruitPrices);
                recyclerViewProduct = new RecyclerViewProduct(fruitImages, names, prices);
                fragmentItem.initializeAdapter(recyclerViewProduct);
                break;
            case R.id.navVeggies:
                names = getResources().getStringArray(R.array.veggieNames);
                prices = getResources().getStringArray(R.array.veggiePrices);
                recyclerViewProduct = new RecyclerViewProduct(veggiesImages, names, prices);
                fragmentItem.initializeAdapter(recyclerViewProduct);
                break;
            case R.id.navSeafood:
                names = getResources().getStringArray(R.array.seafoodNames);
                prices = getResources().getStringArray(R.array.seafoodPrices);
                recyclerViewProduct = new RecyclerViewProduct(seafoodImages, names, prices);
                fragmentItem.initializeAdapter(recyclerViewProduct);
                break;
            default:
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
