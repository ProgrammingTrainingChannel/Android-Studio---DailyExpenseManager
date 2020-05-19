package nebiyou.dailyexpensemanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnlogin,btncalcel;
    EditText txtpassword,txtname;
    CheckBox chkremember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin=(Button) findViewById(R.id.btnlogin);
        btncalcel=(Button)findViewById(R.id.btncancel);
        chkremember=(CheckBox)findViewById(R.id.chkremember);

        SharedPreferences prefs = this.getSharedPreferences("LoginSetting",MODE_PRIVATE);
        String username =prefs.getString("username","");
        String password =prefs.getString("password","");

        txtpassword=(EditText)findViewById(R.id.txtpassword);
        txtname=(EditText)findViewById(R.id.txtname);

        txtname.setText(username);
        txtpassword.setText(password);
        btnlogin.setOnClickListener(this);

    }

    public void onClick (View v){
        if(txtpassword.getText().toString().equals("")){
            Toast.makeText(this,"plz feel the password and username",Toast.LENGTH_LONG).show();
        }
        else if(txtpassword.getText().toString().length()<=5){
            Toast.makeText(this,"Plz Change Your (Pass Code Number) To 6 Caracters.",Toast.LENGTH_LONG).show();
        }
        else{
            if(chkremember.isChecked()){
                SharedPreferences prefs= this.getSharedPreferences("LoginSetting",MODE_PRIVATE);
                SharedPreferences.Editor editor=prefs.edit();

                editor.putString("username",txtname.getText().toString());
                editor.putString("password",txtpassword.getText().toString());
                editor.apply();

                Toast.makeText(this,"Your Password Is Saved.",Toast.LENGTH_LONG ).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this,"setting not saved",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public void btnCancel(android.view.View Button){
        txtname.setText("");
        txtpassword.setText("");
    }

}
