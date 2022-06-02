package sg.edu.rp.c346.id20029699.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText input;
    Button addBtn;
    Button clearBtn;
    Button deleteBtn;
    ListView lv;
    ArrayList<String> alToDo;
    ArrayAdapter<String> aaToDo;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editTextActivity);
        addBtn = findViewById(R.id.buttonAdd);
        clearBtn = findViewById(R.id.buttonClear);
        deleteBtn = findViewById(R.id.buttonDelete);
        lv = findViewById(R.id.ListViewToDo);
        spinner = findViewById(R.id.spinner);

        alToDo = new ArrayList<>();

        aaToDo = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alToDo);

        lv.setAdapter(aaToDo);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        input.setHint("Type in a new task here");
                        deleteBtn.setEnabled(false);
                        addBtn.setEnabled(true);
                        break;

                    case 1:
                        input.setHint("Type in the index of the task to be removed");
                        deleteBtn.setEnabled(true);
                        addBtn.setEnabled(false);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alToDo.isEmpty() == false){
                    int userDelete = Integer.parseInt(input.getText().toString());
                    if (userDelete < alToDo.size()){
                        alToDo.remove(userDelete);
                        aaToDo.notifyDataSetChanged();
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                    }
                    
                    
                }
                else {
                    Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}