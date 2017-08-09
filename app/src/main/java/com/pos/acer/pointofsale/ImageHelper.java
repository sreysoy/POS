package com.pos.acer.pointofsale;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Daly on 7/19/2017.
 */

public class ImageHelper {
    Activity activity;
    Context context;
    public ImageHelper(Context context , Activity activity){
        this.context = context;
        this.activity = activity;
    }
    public void pickUpImageFromGallery(int requestCode)
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        activity.startActivityForResult(intent, requestCode);
    }
//    public void pickUpImageFromCamera(int reqestCode)
//    {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        activity.startActivityForResult(intent,reqestCode);
//    }
    public void optionPickUpImage(final int requestCodeGallery)
    {
        final CharSequence[] items = {"Choose Images", "Cancel"};
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
//        builder.setTitle("Add Photo!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Choose Images")) {
                    pickUpImageFromGallery(requestCodeGallery);
                } else if (items[item].equals("Cancel")){
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }
    public void upLoadPhoto(Bitmap bitmap,String filename,String username)
    {
        ContextWrapper contextWrapper = new ContextWrapper(context);
        File directory = contextWrapper.getDir("user_profile", Context.MODE_PRIVATE);
        if (!directory.exists()){
            directory.mkdir();
        }
        File mypath = new File(directory, username+filename+".png");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            if(bitmap.getHeight()>1000 && bitmap.getWidth()>1000) {
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * 0.3), (int) (bitmap.getHeight() * 0.3), true);
            }
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();
        } catch (Exception e) {
            Log.d("SAVE_IMAGE", e.getMessage());
        }
    }
    public Bitmap getUserProfile(String name)
    {
        Bitmap bitmap = null;
        if(!name.equals("null")){
            String dataPath = context.getFilesDir().getParent()+"/app_user_profile/"+name+".png";
            bitmap = BitmapFactory.decodeFile(dataPath);
        }
        return bitmap;
    }
    public void removeOldUserProfile(String userProfile)
    {
        if(!userProfile.equals("null")) {
            String dataPath = context.getFilesDir().getParent()+"/app_user_profile/"+userProfile+".png";
            File file = new File(dataPath);
            file.delete();
        }
    }
}
