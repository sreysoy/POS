package com.pos.acer.pointofsale;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;



import java.util.ArrayList;


/**
 * Created by Daly on 7/19/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> implements Filterable{
    private ImageHelper imageHelper;
    private ArrayList<User> users;
    private Context context;
    private ArrayList<User> usersFilter;
    private ImageView dialog;


    public UserAdapter(ArrayList<User> users, Context context)
    {
        this.context = context;
        this.users = users;
        usersFilter = users;
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_users_lists, parent, false);
        return new UserViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position) {
        final User user = usersFilter.get(position);
        imageHelper = new ImageHelper(context,null);
        holder.tvFullname.setText(user.getFullname());
        holder.ivUserUserProfile.setImageBitmap(imageHelper.getUserProfile(user.getImgProfile()));
        holder.dialogOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CharSequence[] items = {"Edit", "Delete", "Cancel"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Make your selection");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {

                        if (items[item].equals("Edit")) {
                            context.startActivity(new Intent(context,RegisterActivity.class));
                        } else if (items[item].equals("Delete")){
                            AlertDialog.Builder deleteBuilder = new AlertDialog.Builder(context);
                            deleteBuilder.setTitle("Confirm Delete...");
                            deleteBuilder.setMessage("Are you sure you want delete this?");
                            deleteBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,int which) {
                                    DatabaseManager databaseManager = new DatabaseManager(context);
                                    if (databaseManager.deleteUser(user.getUserId())) {
                                        Toast.makeText(context, "You clicked on YES", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            // Setting Negative "NO" Button
                            deleteBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            AlertDialog alert = deleteBuilder.create();
                            alert.show();
                        } else if (items[item].equals("Cancel")){
                            dialog.dismiss();
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        holder.getProfileDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = user.getUserId();
                Toast.makeText(context, id+"You clicked on YES", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context,ProfileUserActivity.class));
//
//                Intent intent = new Intent(context,ProfileUserActivity.class);
//                IntentObject intentObject = new IntentObject(intent);
//                intentObject.putUserIntent(user);
//                context.startActivity(intent);
        }
        });
    }
    @Override
    public int getItemCount() {
        return usersFilter.size();
    }
    private void remove(int position)
    {
        usersFilter.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String fullname = constraint.toString();
                if(fullname.isEmpty())
                {
                    usersFilter = users;
                }
                else
                {
                    ArrayList<User> usersFilterList = new ArrayList<User>();
                    for(User user:usersFilter)
                    {
                        if(user.getFullname().toLowerCase().contains(fullname))
                        {
                            usersFilterList.add(user);
                        }
                    }
                    usersFilter = usersFilterList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = usersFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                usersFilter = (ArrayList<User>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
