package com.assignment.onebotanka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        // Initializing and declaring

        // TextViews
        TextView recipientTxtView = (TextView) findViewById(R.id.recipientTxtView);
        TextView subjectTxtView = (TextView) findViewById(R.id.subjectTxtView);
        TextView messageTxtView = (TextView) findViewById(R.id.messageTxtView);

        // EditTexts
        EditText recipient = (EditText) findViewById(R.id.recipient);
        EditText subject = (EditText) findViewById(R.id.subject);
        EditText message = (EditText) findViewById(R.id.message);

        // Buttons
        Button sendBtn = (Button) findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String receiver = recipient.getText().toString().trim();
                String sub = subject.getText().toString().trim();
                String msg = message.getText().toString().trim();


                // Validating if it is empty or not
                if(receiver.isEmpty() || sub.isEmpty() || msg.isEmpty()){
                    Toast.makeText(Email.this, "Please check if everything is filled out", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{ receiver});
                    email.putExtra(Intent.EXTRA_SUBJECT, sub);
                    email.putExtra(Intent.EXTRA_TEXT, msg);

                    //need this to prompts email client only
                    email.setType("message/rfc822");

                    startActivity(Intent.createChooser(email, "Choose an Email client :"));


                }
            }
        });
    }

    public void sendEmail(){

    }
}