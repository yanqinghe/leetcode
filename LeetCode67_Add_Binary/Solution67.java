
public class Solution67 {
    public String addBinary(String a, String b) {
        int d = a.length() - b.length();
        if (d <= 0) {
            return help(a, b, -d);
        } else {
            return help(b, a, d);
        }
    }

    private String help(String s, String l, int d) {
        StringBuilder stringBuilder = new StringBuilder();
        int help = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = (int) (s.charAt(i) - '0' + l.charAt(i + d) - '0') + help;
            stringBuilder.append(digit % 2);
            help = digit / 2;
        }
        for (int i = d - 1; i >= 0; i--) {
            int digit = (int) (l.charAt(i) - '0') + help;
            stringBuilder.append(digit % 2);
            help = digit / 2;
        }
        if (help == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}

