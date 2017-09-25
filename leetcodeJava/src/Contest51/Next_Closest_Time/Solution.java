package Contest51.Next_Closest_Time;

public class Solution {
    public String nextClosestTime(String time) {
        char[] temp = time.toCharArray();
        int[] temp2 =new int[temp.length-1];
        int minH=0;

        int hh=0;
        int mm=0;
        int h = 0;
        int m =0;
        int i=0;
        for(int j =0;j<temp.length;j++){
            if(temp[j]!=':'){
                temp2[i]=temp[j];
            }
        }
        for(;i<temp.length&&temp[i]!=':';i++){
            h=h*10+(temp[i]-'0');
        }
        for(int j=i;j<temp.length;j++){
            m=m*10+temp[j];
        }

        for (int j = 0; j < temp.length; j++) {
            int hres=0;
            int mres =0;
            if (temp[j] == ':') {
                continue;
            }
            hres = (temp[j]-'0')*10;
            mres =(temp[j]-'0')*10;
            for(int k=0;k<temp.length;k++){
                if(temp[k]==':'){
                    continue;
                }
                hres+=temp[k]-'0';
                mres+=temp[k]-'0'
                if(hres<h && (hres-h+24)<=minH){
                    minH = hres-h-24;
                    hh =hres;
                }
            }
        }

    }
    private help(int result ,int min,int cu,int[] temp,int level){
        if(level==3){
            if(result<min){
                if(min>(result-cu+24*60)){
                    min =result-cu+24*60;
                }
            }
            for(int i=0;i<temp.length;i++){
                result =result*
            }
        }
    }

}
