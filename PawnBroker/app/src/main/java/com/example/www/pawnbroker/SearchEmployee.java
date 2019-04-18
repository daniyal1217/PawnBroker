package com.example.www.pawnbroker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.www.CRUD.EmployeeCRUD;

import java.util.ArrayList;

public class SearchEmployee extends AppCompatActivity {

    EditText et;
    ListView lv;
    Button btnSearch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_employee);
        et = (EditText)findViewById(R.id.itemToSearchEmployee);
        lv = (ListView)findViewById(R.id.lvEmployee);
        btnSearch = (Button)findViewById(R.id.btnEmployeeSearch);
        spinner = (Spinner)findViewById(R.id.spinner);

        ArrayList<String> arrLst = new ArrayList<String>();
        arrLst.add("Employee ID");
        arrLst.add("First Name");
        arrLst.add("Last Name");
        ArrayAdapter adapt = new ArrayAdapter(SearchEmployee.this, android.R.layout.simple_list_item_1,arrLst);
        spinner.setAdapter(adapt);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayAdapter AL = null;
                String input = et.getText().toString().trim();

                if(spinner.getSelectedItem().equals("Employee ID")){
                    Toast.makeText(SearchEmployee.this, "u entered Emp id", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchEmployee.this,android.R.layout.simple_list_item_1,new EmployeeCRUD(SearchEmployee.this).searchEmployeeByID(Integer.parseInt(input)));
                }
                else if(spinner.getSelectedItem().equals("First Name")){
                    Toast.makeText(SearchEmployee.this, "u entered first name", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchEmployee.this,android.R.layout.simple_list_item_1,new EmployeeCRUD(SearchEmployee.this).searchEmployeeByFname(input.toString()));
                }
                else if(spinner.getSelectedItem().equals("Last Name")){
                    Toast.makeText(SearchEmployee.this, "u entered last name", Toast.LENGTH_SHORT).show();
                    AL = new ArrayAdapter(SearchEmployee.this,android.R.layout.simple_list_item_1,new EmployeeCRUD(SearchEmployee.this).searchEmployeeByLname(input.toString()));
                }

                lv.setAdapter(AL);
            }
        });



    }
}