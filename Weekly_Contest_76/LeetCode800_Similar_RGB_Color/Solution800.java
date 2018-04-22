public class Solution800 {

    public static void main(String[] args) {
Solution800 solution800 = new Solution800();
        System.out.println(solution800.similarRGB("#a0c63f"));
    }

    public int toInt(String s) {
        return toInt(s.charAt(0)) * 16 + toInt(s.charAt(1));
    }

    public int toInt(char c) {
        if (c > '9') return c - 'a'+10;
        else return c - '0';

    }

    public String similarRGB(String color) {
        return "#"+get( color.substring(1,3))+get( color.substring(3,5))+get(color.substring(5,7));

    }
    public String get(String string){
        if(string.charAt(0)==string.charAt(1)) return string;
        int in = toInt(string);
        char c1= (char)( string.charAt(0)+1);
        char c2= (char)( string.charAt(0)-1);
        char c= string.charAt(0);
        if(c2<'0') c2='0';
        if(c2<'a'&&c2>'9') c2='9';
        if(c1>'f') c1='f';
        if(c1>'9'&&c1<'a') c1='a';
        String s1 = c1+""+c1;
        String s2 =c2+""+c2;
        String s = c+""+c;
        int i1 = Math.abs(in-toInt(s1));
        int i2 = Math.abs(in-toInt(s2));
        int i = Math.abs(in-toInt(s));
        if(i1<i2){
            if(i1<i) return s1;
            return s;
        }else {
            if(i2<i) return s2;
            return s;
        }
    }
}
