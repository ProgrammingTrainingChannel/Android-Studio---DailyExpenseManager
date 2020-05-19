package nebiyou.dailyexpensemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {
    Button btnadd,btnsearch,btnSearchAll;

    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker)findViewById(R.id.datePicker);
    }
    public void  btnadd(android.view.View button){
        Intent intent = new Intent(this, AddActivity.class);
        String selectedDate = String.valueOf (datePicker.getDayOfMonth() +'-' + datePicker.getMonth() +'-' + datePicker.getYear());

        intent.putExtra("date",selectedDate);
        startActivity(intent);

    }
    public void  btnsearch(android.view.View button){
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);

    }
    public void  btnSearchAll(android.view.View button){
        Intent intent = new Intent(this,ShowAllActivity.class);
        startActivity(intent);
    }

    public void onClick(View button){
        Intent intent= new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

}
