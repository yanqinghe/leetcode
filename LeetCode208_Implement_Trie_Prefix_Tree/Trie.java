
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    Node rootNode;
    /** Initialize your data structure here. */
    public Trie() {
        this.rootNode = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = rootNode;
        for (int i = 0; i < word.length(); i++) {
            int index =  word.charAt(i)-'a';
            if(node.nextNodes[index]==null) node.nextNodes[index]=new Node();
            node = node.nextNodes[index];
        }
        node.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = rootNode;
        for (int j = 0; j < word.length(); j++) {
            int index =  word.charAt(j)-'a';
            if(node.nextNodes[index]==null) return false;
            node = node.nextNodes[index];
        }
        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = rootNode;
        for (int j = 0; j < prefix.length(); j++) {
            int index =  prefix.charAt(j)-'a';
            if(node.nextNodes[index]==null) return false;
            node = node.nextNodes[index];
        }
        return true;
    }
    class Node{
        boolean isEnd = false;
       Node[] nextNodes = new Node[26];

    }
}
