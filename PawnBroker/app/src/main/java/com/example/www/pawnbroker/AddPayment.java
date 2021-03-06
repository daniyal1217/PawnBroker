package com.example.www.pawnbroker;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.www.CRUD.PaymentCRUD;
import com.example.www.CRUD.TransactionCRUD;
import com.example.www.model.payment;
import com.example.www.model.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddPayment extends AppCompatActivity {
    Button AddPaymenttBtnButton;
    EditText Amount,PDate,Trid,PaymentType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_payment);
        AddPaymenttBtnButton=(Button)findViewById(R.id.txtPaymentSubmitBtn);
        Amount=(EditText)findViewById(R.id.txAmount);
        PDate=(EditText)findViewById(R.id.txtDatePayment);
        Trid=(EditText)findViewById(R.id.txtIDTransaction);
        PaymentType=(EditText)findViewById(R.id.txtTypePayment);
        PDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        AddPaymenttBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(Amount.getText().length()!=0 && Trid.getText().length()!=0 && PDate.getText().length()!=0 && PaymentType.getText().length()!=0 ) {
                        payment p = new payment();
                        SimpleDateFormat fm = new SimpleDateFormat("dd-MM-yyyy");
                        p.setAmount(Float.parseFloat(Amount.getText().toString()));
                        p.setTrID(Integer.parseInt(Trid.getText().toString()));
                        p.setPdate(PDate.getText().toString());
                        p.setType(PaymentType.getText().toString());
                        new PaymentCRUD(AddPayment.this).addPayment(p);
                        ShowDialog("New Payment Added Successfully");
                    }else {
                        ShowDialog("Please enter all values!");
                    }

                }catch (SQLiteException e){
                    ShowDialog(e.getMessage());
                }catch (Exception e){
                    ShowDialog(e.getMessage());
                }

            }
        });
    }
    public void ShowDialog(String Message)
    {
        AlertDialog.Builder AD = new AlertDialog.Builder(AddPayment.this);
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

