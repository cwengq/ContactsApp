package za.hp.cwengandudula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Contact> contacts;
    private ContactAdapter adapter;
    private Contact curContact;
    private int curindex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = Contact.getContacts();

        RecyclerView lstContacts = findViewById(R.id.lstContacts);

        adapter = new ContactAdapter(contacts);

        RecyclerView.LayoutManager lm;
        lm = new LinearLayoutManager(getApplicationContext());
        lstContacts.setLayoutManager(lm);
        lstContacts.setAdapter(adapter);

        lstContacts.addItemDecoration(new EqualSpaceItemDecoration(20));
    }

    public void onAddClicked(View view) {
        Intent intent = new Intent(MainActivity.this, ContactCardActivity.class);
        startActivity(intent);
    }
}