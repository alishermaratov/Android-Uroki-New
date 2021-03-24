package com.example.spravochnik;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener//для того чтобы нажимались кнопки во время окон по свайпу
{

private DrawerLayout drawer; //чтобы мы могли управлять свайпом
private ListView list; //тут мы присваеваем чтобы могли работать с атрибутом листвью для списка
private String[] array; //это уже сам список с которым мне уже можно работать мы просто создаем переменную
private ArrayAdapter<String> adapter; // через эту переменную мы связываем сам список с готовым списком который мы прописали
private Toolbar toolbar;
private int category_index;// для того чтобы мы понимали какую именно категорию в меню мы создали




    @Override// для запуска начального экрана
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //  тут уже создаем сам список и пишем все туда снизу который
        list = findViewById(R.id.ListView);//сдесь после запуска экрана работаем вместе с ральной переменной лист вью находим ее уже после запуска экрана сверху и через ай ди находим с чем работать теперь нам надо соеденить сам список с готовым списком который мы приготовили
        array = getResources().getStringArray(R.array.fish_array);//тут уже мы сам этот список достаем
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,new ArrayList<String>(Arrays.asList(array))); // тут сам аррай добовляют к адаптеру      ,new ArrayList<String>(Arrays.asList(array) тут крч мы сделаи так чтобы можно было создавать лист адапетр и можно было несколько раз использовать переменную аррай
        list.setAdapter(adapter);// здесь этот самый адаптер привязывают к нему



       // сдесь мы уже при нажатий на этот же лист вью чтобы переходил на новый активити а там уже готовый файл который текст и фото будет
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
Intent intent = new Intent(MainActivity.this,Text_content_activiti.class);// тут мы говорим что при нажатий мы перемещаемся в другой активити который создали
intent.putExtra("category", category_index); // сделан для того чтобы передать какой именно кнопку открывать и какой ресурс передавать в тот самый активити. типа мы то знаем что в слушатель нажати пришло уведамления и там именно какой инт именна какая категория будет передаваться в этот самый активити чтобы там уже его открывать и показывать
intent.putExtra("position", position);// это для того чтобы передавать какой именно по списку я хочу передать инфу опять же все идет в тот самый активити где у нас и будет показыватся

startActivity(intent);//системе говорим чтобы запустил этот активити уже
            }
        });


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



// делаем кнопку для свайпа
// снизу

        drawer = findViewById(R.id.drawer_layout); //делаем кнопку и свайп меню
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this); //делаем слушытель нажатий теперь когда буду нажимать на элементы свйпа навигации то будут нажиматся и передаватся айди на класс снизу
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


    }

    @Override// тут мы добавляем меню
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        toolbar.setTitle(R.string.menu_home);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override// тут уже класс где мы описываем само меню
    public boolean onNavigationItemSelected(@NonNull MenuItem item) // клас где мы будем описывать эти кнопки именно какую нажали если ту или иную нажали что дальше д=делать
    {
        int id = item.getItemId();
        if (id == R.id.nav_home)// это мы вот именно по айди какую именно кнопку нажали пытаемся понять
        {
            /*toolbar.setTitle(R.string.menu_home);
            Toast.makeText(this, " Кнопка Home", Toast.LENGTH_SHORT).show();
            array = getResources().getStringArray(R.array.fish_array);
            adapter.clear();//тут мы стираем наш готовый список и дальше
            adapter.addAll(array);//вместо него ставим новый список, это все стало возможно так как мы в адаптере прописали лист адаптер
            adapter.notifyDataSetChanged();// это мы говорим адаптеру что поменяли адаптер уведомить что что то изменилось в адаптере и чтобы адаптер поменялся
            category_index = 0;// тут мы даем индекс для каждой кнопки чтобы уметь переходить между ними*/
            fillArray(R.string.menu_home, R.array.fish_array, 0);//это готовая функция чтобы не занимать место и не писать очень много кода
        }
        else if (id == R.id.nav_gallery)
        {

            fillArray(R.string.menu_gallery,R.array.fff_array, 1 );
        }
        else if (id == R.id.nav_slideshow)
        {

            fillArray(R.string.menu_slideshow,R.array.ccc_array, 2 );
        }
        else if (id == R.id.nav_share)
        {

            fillArray(R.string.menu_share,R.array.ggg_array,3 );
        }
        else if (id == R.id.nav_send)
        {

            fillArray(R.string.menu_send,R.array.grt_array, 4 );
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

private void fillArray(int title, int array_list, int category)// делаем функцию для того чтобы использовать ее на кнопки для того чтобы не повторялись все чтам писалось теперь ткт но просто заменены премеными
{
    toolbar.setTitle(title);
    Toast.makeText(this, " Кнопка send", Toast.LENGTH_SHORT).show();

    array = getResources().getStringArray(array_list);
    adapter.clear();//тут мы стираем наш готовый список и дальше
    adapter.addAll(array);//вместо него ставим новый список, это все стало возможно так как мы в адаптере прописали лист адаптер
    adapter.notifyDataSetChanged();// это мы говорим адаптеру что поменяли адаптер
    category_index = category;

}
}