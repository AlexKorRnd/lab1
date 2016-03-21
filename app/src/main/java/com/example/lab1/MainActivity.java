package com.example.lab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    // так как в этой лабе парсить json в этой лабе не надо, то заполняем данные вручную
    // можно таким же образом добавить еще данные
    static final ArrayList<Item> TEST_ITEMS = new ArrayList<>();
    static {
        TEST_ITEMS.add(new Item("http://piresearch.net/wp-content/uploads/2013/09/Tropical-Plumeria-Flower-Flower-Wallpaper.jpg",
                "Тропический цветок"));
        TEST_ITEMS.add(new Item("http://z-walls.ru/mo/47/cvetki_sakury_1280x800.jpg", "Розовые цветы"));
        TEST_ITEMS.add(new Item("http://www.zastavki.com/pictures/1400x1050/2014/Holidays___International_Womens_Day_Tulips_on_March_8_057387_22.jpg",
                "Тюльпаны"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // настраиваем Toolbar(сгенерировано автоматически IDE при выборе BlankActivity при создании проекта
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // добавляем LayoutManager для RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, TEST_ITEMS);
        recyclerView.setAdapter(adapter);
    }


}
