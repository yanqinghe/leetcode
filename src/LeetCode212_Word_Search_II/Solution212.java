package LeetCode212_Word_Search_II;


import java.util.*;

/**
 * Created with Hehel
 * . . . . . . . . . . . ._oo0oo_
 * . . . . . . . . . . . o8888888o
 * . . . . . . . . . . . 88" . "88
 * . . . . . . . . . . . (| -_- |)
 * . . . . . . . . . . . 0\  =  /0
 * . . . . . . . . . . ___/`---'\___
 * . . . . . . . . ..' \\|     |// '.
 * . . . . . . . . / \\|||  :  |||// \
 * . . . . . . . ./ _||||| -:- |||||- \
 * . . . . . . . |   | \\\  -  /// |   |
 * . . . . . . . | \_|  ''\---/''  |_/ |
 * . . . . . . . \  .-\__  '-'  ___/-. /
 * . . . . . . . . .___'. .'  /--.--\  `. .'___
 * . . . . . . .."" '<  `.___\_<|>_/___.' >' "".
 * . . . . | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * . . . . \  \ `_.   \_ __\ /__ _/   .-` /  /
 * . .=====`-.____`.___ \_____/___.-`___.-'=====
 * `=---='
 * <p>
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * 佛祖保佑         永无BUG
 * Description:
 * User: Hehel
 * Date: 2017-12-12
 * Time: 16:53
 */
public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<int []>[] boardNode = new List[26];
        //获取board行列
        int m = board.length,n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int b = board[i][j]-'a';
                if(boardNode[b]==null){
                    boardNode[b]=new ArrayList<>();
                }
                boardNode[b].add(new int[]{i,j});
            }
        }
        Set<String> res= new HashSet<>();
        for (String word:words
             ) {
            if(boardNode[word.charAt(0)-'a']!=null){
                for (int[] child: boardNode[word.charAt(0)-'a']
                        ) {
                    if(search(word,0,board,child[0],child[1],new boolean[m][n])){
                        res.add(word);
                        break;
                    }
                }
            }
        }
        return new ArrayList<>(res);

    }
    boolean search(String word,int index,char[][] board,int i,int j, boolean visited[][]){
        //如果当前单元格已经完成
        if(index==word.length()) return true;
            //如果越界或者当前单元格已经访问过，返回False
        if(i==board.length||i<0) return false;
        if(j==board[0].length||j<0) return false;
        if(visited[i][j])  return false;
        if(word.charAt(index)==board[i][j]){
            //如果当前单元格符合要求
            visited[i][j]=true;
            //继续递归

            if(search(word,index+1,board,i+1,j,visited)||search(word,index+1,board,i-1,j,visited)
                    || search(word,index+1,board,i,j+1,visited)|| search(word,index+1,board,i,j-1,visited))
                return true;
            visited[i][j]=false;
        }
        return false;
    }

}
