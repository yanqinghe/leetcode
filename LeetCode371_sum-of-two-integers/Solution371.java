public class Solution371 {
    public static void main(String[] args) {
        Solution371 solution371 = new Solution371();
        System.out.println(solution371.getSum(1111,-9978));
    }
    public int getSum(int a, int b) {
        int ret =0;
        boolean c = false;
        for (int i = 0; i < 32; i++) {
            boolean a1= ((a>>i)&1)==1;
            boolean b1 =((b>>i)&1)==1;
            if(a1&&b1){
                if(c){
                    ret=ret|(1<<i);
                }
                c=true;
            }else if(a1||b1){
                if(c){
                    c=true;
                }else {
                    ret=ret|(1<<i);
                    c=false;
                }
            }else {
                if(c){
                    ret=ret|(1<<i);
                }
                c=false;
            }
        }
        return ret;
    }
}
