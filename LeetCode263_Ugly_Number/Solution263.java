public class Solution263 {
    public boolean isUgly(int num) {
        while (num>0){
            if(num%2==0) num=num/2;
            else if(num%3==0) num = num/3;
            else if(num%5==0) num = num/5;
            else return false;
        }
        return num==1;
    }
}
