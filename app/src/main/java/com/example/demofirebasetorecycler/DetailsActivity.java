package com.example.demofirebasetorecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.Normalizer;

public class DetailsActivity extends AppCompatActivity {
    ImageView img;
    TextView tv1, tv2, tv3, tv4, tv5,type;
    Button apply;
    EditText customername,customeraddress,customernic,customercontact,customermail;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //DIALOG BOX INTIALIZE
        dialog=new Dialog(DetailsActivity.this);
        dialog.setContentView(R.layout.alert);
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.bac));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations=R.style.animation;


        // img=(ImageView)findViewById(R.id.dimg);
        tv1 = (TextView) findViewById(R.id.dname);
        tv2 = (TextView) findViewById(R.id.drate);
        tv3 = (TextView) findViewById(R.id.daddress);
        tv4 = (TextView) findViewById(R.id.dmail);
        tv5 = (TextView) findViewById(R.id.dtp);
        type = (TextView) findViewById(R.id.dtype);
        customername=findViewById(R.id.cname);
        customeraddress=findViewById(R.id.caddress);
        customernic=findViewById(R.id.cnic);
        customercontact=findViewById(R.id.ccontact);


        //Dialog box button actions
        Button okey=dialog.findViewById(R.id.btnok);

        okey.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(DetailsActivity.this, "Accepted !", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



        apply=(Button)findViewById(R.id.btnapply);

        // img.setImageResource(getIntent().getIntExtra("image",0));
        tv1.setText(getIntent().getStringExtra("name"));
        tv2.setText(getIntent().getStringExtra("rate"));
        tv3.setText(getIntent().getStringExtra("address"));
        tv4.setText(getIntent().getStringExtra("mail"));
        tv5.setText(getIntent().getStringExtra("tp"));

        //Save data in firebase on button click
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //RUN DIALOG
                dialog.show();

                //STORE INTO DATABASE
                rootNode=FirebaseDatabase.getInstance();
                reference=rootNode.getReference("customers");

                //Get and set all data values
                String name=customername.getText().toString();
                String address=customeraddress.getText().toString();
                String nic=customernic.getText().toString();
                String contact=customercontact.getText().toString();

                String bank=tv1.getText().toString();
                String rate=tv2.getText().toString();
                String Type=type.getText().toString();

                form myform=new form(address,contact,name,nic,bank,rate,Type);
                reference.child(nic).setValue(myform);

            }
        });

    }
}