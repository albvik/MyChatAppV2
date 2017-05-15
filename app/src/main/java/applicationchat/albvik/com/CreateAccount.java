package applicationchat.albvik.com;

import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.dd.processbutton.iml.ActionProcessButton;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import Util.ProgressGenerator;
import applicationchat.albvik.com.mychatappv2.R;

public class CreateAccount extends AppCompatActivity implements  ProgressGenerator.OnCompleteListener {

    private EditText emailAddress;
    private EditText password;
    private EditText username;
    private ProgressGenerator progressGenerator;
    private ActionProcessButton createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        emailAddress = (EditText) findViewById(R.id.userEmailId);
        password = (EditText) findViewById(R.id.usernamePasswordId);
        username = (EditText) findViewById(R.id.usernameAccountId);

        progressGenerator = new ProgressGenerator(this);

        createAccountButton = (ActionProcessButton) findViewById(R.id.usernameCreateAccountId);

        createAccountButton.setMode(ActionProcessButton.Mode.PROGRESS);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }
        private void createAccount(){
            final String uEmail = emailAddress.getText().toString();
            final String uName = username.getText().toString();
            final String pWord = password.getText().toString();


            if(uEmail.equals("") || uName.equals("") || pWord.equals("")){
                AlertDialog.Builder dialog = new AlertDialog.Builder(CreateAccount.this);
                dialog.setTitle("Empty Fields");
                dialog.setMessage("Please complete the form");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                            public void onClick(DialogInterface dialog, int wich){
                        dialog.dismiss();
                    }
                });
    dialog.show();

        }else{
                ParseUser user = new ParseUser();

                //set core properties
                user.setUsername(uName);
                user.setPassword(pWord);
                user.setEmail(uEmail);

                //set custom property
                user.put("city", "Spokane");
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if(e==null){
                            progressGenerator.start(createAccountButton);
                            createAccountButton.setEnabled(false);

                            emailAddress.setEnabled(false);
                            username.setEnabled(false);
                            password.setEnabled(false);


                            //log them in right away
                              logUserIn(uName, pWord);
                        }
                    }
                });
            }
    }

    private void logUserIn(String uName, String pWord) {
    if(!uName.equals("") || !pWord.equals("")){
        ParseUser.logInInBackground(uName, pWord, new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, ParseException e) {
                if(e==null){
                    Log.v("USER LOGGED IN IS:", parseUser.getUsername());
                }else{

                }
            }
        });
    }else{

    }
    }


    @Override
    public void onComplete() {
        startActivity(new Intent(CreateAccount.this, CreateAccount.class));
    }
}