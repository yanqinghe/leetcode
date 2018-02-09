public class Solution273 {
    public static void main(String[] args) {
        Solution273 solution273 = new Solution273();
        System.out.println(solution273.numberToWords(1000000));
    }
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        String [] v =  {"","Thousand", "Million", "Billion"};
        StringBuilder res = new StringBuilder();
        int i =0;
        while (num>0){
            int temp = num%1000;
            if(temp>0){
                res.insert(0,convertHundred(num%1000).append(v[i]));
            }
            num=num/1000;
            i++;
        }
        for (int j = 1; j < res.length()-1; j++) {
            //通过驼峰命名法的规则添加空格
            if(res.charAt(j)<'a'){
                res.insert(j,' ');
                j++;
            }
        }
        return res.toString();
    }
    StringBuilder convertHundred(int num){
        String [] base = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen"};
        String [] decadeBase = { "","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder stringBuilder = new StringBuilder();
        if(num>=100){
            //如果数字大于100，添加百位
            stringBuilder.append(base[num/100]).append("Hundred");
            num=num%100;
        }
        if(num<20){
            //如果数字小于20，直接返回基本数字
            stringBuilder.append(base[num]);
        }else {
            //首先得到十位
            stringBuilder.append(decadeBase[num/10]);
            stringBuilder.append(base[num%10]);
        }
        return stringBuilder;
    }
}
