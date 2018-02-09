package LeetCode211_Add_and_Search_Word_Data_structuredesign;

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
 * Time: 16:11
 */
public class WordDictionary {
    /** Initialize your data structure here. */
    Node  root;
    public WordDictionary() {
        this.root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = root;
        char[] words= word.toCharArray();
        for (char c :words
             ) {
            int i = c-'a';
            if(node.nextNode[i]==null){
                node.nextNode[i]=new Node();
            }
            node= node.nextNode[i];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Node node= root;
        return search(word,node);
    }
    boolean search(String word,Node node){
        for (int i = 0; i <word.length() ; i++) {
            if(word.charAt(i)=='.'){
                //如果出现点
                for (Node child: node.nextNode
                        ) {
                    if(child!=null){
                        if(search(word.substring(i+1,word.length()),child)) return true;
                    }
                }
                return false;
            }else {
                int c = word.charAt(i)-'a';
                if(node.nextNode[c]==null) return false;
                else node = node.nextNode[c];
            }
        }
        return node.isEnd;
    }

    class Node{
        Node [] nextNode  = new Node[26];
        boolean isEnd  = false;
    }
}
