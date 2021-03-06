package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.AnnouncementsCRUD;
import com.example.www.CRUD.TestimonialCRUD;
import com.example.www.model.announcements;
import com.example.www.model.testimonial;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTestimonial extends AppCompatActivity {
    Button AddTestimonialBtnButton;
    EditText Testimonial,TDate,UID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_testimonial);
        AddTestimonialBtnButton=(Button)findViewById(R.id.txtTestimonialSubmitBtn);
        Testimonial=(EditText)findViewById(R.id.txtTestimonial);
        TDate=(EditText)findViewById(R.id.txtDateTestimonial);
        UID=(EditText)findViewById(R.id.txtUIDFk);
        UID.setInputType(InputType.TYPE_CLASS_NUMBER);
        UID.setInputType(InputType.TYPE_CLASS_PHONE);
        TDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        AddTestimonialBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(Testimonial.getText().length()!=0 && UID.getText().length()!=0 && TDate.getText().length()!=0) {
                        testimonial t = new testimonial();

                        t.setTestimonial(Testimonial.getText().toString().trim());
                        t.setUid(Integer.parseInt(UID.getText().toString().trim()));
                        t.setAdate(TDate.getText().toString());

                        new TestimonialCRUD(AddTestimonial.this).addTestimonial(t);
                        ShowDialog("New Testimonial Added Successfully");
                    }

                }catch (Exception e){
                    ShowDialog(e.getMessage());
                }
            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(AddTestimonial.this);
        AD.setTitle("PawnBroker");
        AD.setMessage(Message);
        AD.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AD.show();
    }
}
