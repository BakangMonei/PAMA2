package com.assignment.onebotanka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.assignment.onebotanka.Database.DAO;

public class userProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Declaring & Initializing
        // TextViews
        TextView setFirstNameTextView = (TextView) findViewById(R.id.setFirstNameTextView);
        TextView setLastNameTextView = (TextView) findViewById(R.id.setLastNameTextView);
        TextView setGenderTextView = (TextView) findViewById(R.id.setGenderTextView);
        TextView setEmailTextView = (TextView) findViewById(R.id.setEmailTextView);
        TextView setAddressTextView = (TextView) findViewById(R.id.setAddressTextView);

        // Database constructor
        DAO DatabaseConnection = new DAO(this);


    }
}