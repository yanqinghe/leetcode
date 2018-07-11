import java.util.ArrayList;
import java.util.List;

public class Solution401 {
    public static void main(String[] args) {
        Solution401 solution401 = new Solution401();
        System.out.println(solution401.readBinaryWatch(0));
        for (int i = 0; i < 6; i++) {
            List<String> strings2 = new ArrayList<>();
            solution401.H(i,0,0,strings2);
            System.out.println(strings2);
        }
    }

    final static List<String[]> Htables=new ArrayList<String[]>(){
        {add(new String[]{
                "0:"
            });
            add(new String[]{
                    "1:","2:","4:","8:"
            });
            add(new String[]{
                    "3:", "5:", "9:", "6:", "10:"
            });
            add(new String[]{
                    "7:", "11:"
            });
        }
    };
    final static List<String[]> Mtables=new ArrayList<String[]>(){
        {add(new String[]{
                "00"
        });
            add(new String[]{
                    "01","02","04","08","16","32"
            });
            add(new String[]{
                    "03", "05", "09", "17", "33", "06", "10", "18", "34", "12", "20", "36", "24", "40", "48"
            });
            add(new String[]{
                    "07", "11", "19", "35", "13", "21", "37", "25", "41", "49", "14", "22", "38", "26", "42", "50", "28", "44", "52", "56"
            });
            add(new String[]{
                    "15", "23", "39", "27", "43", "51", "29", "45", "53", "57", "30", "46", "54", "58"
            });
            add(new String[]{
                    "31", "47", "55", "59"
            });
        }
    };
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if(i>=4||num-i>=6) continue;
            for (String s1 : Htables.get(i)) {
                for (String s2 : Mtables.get(num-i)) {
                    res.add(s1.concat(s2));

                }
            }
        }
        return res;
    }
    //先打表
    void H(int cnt,int index,int res,List<String> mList){
        if(cnt==0&&res<60){
            mList.add("\""+res+"\"");
        }
        else {
            if(index==6){
                return;
            }
            for (int i = index; i < 6; i++) {
                H(cnt-1,i+1,res|(1<<i),mList);
            }
        }
    }


  }
