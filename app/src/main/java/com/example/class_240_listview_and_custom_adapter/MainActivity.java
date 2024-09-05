package com.example.class_240_listview_and_custom_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    ArrayList < HashMap <String, String> > arrayList = new ArrayList();
    HashMap <String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);

        hashMap = new HashMap<>();
        hashMap.put("name", "Ariyan");
        hashMap.put("mobile", "01793956929");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Ali Ahmad");
        hashMap.put("mobile", "01793956929");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Afroza");
        hashMap.put("mobile", "01793956929");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name", "Akhi");
        hashMap.put("mobile", "01793956929");
        arrayList.add(hashMap);

        MyAdapter myAdapter = new MyAdapter();
        myListView.setAdapter(myAdapter);


    }

    private class MyAdapter extends BaseAdapter{

        LayoutInflater layoutInflater;

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View myView = layoutInflater.inflate(R.layout.new_layout, viewGroup, false);

            ImageView imageView = myView.findViewById(R.id.imageView);

            TextView tvName = myView.findViewById(R.id.tvName);
            TextView tvMobile = myView.findViewById(R.id.tvMobile);

            HashMap <String, String> hashMap = arrayList.get(i);
            String name = hashMap.get("name");
            String mobile = hashMap.get("mobile");

            tvName.setText(name);
            tvMobile.setText(hashMap.get("mobile"));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "Hello !\n"+name, Toast.LENGTH_SHORT).show();
                }
            });
            return myView;
        }
    }
}