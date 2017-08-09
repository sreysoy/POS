package com.pos.acer.pointofsale;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText userName, passWord;
    private DatabaseManager databaseManager;
    private Button btnLogIn;
    private User users;
    private IntentObject object;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        databaseManager = new DatabaseManager(this);
        userName = (EditText) findViewById(R.id.txtUsername);
        passWord = (EditText) findViewById(R.id.txtPassword);
        userName.setText("sreysol");
        passWord.setText("12345");
        btnLogIn = (Button) findViewById(R.id.btnLogin);
        btnLogIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnLogin){
            users = databaseManager.userLogin(userName.getText().toString(),passWord.getText().toString());
            if (users == null){
                Toast.makeText(this,"Login no field!!!!",Toast.LENGTH_LONG).show();
            }
            else {
                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                object = new IntentObject(intent);
                object.putUserIntent(users);
                startActivity(intent);
                finish();
            }

        }

    }
}
