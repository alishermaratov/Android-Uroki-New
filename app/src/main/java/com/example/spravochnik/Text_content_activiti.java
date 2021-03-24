package com.example.spravochnik;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Text_content_activiti extends AppCompatActivity
{
    private TextView text_content;
    private ImageView iContent;
    private Typeface facel;
    private int category = 0;
    private int position = 0;

    private int [] array_fish = {R.string.text_fish, R.string.text_fish1, R.string.text_fish2, R.string.text_fish3, R.string.text_fish4};//все сразу ебашим в список чтобы потом просто было легче работать
    private int [] array_image_fish = {R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_manage, R.drawable.ic_menu_send};

    private int [] array_na = {R.string.text_na1, R.string.text_na2, R.string.text_na3, R.string.text_na4};
    private int [] array_na_image = {R.drawable.alis, R.drawable.foto, R.drawable.ic_menu_send, R.drawable.side_nav_bar};

    private int [] array_qqq = {R.string.text_na_1, R.string.text_na_2, R.string.text_na_3, R.string.text_na_4};
    private int [] array_image_fish_1 = {R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_manage, R.drawable.ic_menu_send};


    private int [] array_qqq_1 = {R.string.text_na_1_1, R.string.text_na_2_2, R.string.text_na_3_3, R.string.text_na_4_4};
    private int [] array_image_fish_2 = {R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_manage, R.drawable.ic_menu_send};


    private int [] array_uuu = {R.string.text_r_1, R.string.text_r_2, R.string.text_r_3, R.string.text_r_4, R.string.text_r_5};
    private int [] array_image_fish_3= {R.drawable.ic_menu_camera, R.drawable.ic_menu_gallery, R.drawable.ic_menu_manage, R.drawable.ic_menu_send};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content); //запускаем файл чтобы включать новый экран для приложения текст контент будем сейчас запускать через этот лояут
        init();//тут та самая функция котрый отвечает за текст 
        reciveIntent();

    }







    private void reciveIntent()//это функция которая принимает от другого активити значения
    {
        Intent i = getIntent();
        if (i != null)
        {
        category = i.getIntExtra("category", 0 );
        position = i.getIntExtra("position", 0 );
        }
        switch (category)//какое значения и придет такой код и по значению будет запускаться там все номера снизу стоят
        {
            case 0:
                iContent.setImageResource(array_image_fish[position]);
                text_content.setText(array_fish[position]);

                break;

            case 1:
                iContent.setImageResource(array_na_image[position]);
                text_content.setText(array_na[position]);

                break;

            case 2:
                iContent.setImageResource(array_image_fish_1[position]);
                text_content.setText(array_qqq[position]);

                break;

            case 3:
                iContent.setImageResource(array_image_fish_2[position]);
                text_content.setText(array_qqq_1[position]);

                break;

            case 4:
                iContent.setImageResource(array_image_fish_3[position]);
                text_content.setText(array_uuu[position]);


                break;


        }
    }

    private void init() //тут мы меняем шрифт
    {
        text_content = findViewById(R.id.text_main_content);
        iContent = findViewById(R.id.imContent);
        facel = Typeface.createFromAsset(this.getAssets(), "fonts/Comfortaa-VariableFont_wght.ttf");
        text_content.setTypeface(facel);
    }
}
