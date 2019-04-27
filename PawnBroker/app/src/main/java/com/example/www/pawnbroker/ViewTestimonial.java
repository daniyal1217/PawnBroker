package com.example.www.pawnbroker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.www.CRUD.TestimonialCRUD;
import com.example.www.CRUD.VisitationCRUD;
import com.example.www.adapter.TestimonialAdapter;

public class ViewTestimonial extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_forall);
        lv=(ListView)findViewById(R.id.lv);
        TestimonialAdapter ap = new TestimonialAdapter(this,new TestimonialCRUD(this).viewAllTestimonial(),"update");
        lv.setAdapter(ap);
        BroadcastReceiver broadcast_reciever = new BroadcastReceiver() {
            @Override
            public void onReceive(Context arg0, Intent intent) {
                String action = intent.getAction();
                if (action.equals("refresh")) {

                    lv.setAdapter(null);
                    TestimonialAdapter ap = new TestimonialAdapter(ViewTestimonial.this,new TestimonialCRUD(ViewTestimonial.this).viewAllTestimonial(),"update");
                    lv.setAdapter(ap);

                }
            }
        };
        registerReceiver(broadcast_reciever, new IntentFilter("refresh"));
    }
}
