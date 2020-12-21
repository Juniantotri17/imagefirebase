package com.example.imgfrb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ViewActivity extends AppCompatActivity {

    private ImageView imageView;
    TextView textView;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        imageView=findViewById(R.id.image_single_view_Activity);
        textView=findViewById(R.id.textView_single_view_Activity);
        ref= FirebaseDatabase.getInstance().getReference().child("Data");

        String Datakey=getIntent().getStringExtra("DataKey");

        ref.child(Datakey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              if (dataSnapshot.exists())
              {
                  String Judul=dataSnapshot.child("Judul").getValue().toString();
                  String ImageURL=dataSnapshot.child("ImageURL").getValue().toString();

                  Picasso.get().load(ImageURL).into(imageView);
                  textView.setText(Judul);
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
