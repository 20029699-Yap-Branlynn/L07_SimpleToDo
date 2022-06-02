package sg.edu.rp.c346.id20029699.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button addBtn;
    Button clearBtn;
    ListView lv;
    ArrayList<String> alToDo;
    ArrayAdapter<String> aaToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editTextActivity);
        addBtn = findViewById(R.id.buttonAdd);
        clearBtn = findViewById(R.id.buttonClear);
        lv = findViewById(R.id.ListViewToDo);

        alToDo = new ArrayList<>();

        aaToDo = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alToDo);

        lv.setAdapter(aaToDo);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userActivity = input.getText().toString();
                alToDo.add(userActivity);
                aaToDo.notifyDataSetChanged();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alToDo.clear();
                aaToDo.notifyDataSetChanged();
            }
        });
    }
}