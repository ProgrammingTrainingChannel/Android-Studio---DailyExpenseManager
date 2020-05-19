package nebiyou.dailyexpensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {
    EditText txtreason,txtamount,txtdate;
    Button btnsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        txtreason=(EditText) findViewById(R.id.txtreason);
        txtamount=(EditText) findViewById(R.id.txtamount);
        txtdate=(EditText) findViewById(R.id.txtdate);
        btnsearch=(Button) findViewById(R.id.btnsearch);
    }

    public void search(View Button){
        DBHelper dbHelper=new DBHelper(this);
        DailyModel dailyModel =dbHelper.Search(txtdate.getText().toString());

        txtreason.setText(dailyModel.getReasone());
        txtamount.setText(dailyModel.getAmount());
    }


}
