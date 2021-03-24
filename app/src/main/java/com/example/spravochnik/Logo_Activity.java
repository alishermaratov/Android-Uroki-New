package com.example.spravochnik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Logo_Activity extends Activity //крч когда мы создаем активити мы прописываем на extends откуда наследуем там сам импорт появится потом в настройках надо указать как этот активити Logo_Activity если нажали на него там выходит лампочка нажимаем на него и нажимаем на 3 по счету потои чтобы продожить нам надо нажать ctrl+o и выбрать uncreat и там настройки выйдут желтую надпись стираем
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);

    }

    public void onClickStart(View view)//тут мы прописываем кнопку и снизу мы пишем переход с этого активити в другой с кнопки
    {
        Intent i = new Intent(Logo_Activity.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy()//тут мы чтобы когда на телефоне назад шло опять не пришло тот то же окно мы прописываем такой код. но в целом снизу мы пишем финиш это окно появится один раз и удалится это все при включении
    {
        super.onDestroy();
        finish();
    }
}
