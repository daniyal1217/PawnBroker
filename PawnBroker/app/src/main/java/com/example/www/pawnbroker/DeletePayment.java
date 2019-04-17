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
import com.example.www.CRUD.PaymentCRUD;

public class DeletePayment extends AppCompatActivity {
    EditText et;
    Button DelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_layout);
        et=(EditText)findViewById(R.id.idtodelete);
        DelBtn=(Button)findViewById(R.id.btnDelete);
        et.setHint("Enter Payment ID to Delete");
        et.setInputType(InputType.TYPE_CLASS_NUMBER);
        et.setInputType(InputType.TYPE_CLASS_PHONE);
        DelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new PaymentCRUD(DeletePayment.this).deletePayment(Integer.parseInt(et.getText().toString()));
                    ShowDialog("Payment Deleted Successfully");
                }catch (Exception e){
                    ShowDialog(e.getMessage());
                }

            }
        });


    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(DeletePayment.this);
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

