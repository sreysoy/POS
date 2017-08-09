package com.pos.acer.pointofsale;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daly on 7/19/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {



    public LinearLayout getProfileDetail;
    public TextView tvFullname;
    public ImageView ivUserUserProfile,dialogOptions;
    private User user;
    private Context context;
    public UserViewHolder(View itemView) {
        super(itemView);
        tvFullname = (TextView)itemView.findViewById(R.id.getFullname);
        ivUserUserProfile = (ImageView)itemView.findViewById(R.id.getImage);
        dialogOptions = (ImageView) itemView.findViewById(R.id.dialogBox);
        getProfileDetail = (LinearLayout) itemView.findViewById(R.id.getProfileDetail);

    }
//    public void setUser(User user, Context context)
//    {
//        this.user = user;
//        this.context = context;
//        if(user.getRole().equals("Admin")) rlDeleteUser.setVisibility(View.GONE);
//    }

//    public void setRlUserClick()
//    {
//        rlUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, UserProfileActivity.class);
//                IntentObject intentObject= new IntentObject(intent);
//                intentObject.putUserIntent(user);
//                context.startActivity(intent);
//            }
//        });
//    }
//    public void setEditUserClick()
//    {
//        rlEditUser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, EditUersActivity.class);
//                IntentObject intentObject= new IntentObject(intent);
//                intentObject.putUserIntent(user);
//                context.startActivity(intent);
//            }
//        });
//  }
}
