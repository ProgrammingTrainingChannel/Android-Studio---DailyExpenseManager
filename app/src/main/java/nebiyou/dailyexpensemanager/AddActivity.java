package nebiyou.dailyexpensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText txtamount,txtreason,txtdate;
    Button btnsave,btnamount,btnreason,btndate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        txtamount=(EditText) findViewById(R.id.txtamount);
        txtdate=(EditText)findViewById(R.id.txtdate);
        txtreason=(EditText)findViewById(R.id.txtreason);
        btnamount=(Button)findViewById(R.id.btnamount);
        btnsave=(Button)findViewById(R.id.btnsave);
        btnreason=(Button)findViewById(R.id.btnreason);
        btndate=(Button)findViewById(R.id.btndate);

        txtdate.setText(getIntent().getStringExtra("date"));
    }

    public void btnamount(android.view.View Button){
        txtamount.setText("");

    }

    public void btnreason(android.view.View Button){
        txtreason.setText("");

    }

    public void btndate(android.view.View Button){
        txtdate.setText("");

    }

    public void save(android.view.View Button)
    {
        DailyModel dailymodel = new DailyModel();
        dailymodel.setDate(txtdate.getText().toString());
        dailymodel.setReasone(txtreason.getText().toString());
        dailymodel.setAmount(txtamount.getText().toString());

        DBHelper dbHelper= new DBHelper(this);
        dbHelper.AddNewDiary(dailymodel);

        Toast.makeText(this, "it is saved", Toast.LENGTH_SHORT).show();


    }
}
