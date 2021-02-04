package kg.itrun.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity { //Надо было что то написать, но не написали

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        ConstraintLayout constraintLayout = new ConstraintLayout(this);

        TextView textView = new TextView(this);
        // установка цвета текстового поля
        textView.setBackgroundColor(0xFFE0E0E0);
        // установка текста текстового поля
        textView.setText("Hello Android");
        // установка размера текста
        textView.setTextSize(30);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT , ConstraintLayout.LayoutParams.WRAP_CONTENT);
        // установка внешних отступов
        layoutParams.setMargins(60, 50, 60, 50);
        // позиционирование в левом верхнем угду контейнера
        // эквивалент app:layout_constraintLeft_toLeftOf="parent"
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        // эквивалент app:layout_constraintTop_toTopOf="parent"
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        // устанавливаем размеры
        textView.setLayoutParams(layoutParams);
        // установка внутренних отступов
        textView.setPadding(40,40,40,40);
        // добавляем TextView в ConstraintLayout
        constraintLayout.addView(textView);

        setContentView(constraintLayout);
    }
}