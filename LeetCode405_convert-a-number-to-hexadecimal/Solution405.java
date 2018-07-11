import org.omg.CORBA.INTERNAL;

public class Solution405 {
    public static void main(String[] args) {
        Solution405 solution405 = new Solution405();
//        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++) {
//            String hex1= solution405.toHex(i);
//            String hex2 = Integer.toHexString(i);
//            System.out.print(i+","+hex1+","+hex2+",");
//            System.out.println(hex1.equals(hex2));
//
//        }
        solution405.toHex(-1);
    }
    final  static char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num==0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num!=0){
            sb.append(map[num&15]);
            num=(num>>>4);
        }
        return sb.reverse().toString();
    }
}
