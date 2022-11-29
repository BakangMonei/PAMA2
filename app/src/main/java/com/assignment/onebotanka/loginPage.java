package com.assignment.onebotanka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.assignment.onebotanka.Database.DAO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity {

    /*************************************/
    // Firebase
    private FirebaseAuth mAuth;
    /*************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        /*************************************/
        // Firebase
        mAuth =FirebaseAuth.getInstance();
        /*************************************/
        Button signBtn = (Button) findViewById(R.id.signBtn);
        Button logInBtn = (Button) findViewById(R.id.logInBtn);
        TextView LoggingInTextView = (TextView) findViewById(R.id.LoggingInTextView);

        EditText logInEditText = (EditText) findViewById(R.id.logInEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);


        // Login Button
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = logInEditText.getText().toString().trim();
                String txtPassword = passwordEditText.getText().toString();

                if(TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(loginPage.this,"Empty Credentials",Toast.LENGTH_SHORT).show();
                }
                else{
                    loginUser(txtEmail,txtPassword);
                }
            }
        });
        // SignUp Button
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(loginPage.this, signUp.class);
                startActivity(signUpIntent);
                Toast.makeText(loginPage.this, "SignUp", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loginUser(String username, String password){
        mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){

                    Toast.makeText(loginPage.this,"Login Success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(loginPage.this, SuccessfulLogin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(loginPage.this,e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}