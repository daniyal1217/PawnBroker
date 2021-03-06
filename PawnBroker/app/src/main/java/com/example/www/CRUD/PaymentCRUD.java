package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.www.DB.Db;
import com.example.www.model.payment;

import java.util.ArrayList;

public class PaymentCRUD {

    Context context;
    Db d;
    public PaymentCRUD(Context context){
        this.context=context;
        d= new Db(context);
        d.OpenorCreatDB();
    }
    public void addPayment(payment u){
        String sql = "insert into payment(amount, pdate, TrID,type) values('"+u.getAmount()+"','"+u.getPdate()+"', '"+u.getTrID()+"','"+u.getType()+"')";
        d.executequery(sql);
    }
    public void updatePayment(payment u){
        String sql = "update payment set amount='"+u.getAmount()+"',pdate='"+u.getPdate()+"', TrID='"+u.getTrID()+"',type='"+u.getType()+"' where pid='"+u.getPid()+"'  ";
        d.executequery(sql);
    }
    public void deletePayment(int pid){
        String sql = "delete from payment where pid= "+pid+"; ";
        d.executequery(sql);
    }

    public ArrayList<payment> viewAllPayments(){
        Cursor c = d.executerawquery("select * from payment");
        ArrayList<payment> getPayments = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            payment u= new payment() ;
            u.setPid(c.getInt(c.getColumnIndex("PID")));
            u.setAmount(c.getFloat(c.getColumnIndex("amount")));
            u.setPdate(c.getString(c.getColumnIndex("pdate")));
            u.setTrID(c.getInt(c.getColumnIndex("TrID")));
            u.setType(c.getString(c.getColumnIndex("type")));
            getPayments.add(u);
            //Toast.makeText(context, getPayments.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getPayments;
    }
    public ArrayList<String> searchPaymentsByDate(String date){
        Cursor c = d.executerawquery("select * from payment where pdate='"+date+"'");
        ArrayList<String> getPayments = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("PID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("pdate"));
            u+="\t";
            u+=String.valueOf(c.getFloat(c.getColumnIndex("amount")));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("TrID")));

            u+=String.valueOf(c.getInt(c.getColumnIndex("type")));
            getPayments.add(u);
            //Toast.makeText(context, getPayments.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getPayments;
    }
    public ArrayList<String> searchPaymentsByType(String type){
        Cursor c = d.executerawquery("select * from payment where type='"+type+"' COLLATE NOCASE");
        ArrayList<String> getPayments = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("PID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("pdate"));
            u+="\t";
            u+=String.valueOf(c.getFloat(c.getColumnIndex("amount")));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("TrID")));
            u+=String.valueOf(c.getInt(c.getColumnIndex("type")));



            getPayments.add(u);
            //Toast.makeText(context, getPayments.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return getPayments;
    }

    public ArrayList<String> searchPaymentsByTransaction(int TrID){
        Cursor c = d.executerawquery("select * from payment where TrID='"+TrID+"'");
        ArrayList<String> getPayments = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("PID")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("pdate"));
            u+="\t";
            u+=String.valueOf(c.getFloat(c.getColumnIndex("amount")));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("TrID")));
            u+=String.valueOf(c.getInt(c.getColumnIndex("type")));
            getPayments.add(u);
            //Toast.makeText(context, getPayments.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getPayments;
    }


}
