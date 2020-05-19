package nebiyou.dailyexpensemanager;

/**
 * Created by it on 4/29/2009.
 */

public class DailyModel {
    private String date;
    private String reasone;
    private String amount;

    public String getDate() {
        return date;
    }

    public String getReasone() {
        return reasone;
    }

    public String getAmount() {return amount;}


    public void setDate(String dailyContent) {date = dailyContent;}

    public void setReasone(String dailyreasone) {
        reasone = dailyreasone;
    }

    public void setAmount(String dailyamount) { amount = dailyamount; }
}