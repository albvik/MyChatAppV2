package applicationchat.albvik.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import applicationchat.albvik.com.mychatappv2.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginButton;
    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAccountButton = (Button) findViewById(R.id.createButtonId);
        loginButton = (Button) findViewById(R.id.loginButton);

        createAccountButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);

       /* ParseUser user = new ParseUser();
        user.setUsername("hellouser");
        user.setPassword("hello");
        user.setEmail("email@exemple.com");

        user.put("phone", "24-22-05");
        user.put("food", "Chicken");

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    //all good
                    Toast.makeText(getApplicationContext(), "Yeah it's all ok!",Toast.LENGTH_LONG).show();
                }else{
                    //bad stuff
                }
            }
        });
    }
*/


            }

    @Override
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.createButtonId:
                //do sum
                startActivity(new Intent(MainActivity.this, CreateAccount.class));

        }
    }}
