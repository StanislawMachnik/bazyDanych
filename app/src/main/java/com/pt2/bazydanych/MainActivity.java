package com.pt2.bazydanych;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    PrzepisyDataBase przepisyDataBase;
    private EditText nazwa;
    private EditText skladniki;
    private EditText temperatura;
    private EditText czas_pieczenia;
    private Button dodaj;
    private Button edytuj;
    private String nazwa_text;
    private String skladniki_text;
    private int temp;
    private int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nazwa = findViewById(R.id.nazwa);
        skladniki = findViewById(R.id.skladniki);
        temperatura = findViewById(R.id.temperatura);
        czas_pieczenia = findViewById(R.id.czas_pieczenia);
        dodaj = findViewById(R.id.dodaj);
        edytuj = findViewById(R.id.edytuj);

        przepisyDataBase = PrzepisyDataBase.zwrocInstancjeBazyDanych(MainActivity.this);

        listView = findViewById(R.id.lista);
        List<Wypieki> wszystkieWypiekiList = przepisyDataBase.zwrocWypiekiDao().zwrocWszystkieWypiekiZBazy();
        ArrayAdapter<Wypieki> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, wszystkieWypiekiList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        przepisyDataBase.zwrocWypiekiDao().usunZBazy(wszystkieWypiekiList.get(i));
                        wszystkieWypiekiList.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        return false;
                    }
                }
        );
        dodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nazwa_text = String.valueOf(nazwa.getText());
                        skladniki_text = String.valueOf(skladniki.getText());
                        temp = Integer.parseInt(String.valueOf(temperatura.getText()));
                        time = Integer.parseInt(String.valueOf(czas_pieczenia.getText()));

                        przepisyDataBase.zwrocWypiekiDao().wstawWypiekDoBazy(new Wypieki(nazwa_text, skladniki_text, temp, time));
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
    }
}