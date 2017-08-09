package com.pos.acer.pointofsale;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtFullname;
    private EditText txtEmail;
    private EditText txtDateOfBirth;
    private Spinner spGender;
    private Spinner spAge;
    private EditText txtPhoneNumber;
    private EditText txtAddress;
    private ImageView UserImage;
    private DatabaseManager databaseManager;
    private User user;
    private ImageHelper imageHelper;
    private Button btnSave;
    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("User Registration");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseManager = new DatabaseManager(this);
        imageHelper = new ImageHelper(getApplicationContext(),RegisterActivity.this);
        user = new User();
        txtUsername    = (EditText)findViewById(R.id.txtAddUsername);
        txtPassword    = (EditText)findViewById(R.id.txtAddPassword);
        txtFullname    = (EditText)findViewById(R.id.txtAddFullname);
        txtEmail       = (EditText)findViewById(R.id.txtAddEmail);
        txtDateOfBirth = (EditText)findViewById(R.id.txtAddDateOfBirth);
        spGender       = (Spinner) findViewById(R.id.spGender);
        spAge          = (Spinner) findViewById(R.id.spAge);
        txtPhoneNumber = (EditText)findViewById(R.id.txtAddPhoneNumber);
        txtAddress     = (EditText)findViewById(R.id.txtAddAddress);
        UserImage  = (ImageView) findViewById(R.id.txtAddimage);
        btnSave        = (Button)findViewById(R.id.btnSave);

        UserImage.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST  ) {
            if (resultCode == RESULT_OK && data != null){
                try {
                    Uri selectedImage = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                    UserImage.setImageBitmap(bitmap);
                    String path = selectedImage.getPath();
                    String filename = path.substring(path.lastIndexOf("/") + 1);
                    imageHelper.upLoadPhoto(bitmap, filename, user.getUsername());
                    user.setImgProfile(user.getUsername() + filename);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnSave)
        {
            user.setUsername(txtUsername.getText().toString());
            user.setPassword(txtPassword.getText().toString());
            user.setFullname(txtFullname.getText().toString());
            user.setEmail(txtEmail.getText().toString());
            user.setDateOfBirth(txtDateOfBirth.getText().toString());
            user.setGender(spGender.getSelectedItem().toString());
            user.setPhoneNumber(txtPhoneNumber.getText().toString());
            user.setAddress(txtAddress.getText().toString());
//            user.setRole("admin");
            user.setRole("users");
            if(!spAge.getSelectedItem().toString().equals("Age")) user.setAge(Integer.parseInt(spAge.getSelectedItem().toString()));
            else user.setAge(0);
            if(     !user.getUsername().equals("")       && !user.getPassword().equals("")       &&
                    !user.getFullname().equals("")       && !user.getEmail().equals("")          &&
                    !user.getDateOfBirth().equals("")    && !user.getGender().equals("Gender")   &&
                    !user.getPhoneNumber().equals("")    && !user.getAddress().equals("")        &&
                    !user.getImgProfile().equals("")     &&  user.getAge() != 0) {
                if(databaseManager.verifyUser(user.getUsername()))
                {
                    if(databaseManager.AddUser(user)) finish();
                    else  Toast.makeText(RegisterActivity.this,"Adding User Failed",Toast.LENGTH_LONG).show();
                }
                else if(!databaseManager.verifyUser(user.getEmail()))
                {
                    Toast.makeText(RegisterActivity.this,"This email already been taken",Toast.LENGTH_LONG).show();
                }
            }
            else
            {
                Toast.makeText(this,"Please fill all information",Toast.LENGTH_LONG).show();
            }
        }
        else if (id == R.id.txtAddimage){
            imageHelper.optionPickUpImage(PICK_IMAGE_REQUEST);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
