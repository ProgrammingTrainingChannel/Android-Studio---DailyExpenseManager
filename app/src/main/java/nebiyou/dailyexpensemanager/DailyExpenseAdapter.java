package nebiyou.dailyexpensemanager;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by it on 4/29/2009.
 */

public class DailyExpenseAdapter extends BaseAdapter {

    private Activity context_1;
    private List<DailyModel> dailyModels;

    public DailyExpenseAdapter(Activity context, List<DailyModel> dailyModelList) {
        context_1 = context;
        this.dailyModels = dailyModelList;
    }

    @Override
    public int getCount() {
        return dailyModels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView lbldate, lblamount, lblreason;

        if (convertView == null) {
            convertView = LayoutInflater.from(context_1).inflate(
                    R.layout.dialy_expense_list, null);

            lbldate = (TextView) convertView.findViewById(R.id.lbldate);
            lblamount = (TextView) convertView.findViewById(R.id.lblamount);
            lblreason = (TextView) convertView.findViewById(R.id.lblreason);

            lbldate.setText(" " + dailyModels.get(position).getDate());
            lblamount.setText(" " + dailyModels.get(position).getAmount());
            lblreason.setText(" " + dailyModels.get(position).getReasone());
        }
        else{
            lbldate = (TextView) convertView.findViewById(R.id.lbldate);
            lblamount = (TextView) convertView.findViewById(R.id.lblamount);
            lblreason = (TextView) convertView.findViewById(R.id.lblreason);

            lbldate.setText(" " + dailyModels.get(position).getDate());
            lblamount.setText(" " + dailyModels.get(position).getAmount());
            lblreason.setText(" " + dailyModels.get(position).getReasone());
        }

        return convertView;
    }
}
