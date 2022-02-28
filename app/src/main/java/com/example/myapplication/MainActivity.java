package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> myList;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private TextView tv_HienThi;
    private EditText edt_NhapTen;
    private Button buttonNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listproduct);
        tv_HienThi=findViewById(R.id.tv_HienThi);
        edt_NhapTen=findViewById(R.id.edt_NhapTen);
        buttonNhap=findViewById(R.id.bt_Nhap);

        myList=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,myList);
        listView.setAdapter(adapter);

        buttonNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myList.add(edt_NhapTen.getText()+"");
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg="position "+position;
                msg+="; value: "+parent.getItemAtPosition(position).toString();
                tv_HienThi.setText(msg);
            }
        });

    }
}