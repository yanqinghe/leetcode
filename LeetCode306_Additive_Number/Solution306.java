public class Solution306 {
    public static void main(String[] args) {
        Solution306 solution306 = new Solution306();
        System.out.println(solution306.isAdditiveNumber("8917"));
    }
    public boolean isAdditiveNumber(String num) {
        int len  = num.length();
        for (int i = 1; i <= len/2; i++) {
            String start = num.substring(0,i);
            if(start.length()>1&&start.charAt(0)=='0') return isOK;
            for (int j = i+1; j < len; j++) {
                String pre = num.substring(i,j);
                if(pre .length()>1&& pre.charAt(0)=='0') break;
                String res = add(start,pre);
                 dfs(num,j,pre,res);
            }
        }
        return  isOK;
    }
    boolean isOK = false;
    void dfs(String num,int index,String preVal,String res){
        int endIndex = index+res.length();
        if(endIndex<=num.length()){
            if(num.substring(index,endIndex).equals(res)){
                if(endIndex==num.length()) isOK =true;
                dfs(num,endIndex,res,add(preVal,res));
            }

        }
    }

    String add(String i1,String i2){
        if(i1.length()>i2.length()) return add(i2,i1);
        i1 = new StringBuilder(i1).reverse().toString();
        i2 = new StringBuilder(i2).reverse().toString();
        StringBuffer stringBuffer = new StringBuffer();
        int is=0;
        int i =0;
        for(;i<i1.length();i++){
            char c = (char)(i1.charAt(i)-'0'+i2.charAt(i)+is);
            if(c>'9'){

                is=1;
            }else {
                stringBuffer.append(c);
                is=0;
            }
        }
        for(;i<i2.length();i++){
            char c = (char)(i2.charAt(i)+is);
            if(c>'9'){
                stringBuffer.append(c-10);
                is=1;
            }else {
                stringBuffer.append(c);
                is=0;
            }
        }
        if(is==1) stringBuffer.append('1');
        return stringBuffer.reverse().toString();
    }
}