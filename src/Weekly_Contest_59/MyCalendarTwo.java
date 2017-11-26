package Weekly_Contest_59;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    List<DateWidth> dateWidths1 = new ArrayList<>();
    List<DateWidth> dateWidths2 = new ArrayList<>();
    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        for (DateWidth date: dateWidths2
                ) {
            if(date.isIn(start,end)){
                return false;
            }
        }
        for (DateWidth date: dateWidths1
             ) {
            if(date.isIn(start,end)){
                dateWidths2.add(date.congfu(start,end));
            }
        }
        dateWidths1.add(new DateWidth(start,end));
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
        public DateWidth congfu(int leftDate,int rightDate){
            if(leftDate>=this.right||rightDate<=this.left){
                return null;
            }else {
                return new DateWidth(Math.max(leftDate,this.left),Math.min(rightDate,this.right));
            }
        }
    }
}
