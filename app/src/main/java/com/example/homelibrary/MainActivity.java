package com.example.homelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView listBooks;
    EditText nameBookText;
    Button addBookButton;
    ArrayList<Book> books;
    //ArrayAdapter<Book> arrayAdapter;
    //Resources res;
    SharedPreferences myShared;
    SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myShared = getSharedPreferences("saveInfo", MODE_PRIVATE);
        listBooks = findViewById(R.id.book_list);
        addBookButton = findViewById(R.id.add_button);
        nameBookText = findViewById(R.id.name_book);
        //res = getResources();
        books = new ArrayList<>();
        books.add(new Book("Академия", "Айзек Азимов", 2000, R.drawable.book));
        books.add(new Book("Незнакомцы в поезде", "Патриция Хайсмит", 2013, R.drawable.book));
        books.add(new Book("Десять негритят", "Агата Кристи", 2020, R.drawable.book));
        books.add(new Book("Двадцать тысяч лье под водой", "Жюль Верн", 1928, R.drawable.book));
        books.add(new Book("\"1984\"","Джордж Оруэлл ", 2010, R.drawable.book));
        books.add(new Book("Автостопом по галактике", "Дуглас Адамс", 2018, R.drawable.book));

        //Подготовка данных для SimpleAdapter
        //список ключей
        String fromKeys[] = {"author", "title", "year", "cover"};
        LinkedList<HashMap<String, Object>> booksForAdapter = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            HashMap<String, Object> book = new HashMap<>();
            book.put(fromKeys[0], books.get(i).author);
            book.put(fromKeys[1], books.get(i).title);
            book.put(fromKeys[2], books.get(i).year);
            book.put(fromKeys[3], books.get(i).cover);
            booksForAdapter.add(book);

        }
        //массив идентификаторов
        int [] to = {R.id.author, R.id.title, R.id.year, R.id.cover};

        //создать адаптер
        //arrayAdapter = new ArrayAdapter<>(this, R.layout.list_item, books);
        simpleAdapter = new SimpleAdapter(this, booksForAdapter,
                R.layout.simple_list_item, fromKeys, to);
        //simpleAdapter.notifyDataSetChanged();
        listBooks.setAdapter(simpleAdapter);
        listBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TextView title = view.findViewById(R.id.title);
                Toast.makeText(getApplicationContext(), adapterView.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String s = myShared.getString("Title book", "Noname");
        if (!s.equals("Noname")){
            nameBookText.setText(s);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = myShared.edit();
        editor.putString("Title book", nameBookText.getText().toString());
        editor.commit();
        Toast.makeText(this, "Данные записаны", Toast.LENGTH_SHORT).show();
    }
}