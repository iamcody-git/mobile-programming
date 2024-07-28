package prashant.com;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        ListView listView = findViewById(R.id.listView);

          GridView gridView = findViewById(R.id.GridView);

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false);
//        recyclerView.setLayoutManager(linearLayoutManager);

        List<EmailItem> emailItems = new ArrayList<EmailItem>();

        emailItems.add(new EmailItem("A", "Apple","hello syauuuuu"));
        emailItems.add(new EmailItem("B", "Banana","hello keraaa"));
        emailItems.add(new EmailItem("C", "cody","hello I am cody "));
        emailItems.add(new EmailItem("D", "Duck","na haasssssss "));

//        MailAdapter  mailAdapter = new MailAdapter(emailItems);
//        recyclerView.setAdapter(mailAdapter);



//        String[] emails = {"first mail", "second mail", "third mail"};
//
//        ArrayAdapter<String> mailAdapter = new ArrayAdapter<String>(this,R.layout.recyclerview_mail_item,R.id.title,emails);

        MailArrayAdapter mailAdapter = new MailArrayAdapter(this,emailItems);
//        listView.setAdapter(mailAdapter);
        gridView.setAdapter(mailAdapter);


    }
}