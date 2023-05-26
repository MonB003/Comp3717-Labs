package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import android.graphics.Color;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    FragmentStateAdapter fragmentStateAdapter;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewPager2);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        // Create usage objects for each page
        Usage usageOne = new Usage(databaseReference.push().getKey());
        usageOne.setCount(0);
        usageOne.setPage(1);
        Usage usageTwo = new Usage(databaseReference.push().getKey());
        usageTwo.setCount(0);
        usageTwo.setPage(2);
        Usage usageThree = new Usage(databaseReference.push().getKey());
        usageThree.setCount(0);
        usageThree.setPage(3);


        // Creates and displays the appropriate fragment based on the position
        fragmentStateAdapter = new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {

                if (position == 0) {
                    return new FragmentOne();

                } else if (position == 1) {
                    return new FragmentTwo();

                } else {
                    return new FragmentThree();
                }
            }

            @Override
            public int getItemCount() {
                // There are 3 fragments
                return 3;
            }
        };

        viewPager2.setAdapter(fragmentStateAdapter);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if (position == 0) {
                    updateData(usageOne);

                } else if (position == 1) {
                    updateData(usageTwo);

                } else {
                    updateData(usageThree);
                }
            }
        });

    }


    // Uses the Random class to create a random colour
    public static int getRandomColour() {
        Random numGenerator = new Random();
        int[] rgbColours = new int[3];
        rgbColours[0] = numGenerator.nextInt(255);
        rgbColours[1] = numGenerator.nextInt(255);
        rgbColours[2] = numGenerator.nextInt(255);

        // Random colour for background
        return Color.rgb(rgbColours[0], rgbColours[1], rgbColours[2]);
    }


    public void updateData(Usage usage) {
        usage.setCount(usage.getCount() + 1);

        databaseReference.child("Usage").child(usage.getId()).setValue(usage);
    }
}