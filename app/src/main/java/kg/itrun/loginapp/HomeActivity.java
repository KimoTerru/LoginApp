package kg.itrun.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity { //То что нам нужно...
    TextView nameText;
    TextView positionText;
    ImageView backButton;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nameText = findViewById(R.id.name_text);
        positionText = findViewById(R.id.position_text);
        backButton = findViewById(R.id.imageView);

        prefs = getSharedPreferences("userdata", MODE_PRIVATE);
        String username = prefs.getString("username", null);
        String position = prefs.getString("position", null);
        nameText.setText(username);
        positionText.setText(position);

        backButton.setOnClickListener(new View.OnClickListener() { //Кнопка назад
            @Override
            public void onClick(View v) {
                prefs.edit().clear().commit(); //Возвращает данные после закрытия
                finish();
            }
        });
    }
}