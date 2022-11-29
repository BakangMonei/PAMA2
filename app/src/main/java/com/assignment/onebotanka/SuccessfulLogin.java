package com.assignment.onebotanka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.assignment.onebotanka.Database.DAO;

import org.w3c.dom.Text;

public class SuccessfulLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_login);
        //declaring and initializing
        // ImageView
        ImageView phoneCallImageView= (ImageView) findViewById(R.id.phoneCallImageView);
        ImageView emailImageView= (ImageView) findViewById(R.id.emailImageView);
        ImageView webBrowserImageView = (ImageView) findViewById(R.id.webBrowserImageView);
        ImageView smsImageView = (ImageView) findViewById(R.id.smsImageView);
        ImageView settingsImageView = (ImageView) findViewById(R.id.settingsImageView);
        ImageView profileTextView = (ImageView) findViewById(R.id.profileTextView);
        ImageView helpImageView = (ImageView) findViewById(R.id.helpImageView);


        // TextViews
        TextView mainMenuTextView = (TextView) findViewById(R.id.mainMenuTextView);
        TextView CallTextView = (TextView) findViewById(R.id.CallTextView);
        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);
        TextView smsTextView = (TextView) findViewById(R.id.smsTextView);
        TextView webBrowserTextView = (TextView) findViewById(R.id.settingsTextView);
        TextView settingsTextView = (TextView) findViewById(R.id.mainMenuTextView);
        TextView helpTextView = (TextView) findViewById(R.id.helpTextView);

        /********************************/
        // Database
        DAO DatabaseConnection = new DAO(this);
        /********************************/

        // Making phoneCall
        phoneCallImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast
                Toast.makeText(SuccessfulLogin.this, "Make a phone call", Toast.LENGTH_SHORT).show();
                //intent
                Intent call= new Intent(SuccessfulLogin.this,PhoneCall.class);
                startActivity(call);
            }
        });

        // Accessing the internet browser
        webBrowserImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast
                Toast.makeText(SuccessfulLogin.this, "Search on the web", Toast.LENGTH_SHORT).show();
                //intent
                Intent web = new Intent(SuccessfulLogin.this,webSearch.class);
                startActivity(web);
            }
        });

        // Sending an email
        emailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toast
                Toast.makeText(SuccessfulLogin.this, "Send an email", Toast.LENGTH_SHORT).show();
                //intent
                Intent sendEmail = new Intent(SuccessfulLogin.this,Email.class);
                startActivity(sendEmail);
            }
        });

        // Sending SMS
        smsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent
                Intent sms = new Intent(SuccessfulLogin.this, sendSMS.class);
                startActivity(sms);

                Toast.makeText(SuccessfulLogin.this, "Sending sms", Toast.LENGTH_SHORT).show();
            }
        });

        // Settings
        settingsImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent
                Intent settings = new Intent(SuccessfulLogin.this, SettingsActivity.class);
                startActivity(settings);
                Toast.makeText(SuccessfulLogin.this, "Settings", Toast.LENGTH_SHORT).show();
            }
        });

        // Help Section
        helpImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent help = new Intent(SuccessfulLogin.this, helpActivity.class);
                startActivity(help);
                Toast.makeText(SuccessfulLogin.this, "Help Part", Toast.LENGTH_SHORT).show();
            }
        });

        // userProfile
        profileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userPro = new Intent(SuccessfulLogin.this, userProfile.class);
                startActivity(userPro);
                Toast.makeText(SuccessfulLogin.this, "User Profile", Toast.LENGTH_SHORT).show();

                DatabaseConnection.readUser();
            }
        });
    }
}