package com.example.demofirebasetorecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // img=(ImageView)findViewById(R.id.dimg);
        tv1 = (TextView) findViewById(R.id.dname);
        tv2 = (TextView) findViewById(R.id.drate);
        tv3 = (TextView) findViewById(R.id.daddress);
        tv4 = (TextView) findViewById(R.id.dmail);
        tv5 = (TextView) findViewById(R.id.dtp);
        type = (TextView) findViewById(R.id.dtype);
        apply=(Button)findViewById(R.id.btnapply);
        customername=findViewById(R.id.cname);
        customeraddress=findViewById(R.id.caddress);
        customernic=findViewById(R.id.cnic);
        customercontact=findViewById(R.id.ccontact);

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