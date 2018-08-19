package com.example.am99m.assignment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by am99m on 18-08-2018.
 */

public class Myadapter extends RecyclerView.Adapter<Myadapter.CustomHolder>{
    ArrayList<String> date,bill_no,category,name,status,price,address,rate,discount,start,end,total,job,service,required;

    Context context;
    StorageReference storageReference= FirebaseStorage.getInstance().getReference("Details");

    public Myadapter(Context context, ArrayList<String> date,ArrayList<String> bill_no,ArrayList<String> category,ArrayList<String> name,ArrayList<String> status,ArrayList<String> price,ArrayList<String> address,ArrayList<String> rate,ArrayList<String> discount,ArrayList<String> start,ArrayList<String> end,ArrayList<String> total,ArrayList<String> job,ArrayList<String> service,ArrayList<String> required){
        this.context=context;
        this.date=date;
        this.bill_no=bill_no;
        this.category=category;
        this.name=name;
        this.status=status;
        this.price=price;
        this.address=address;
        this.rate=rate;
        this.discount=discount;
        this.start=start;
        this.end=end;
        this.total=total;
        this.job=job;
        this.service=service;
        this.required=required;


    }

    @Override
    public Myadapter.CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter,parent,false);

        CustomHolder customHolder=new CustomHolder(view);
        return customHolder;
    }

    @Override
    public void onBindViewHolder(final Myadapter.CustomHolder holder, int position) {

        storageReference.child(bill_no.get(position)).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(context).load(uri).into(holder.imageView);
            }
        });

        holder.mbill_no.setText(bill_no.get(position));
        holder.mdate.setText(date.get(position));
        holder.mcategory.setText(category.get(position));
        holder.mname.setText(name.get(position));
        holder.mstatus.setText(status.get(position));
        holder.mprice.setText(price.get(position));



    }

    @Override
    public int getItemCount() {
        return bill_no.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder {


        TextView mdate,mbill_no,mcategory,mname,mstatus,mprice;
        ImageView imageView;
        public CustomHolder(final View itemView) {
            super(itemView);
            mdate=(TextView)itemView.findViewById(R.id.date);
            mbill_no=(TextView)itemView.findViewById(R.id.bill_no);
            mcategory=(TextView)itemView.findViewById(R.id.category);
            mname=(TextView)itemView.findViewById(R.id.name);
            mstatus=(TextView)itemView.findViewById(R.id.status);
            mprice=(TextView)itemView.findViewById(R.id.price);
            imageView=(ImageView)itemView.findViewById(R.id.image1);
            itemView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Context c=itemView.getContext();
                            try {

                                //Toast.makeText(c, "Sqlite", Toast.LENGTH_LONG).show();
                                SQLiteDatabase sqLiteDatabase = c.openOrCreateDatabase("rec", c.MODE_APPEND, null);
                                sqLiteDatabase.execSQL("Create table if not exists details(bill_no VARCHAR);");
                                sqLiteDatabase.execSQL("Insert into details(bill_no) values('" + mbill_no.getText() + "');");


                                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                                v.getContext().startActivity(intent);
                            }catch (Exception e)
                            {
                                Toast.makeText(c, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
            );

        }


    }

}
