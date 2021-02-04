package kg.itrun.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {
    EditText name;
    EditText position;
    EditText login;
    EditText password;
    EditText passwordRepeat;
    TextView signUp;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.name_edit_text); //Поиск наших кнопок
        position = findViewById(R.id.position_edit_text);
        login = findViewById(R.id.login_edit_text);
        password = findViewById(R.id.password_edit_text);
        passwordRepeat = findViewById(R.id.password_repeat_edit_text);
        signUp = findViewById(R.id.sign_up_text);
        back = findViewById(R.id.back_image);

        back.setOnClickListener(new View.OnClickListener() { //Кнопка закрытия
            @Override
            public void onClick(View v) {
                finish();
            } //Закрывает приложение
        });
        signUp.setOnClickListener(new View.OnClickListener() { //Кнопка войти
            @Override
            public void onClick(View v) {
                validateInput();
            }
        });
    }

    private void validateInput() {
        String login = this.login.getText().toString();
        String password = this.password.getText().toString();
        String passwordRepeat = this.passwordRepeat.getText().toString();

        if (login.trim().isEmpty()) {
            showError("Login is empty!");
        } else if (password.trim().isEmpty()) {
            showError("Password is empty");
        } else if (!password.trim().equals(passwordRepeat.trim())) {
            showError("Passwords do not match!");
        } else {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("name", name.getText().toString().trim());
            resultIntent.putExtra("position", position.getText().toString().trim());
            resultIntent.putExtra("login", login.trim().toLowerCase());
            resultIntent.putExtra("password", password.trim().toLowerCase());
            setResult(RESULT_OK, resultIntent);
            finish();
        }
    }

    private void showError(String message) { //Мини окошко с сообщение
        new AlertDialog.Builder(this)
                .setTitle("Error") //Загаловок
                .setMessage(message) //Сообщение
                .setPositiveButton("Okay", null) //Кнопки
                .show();
    }
}