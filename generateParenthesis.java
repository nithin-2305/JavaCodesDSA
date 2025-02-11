//Approach 1(Simple Approach)
//TC : length of the generate parenthesis is 2*n. for every position-> two possibilities 2^(2*n) and isValid function iterates for twice the length .Total TC :T.C : O(2n* (2^(2n)) -> Removing constant -> O(n * (2^n))
//S.C : O(2*n) recursive stack space
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> res = generateParenthesis(n);
        System.out.println(res);
        sc.close();
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        solve("", n, res, 0);
        return res;
    }

    public static void solve(String current, int n, List<String> res, int currlen) {
        if (currlen == 2 * n) {
            if (isValid(current)) {
                res.add(current);
            }
            return;
        }
        current += "(";
        solve(current, n, res, currlen + 1);
        current = current.substring(0, current.length() - 1);
        current += ")";
        solve(current, n, res, currlen + 1);
    }

    public static boolean isValid(String s) {
        int cnt = 0;
        for (int x : s.toCharArray()) {
            if (x == '(') cnt++;
            else cnt--;
            if (cnt < 0) return false;// ())( 1-1-1+1==0 which is incorrect
        }
        return cnt == 0;
    }
}
// Approach 2 
//invalid parenthesis are not generated
//TC : 2^(2*n) SC : 2*n
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> res = generateParenthesis(n);
        System.out.println(res);
        sc.close();
    }
    private List<String> res = new ArrayList<>();
    public static List<String> generateParenthesis(int n) {
        solve("", n, 0, 0);
        return res;
    }

    public static void solve(String current, int n, int open,int close) {
        if (currlen == 2 * n) {
                res.add(current);
            }
            return;
        }
       if(open<n)
       {
          current += "(";
          solve(current, n, open+1, currlen + 1);
          current = current.substring(0, current.length() - 1);
       }
        if(open>close)
        {
          current += ")";
          solve(current, n, open, close + 1);
          current = current.substring(0, current.length() - 1);
        }
    } 
}
