package nebiyou.dailyexpensemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import static nebiyou.dailyexpensemanager.R.id.txtamount;
import static nebiyou.dailyexpensemanager.R.id.txtreason;

public class ShowAllActivity extends AppCompatActivity {
    EditText txtreason, txtamount;
    Button btnshowall;
    ListView lstExpense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all);

        btnshowall=(Button) findViewById(R.id.btnshowall);
        lstExpense=(ListView) findViewById(R.id.lstExpense);
    }

    public void btnshowall(android.view.View Button){
        DBHelper dbHelper=new DBHelper(this);
        List<DailyModel> dailyModels =dbHelper.ShowAll();

        DailyExpenseAdapter adapter = new DailyExpenseAdapter(this, dailyModels);
        lstExpense.setAdapter(adapter);

        Toast.makeText(this, "Her Are Your All Daily Expensess", Toast.LENGTH_SHORT).show();
    }

}
