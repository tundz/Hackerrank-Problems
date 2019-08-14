import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class HighestValuePalindrome {
    
    
       public static void main (String[] args) throws FileNotFoundException {
           int n = 5;
           int k = 0;
           for (int i = 0; i< 5; i++) {
               k++;
               
               for (int j = 0; j < 2*n +1;j++) {
                   if (j >= n -k && j <= n+k && j!= n)
                       System.out.print("#");
                   else
                       System.out.print(" ");
               }
               System.out.print("\n");
               
           }
       }
       static String richieRich (String s, int n, long k) {
        if (n == 1 && k == 0)
            return s;
        if (n == 1 && k > 0)
            return String.valueOf(9);
        String[] Te = new String[n];
        int[] T = new int[n];
        for(int i = 0; i < n; i++) {
            T[i] = Character.getNumericValue(s.charAt(i));
        }
        int i;
        int j;
        //if even
        if (n % 2 == 0) {
            i = (n/2) - 1;
            j = n/2;
        }
        else {
            i = (n/2) - 1;
            j = (n/2) + 1;
        }
        
        boolean[][] altered = new boolean[n][n];
        for(int p = 0; p < n; p++) {
            for(int q = 0; q < n; q++) {
                altered[p][q] = false;
            }
        }
        
        while (i >= 0 && j < n) {
            if (T[i] != T[j]) {
                if (k <= 0)
                    return String.valueOf(-1);
                int max = Math.max(T[i], T[j]);
                T[i] = max;
                T[j] = max;
                altered[i][j] = true;
                k--;
            }
            i = i -1;
            j = j + 1;
        }
        i = i + 1;
        j = j - 1;
        while (k > 0 && i < j) {
            
            if(T[i] != 9 || T[j]!= 9) {
                
                 if(altered[i][j]) {
                    T[i] = 9;
                    T[j] = 9;
                    k--;
                 }
                 else if (!altered[i][j]){
                    if (k >= 2) {
                       T[i] = 9;
                       T[j] = 9;
                       k-=2;
                    }
                }
                 
            }
            i = i + 1;
            j = j - 1;
            
        }
        
        if(n % 2 != 0 && k > 0)
            T[n/2] = 9;
        StringBuilder result = new StringBuilder();
        for (int p = 0; p < n; p++) {
            result.append(T[p]);
        }
         return result.toString();   
       }
}
