package com.example.www.CRUD;

import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.www.DB.Db;
import com.example.www.model.visitation;

import java.util.ArrayList;

public class VisitationCRUD {

    Context context;
    Db d;
    public VisitationCRUD(Context context){
        this.context=context;
        d= new Db(context);
        d.OpenorCreatDB();
    }

    public void addVisitation(visitation u){
        String sql = "insert into visitation(visitation, empid, vdate) values('"+u.getVisitation()+"','"+u.getEmpid()+"','"+u.getVdate()+"')";
        d.executequery(sql);
    }
    public void updateVisitation(visitation u){
        String sql = "update visitation set visitation='"+u.getVisitation()+"',empid='"+u.getEmpid()+"', vdate='"+u.getVdate()+"' where vid='"+u.getVid()+"' ";
        d.executequery(sql);
    }
    public void deleteVisitation(int vid){
        String sql = "delete from visitation where vid= "+vid+"; ";
        d.executequery(sql);
    }

    public ArrayList<visitation> viewAllVisitation(){
        Cursor c = d.executerawquery("select * from visitation");
        ArrayList<visitation> getVisitation = new ArrayList<>();
        c.moveToFirst();

        while(!c.isAfterLast()){
            visitation u =new visitation();
            u.setVid(c.getInt(c.getColumnIndex("vid")));
            u.setVisitation(c.getString(c.getColumnIndex("visitation")));
            u.setEmpid(c.getInt(c.getColumnIndex("empid")));
            u.setVdate(c.getString(c.getColumnIndex("vdate")));

            getVisitation.add(u);
            //Toast.makeText(context, getVisitation.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getVisitation;
    }
    public ArrayList<String> searchVisitationByID(int vid){
        Cursor c = d.executerawquery("select * from visitation where vid='"+vid+"'");
        ArrayList<String> getVisitation = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("vid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("visitation"));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("empid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("vdate"));

            getVisitation.add(u);
            //Toast.makeText(context, getVisitation.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getVisitation;
    }
    public ArrayList<String> searchVisitationByDate(String date){
        Cursor c = d.executerawquery("select * from visitation where vdate='"+date+"'");
        ArrayList<String> getVisitation = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("vid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("visitation"));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("empid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("vdate"));

            getVisitation.add(u);
            //Toast.makeText(context, getVisitation.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getVisitation;
    }
    public ArrayList<String> searchVisitationByEmp(int empid){
        Cursor c = d.executerawquery("select * from visitation where empid='"+empid+"'");
        ArrayList<String> getVisitation = new ArrayList<>();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String u ;
            u=String.valueOf(c.getInt(c.getColumnIndex("vid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("visitation"));
            u+="\t";
            u+=String.valueOf(c.getInt(c.getColumnIndex("empid")));
            u+="\t";
            u+=c.getString(c.getColumnIndex("vdate"));

            getVisitation.add(u);
            //Toast.makeText(context, getVisitation.get(0).toString(), Toast.LENGTH_SHORT).show();
            c.moveToNext();
        }
        return  getVisitation;
    }


}
