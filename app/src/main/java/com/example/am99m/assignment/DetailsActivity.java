package com.example.am99m.assignment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetailsActivity extends AppCompatActivity {
    FirebaseDatabase firebase;
    DatabaseReference reference;
    StorageReference ref;
    String id;
    artist art1;
    ImageView i1;
    TextView mCategory1,mDate1,mStatus1,mStatus11,mAddress1,mRate1,mDiscount1,mGrandtotal1,mStart1,mEnd1,mTotal1,mJob1,mService1,mRequired1;
    String mCategory2,mDate2,mStatus2,mStatus22,mAddress2,mRate2,mDiscount2,mGrandtotal2,mStart2,mEnd2,mTotal2,mJob2,mService2,mRequired2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mCategory1=(TextView)findViewById(R.id.category1);
        mDate1=(TextView)findViewById(R.id.date1);
        mStatus1=(TextView)findViewById(R.id.status1);
        mStatus11=(TextView)findViewById(R.id.status2);
        mAddress1=(TextView)findViewById(R.id.address1);
        mRate1=(TextView)findViewById(R.id.rate1);
        mDiscount1=(TextView)findViewById(R.id.discount1);
        mGrandtotal1=(TextView)findViewById(R.id.grandtotal1);
        mStart1=(TextView)findViewById(R.id.start1);
        mEnd1=(TextView)findViewById(R.id.end1);
        mTotal1=(TextView)findViewById(R.id.total1);
        mJob1=(TextView)findViewById(R.id.job_assigned1);
        mService1=(TextView)findViewById(R.id.service1);
        mRequired1=(TextView)findViewById(R.id.required1);
        i1=(ImageView)findViewById(R.id.image_view1);

        SQLiteDatabase sqLiteDatabase = getApplicationContext().openOrCreateDatabase("rec", MODE_APPEND, null);
        Cursor c = sqLiteDatabase.rawQuery("Select * from details", null);
        c.moveToLast();
        id=c.getString(0);
        //Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
        firebase=FirebaseDatabase.getInstance();
        reference=firebase.getReference("Details").child(id);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mCategory2=dataSnapshot.getValue(artist.class).getCategory();
                mCategory1.setText(mCategory2);
                mDate2=dataSnapshot.getValue(artist.class).getDate();
                mDate1.setText(mDate2);
                mStatus2=dataSnapshot.getValue(artist.class).getStatus();
                mStatus1.setText(mStatus2);
                mStatus22=dataSnapshot.getValue(artist.class).getStatus();
                mStatus11.setText(mStatus22);
                mAddress2=dataSnapshot.getValue(artist.class).getAddress();
                mAddress1.setText(mAddress2);
                mRate2=dataSnapshot.getValue(artist.class).getRate();
                mRate1.setText(mRate2);
                mDiscount2=dataSnapshot.getValue(artist.class).getDiscount();
                mDiscount1.setText(mDiscount2);
                mGrandtotal2=dataSnapshot.getValue(artist.class).getPrice();
                mGrandtotal1.setText(mGrandtotal2);
                mStart2=dataSnapshot.getValue(artist.class).getStart();
                mStart1.setText(mStart2);
                mEnd2=dataSnapshot.getValue(artist.class).getEnd();
                mEnd1.setText(mEnd2);
                mTotal2=dataSnapshot.getValue(artist.class).getTotal();
                mTotal1.setText(mTotal2);
                mJob2=dataSnapshot.getValue(artist.class).getJob();
                mJob1.setText(mJob2);
                mService2=dataSnapshot.getValue(artist.class).getService();
                mService1.setText(mService2);
                mRequired2=dataSnapshot.getValue(artist.class).getRequired();
                mRequired1.setText(mRequired2);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        ref= FirebaseStorage.getInstance().getReference("Details");
        ref.child(id).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).into(i1);
            }
        });
        setTitle(id);

    }
}
