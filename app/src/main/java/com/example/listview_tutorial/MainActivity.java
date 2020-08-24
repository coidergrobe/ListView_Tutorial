package com.example.listview_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);
        ContactAdapter adapter = new ContactAdapter(listContacts, this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this, contactModel.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel("Seraphine", "123456789", R.drawable.avt1);
        listContacts.add(contact);
        contact = new ContactModel("Xayah", "987654321", R.drawable.avt2);
        listContacts.add(contact);
        contact = new ContactModel("Ahri", "123456987", R.drawable.avt3);
        listContacts.add(contact);
        contact = new ContactModel("Akali", "123987654", R.drawable.avt4);
        listContacts.add(contact);
        contact = new ContactModel("Kai'sa", "987123456", R.drawable.avt5);
        listContacts.add(contact);
    }
}