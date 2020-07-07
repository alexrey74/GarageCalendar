package fr.garagecalendar.activity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;

import fr.garagecalendar.R;
import fr.garagecalendar.manager.ProfileManager;
import fr.garagecalendar.model.Slot;
import fr.garagecalendar.model.User;
import fr.garagecalendar.utils.ActivityUtils;

public class LoginActivity extends AppCompatActivity {
    ArrayList<User> userList = new ArrayList<>();
    ArrayList<Slot> slotList = new ArrayList<>();

    Button btnLogin;
    EditText txtLogin;
    EditText txtPassword;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        btnLogin = findViewById(R.id.btnLogin);
        txtLogin = findViewById(R.id.etLogin);
        txtPassword = findViewById(R.id.etPassword);

        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 5; j++){
                slotList.add(new Slot(LocalDate.now(), 8.0, 4.0));
            }
            User user = new User("arey", "1234" + i, "Alexandre REY", slotList);
            userList.add(user);
        }


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = txtLogin.getText().toString();
                String password = txtPassword.getText().toString();

                for(User user : userList){

                    if(user.getLogin().equals(login) && user.getPassword().equals(password)){
                        ProfileManager.getInstance().setUser(user);
                        ActivityUtils.launchActivity(LoginActivity.this, MainActivity.class, ActivityUtils.TYPE_FADE);
                        break;

                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Login ou mot de passe incorrect ! ";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            }
        });
    }
}
