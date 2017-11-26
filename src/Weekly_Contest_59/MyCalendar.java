package Weekly_Contest_59;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar {

    List<DateWidth> dateWidths = new ArrayList<>();
    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        for (DateWidth date: dateWidths
             ) {
            if(date.isIn(start,end)){
                return false;
            }
        }
        dateWidths.add(new DateWidth(start,end));
        return true;
    }
    class DateWidth{
        int left;
        int right;
        public DateWidth(int left, int right) {
            this.left = left;
            this.right = right;
        }
        public boolean isIn(int leftDate,int rightDate){
            if(leftDate>=this.right||rightDate<=this.left){
                return false;
            }else return true;
        }
    }
}
