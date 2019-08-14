import java.util.HashMap;
import java.util.Scanner;

public class steadyGene {
 
    static int steadyGene(String gene) {
        HashMap<Character, Integer> map = getCharCount(gene);
        int supCount = gene.length() / 4;
        StringBuilder newstr = new StringBuilder(); 
         for(char c: map.keySet()) {
             if (map.get(c) > supCount) {
                 for (int i = 0; i < map.get(c)-supCount; i++)
                     newstr.append(c);
             }
         }
         if(newstr.length() == 0)
             return 0;
         return minWindow(gene, newstr.toString());
    }
  
    /**
     * 
     * @param S
     * @param T
     * @return Minimum length of substring in S where all characters of T occur
     */
    private static int minWindow(String S, String T) {
        HashMap<Character, Integer> table = getCharCount(T);
        int counter = table.size();
        int begin = 0, end = 0;
        int minlength = S.length();
        while (end < S.length()) {
            char endchar = S.charAt(end);
            if(table.get(endchar) != null) {
                table.put(endchar, table.get(endchar) - 1);
                if(table.get(endchar) == 0)
                    counter--;
            }
            
            while (counter == 0) {
                minlength = Math.min(minlength, end - begin +1);
                char startchar = S.charAt(begin);
                
                if(table.get(startchar) != null) {
                    table.put(startchar, table.get(startchar) + 1);
                    if (table.get(startchar) > 0)
                       counter++;
                }
                
                begin++;
            }
            end++;
        }
        
        return minlength;
    }
    
    
    
    static HashMap<Character, Integer> getCharCount(String s) {
        HashMap<Character, Integer> table = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (table.get(c) == null)
                table.put(c, 1);
            else
                table.put(c, table.get(c) + 1);
        }
        return table;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String gene = in.next();
        int result = steadyGene(gene);
        System.out.println(result);
        in.close();
    }
}
