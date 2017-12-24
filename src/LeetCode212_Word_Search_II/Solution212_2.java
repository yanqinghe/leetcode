package LeetCode212_Word_Search_II;

import java.util.ArrayList;
import java.util.List;

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
 * Time: 18:32
 */
public class Solution212_2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrieNode(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res,new StringBuilder());
            }
        }
        return res;
    }
    void dfs(char[][] board,int i,int j,TrieNode trieNode,List<String> res,StringBuilder stringBuilder){
        char c = board[i][j];
        int ci = c-'a';
        //如果当前board已被使用或者不符合trie树的结构
        if(c=='#'||trieNode.children[ci]==null) return;
        trieNode  = trieNode.children[ci];
        stringBuilder.append(c);
        if(trieNode.isEnd){
            res.add(stringBuilder.toString());
            trieNode.isEnd =false;
        }
        board[i][j]='#';
        if(i>0) dfs(board,i-1,j,trieNode,res,stringBuilder);
        if(j>0) dfs(board,i,j-1,trieNode,res,stringBuilder);
        if(j+1<board[0].length) dfs(board,i,j+1,trieNode,res,stringBuilder);
        if(i+1<board.length) dfs(board,i+1,j,trieNode,res,stringBuilder);
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        board[i][j]=c;
    }
    TrieNode buildTrieNode(String[] words){
        TrieNode root = new TrieNode();
        TrieNode node ;
        for (String word:words
                ) {
            node=root;
            for (int i = 0; i < word.length(); i++) {
                int c= word.charAt(i)-'a';
                if(node.children[c]==null) node.children[c]= new TrieNode();
                node = node.children[c];
            }
            node.isEnd=true;
        }
        return root;
    }
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}

