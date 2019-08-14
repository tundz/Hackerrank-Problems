import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DropboxQuestion{
    
    public static void main (String[] args) {
        System.out.println(wordpattern("acma", "abacadab"));
    }

    static int wordpattern(String pattern, String input) {
        if (pattern == "" || input == "" || input.length() < pattern.length())
            return 0;
      
        Queue<Node> queue = new LinkedList<Node>();
        Node start = new Node ("", "", new HashMap<Character, String>());
        queue.add(start);
        
        while(!queue.isEmpty()) {
            Node top = queue.poll();
            
            //Check for the final state
            if(top.pattern.equals(pattern) && top.input.equals(input))
                return 1;
            if(top.pattern.length() >= pattern.length()) continue;
            char addedPat = pattern.charAt(top.pattern.length());
            
            for (int i = top.input.length(); i < input.length(); i++) {
                
                String addedStr = input.substring(top.input.length(), i+1);
                /**
                 *  Check that the new state is going to be a valid state
                 */
                if ((top.map.get(addedPat) == null || top.map.get(addedPat).equals(addedStr)) && isSingleMap(addedPat, addedStr, top.map)) {
                    Node  newNode = new Node (top.pattern.concat(String.valueOf(addedPat)), top.input.concat(addedStr), top.map);
                    newNode.map.put(addedPat, addedStr);
                    queue.add(newNode);
                }
            }
            
        }
      
      return 0;
  }

//Checks that no two diff letters are mapped to the same word 
static boolean isSingleMap (char pattern, String word, HashMap<Character, String>map) {
  for (char c : map.keySet()) {
      if(c != pattern) {
          if (map.get(c).equals(word))
             return false;
      }
  }
  
  return true;
}

/**
 *   The node class represents a state where pattern is a prefix of the original pattern
 *   input is also a prefix of org input
 */
static class Node {
  String pattern;
  String input;
  HashMap<Character, String> map;
  
  Node (String pat, String inp, HashMap<Character, String> _map) {
      pattern = pat;
      input = inp;
      map = new HashMap<Character, String>(_map);
      
  }
}
 
}
