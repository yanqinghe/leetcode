public class Solution504 {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean is =false;
        if(num<0) {
            is=true;
            num=-num;
        }
        while (num>0){
            int temp =num%7;
                sb.append(String.valueOf(temp));
            num/=7;
        }
        if(is) sb.append('-');
        return sb.reverse().toString();
    }
}
