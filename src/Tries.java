import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TrieNode root = new TrieNode();
        
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add")) 
                add(contact, root);
                   
            else if (op.equals("find"))
                System.out.println(find(contact, root));
        }
    }
    
    public static void add (String word, TrieNode root) {
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currNode.children[(int)word.charAt(i) - 97] == null) {
                TrieNode newNode = new TrieNode();
                currNode.addChild(word.charAt(i), newNode);
                currNode = newNode;
            }
            else 
               currNode = currNode.children[word.charAt(i) - 97];
            
            if(i == word.length() -1)
                currNode.setToEndWord();
            
            currNode.wordsWithPrefix = currNode.wordsWithPrefix + 1;
       }
    }
    
    public static int find (String word, TrieNode root) {
        int count = 0;
        TrieNode currNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (currNode.children[word.charAt(i) - 97] == null)
                return 0;
            else
                currNode = currNode.children[word.charAt(i) - 97];
        }
        
        return currNode.wordsWithPrefix;
    }
    public static class TrieNode {
        TrieNode[] children;
        String word;
        boolean endsWord;
        int wordsWithPrefix;
        TrieNode() {
            children = new TrieNode[26];
            //word = _word;
            endsWord = false;
            wordsWithPrefix = 0;
        }
        
        void addChild(char a, TrieNode other) {
            children[((int) a) - 97] = other;
        }
        void setToEndWord() {
            endsWord = true;
        }
    }
}
