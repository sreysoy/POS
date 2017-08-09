package com.pos.acer.pointofsale;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Daly on 7/20/2017.
 */

public class IntentObject {
    private Intent intent;

    /////////////////for user///////////////////////
    private String userId       = "0";
    private String age          = "1";
    private String username     = "2";
    private String fullname     = "3";
    private String email        = "4";
    private String phoneNumber  = "5";
    private String gender       = "6";
    private String dateOfBirth  = "7";
    private String address      = "8";
    private String password     = "9";
    private String imgProfile   = "10";
    private String role         = "11";
    public IntentObject(Intent intent)
    {
        this.intent = intent;
    }
    public IntentObject(){}
    public void putUserIntent(User user)
    {
        intent.putExtra(userId,user.getUserId());
        intent.putExtra(fullname,user.getFullname());
        intent.putExtra(age,user.getAge());
        intent.putExtra(gender,user.getGender());

        intent.putExtra(email,user.getEmail());
        intent.putExtra(phoneNumber,user.getPhoneNumber());
        intent.putExtra(address,user.getAddress());
        intent.putExtra(imgProfile,user.getImgProfile());
        intent.putExtra(dateOfBirth,user.getDateOfBirth());

        intent.putExtra(username,user.getUsername());
        intent.putExtra(password,user.getPassword());
        intent.putExtra(role,user.getRole());
    }
    public User getUserFromIntent(Bundle bundle)
    {
        User user = new User();
        if(bundle !=null)
        {
            user.setUserId(bundle.getInt(userId));
            user.setFullname(bundle.getString(fullname));
            user.setGender(bundle.getString(gender));
            user.setAge(bundle.getInt(age));

            user.setDateOfBirth(bundle.getString(dateOfBirth));
            user.setEmail(bundle.getString(email));
            user.setPhoneNumber(bundle.getString(phoneNumber));
            user.setAddress(bundle.getString(address));
            user.setImgProfile(bundle.getString(imgProfile));

            user.setUsername(bundle.getString(username));
            user.setPassword(bundle.getString(password));
            user.setRole(bundle.getString(role));

            return user;
        }
        return null;
    }
}
