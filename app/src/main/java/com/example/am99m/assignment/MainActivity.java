package com.example.am99m.assignment;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> date,bill_no,category,name,status,price,address,rate,discount,start,end,total,job,service,required;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;
    artist art;
    Myadapter myadapter;
    private Boolean mPermissionGranted=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv1);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration =new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(itemDecoration);

        date=new ArrayList<String>();
        bill_no=new ArrayList<String>();
        category=new ArrayList<String>();
        name=new ArrayList<String>();
        status=new ArrayList<String>();
        price=new ArrayList<String>();
        address=new ArrayList<String>();
        rate=new ArrayList<String>();
        discount=new ArrayList<String>();
        start=new ArrayList<String>();
        end=new ArrayList<String>();
        total=new ArrayList<String>();
        job=new ArrayList<String>();
        service=new ArrayList<String>();
        required=new ArrayList<String>();
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference("Details");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                date.clear();
                bill_no.clear();
                category.clear();
                name.clear();
                status.clear();
                price.clear();
                address.clear();
                rate.clear();
                discount.clear();
                start.clear();
                end.clear();
                total.clear();
                job.clear();
                service.clear();
                required.clear();
                for(DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    art=snapshot.getValue(artist.class);
                    date.add(art.getDate());
                    bill_no.add(art.getBill_no());
                    category.add(art.getCategory());
                    name.add(art.getName());
                    status.add(art.getStatus());
                    price.add(art.getPrice());
                    address.add(art.getAddress());
                    rate.add(art.getRate());
                    discount.add(art.getDiscount());
                    start.add(art.getStart());
                    end.add(art.getEnd());
                    total.add(art.getTotal());
                    job.add(art.getJob());
                    service.add(art.getService());
                    required.add(art.getRequired());
                }
                myadapter=new Myadapter(getApplicationContext(),date,bill_no,category,name,status,price,address,rate,discount,start,end,total,job,service,required);
                recyclerView.setAdapter(myadapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        setTitle("My Orders");
    }
}
