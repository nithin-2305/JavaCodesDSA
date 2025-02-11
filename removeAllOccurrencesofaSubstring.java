//Problem: Remove All Occurrences of a Substring
//Appraoch 1 : brute force
// TC : indexOf ---> n,delete -->m where m is length of part,total tc (n/m)*n
//SC : n  
class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.toString().contains(part))
        {
            int idx=sb.indexOf(part);
            sb.delete(idx,idx+part.length());
        }
        return sb.toString();
    }
}
// Approach 2:Stack based approach
// TC: n*m where n=length of string ,m=length of part string
// SC: n
class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st = new Stack<>();
        int n=s.length();
        int pl=part.length();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            st.push(ch);
            if(st.size()>=pl && check(st,part,pl))
            {
                for(int j=0;j<pl;j++)st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    public static boolean check(Stack<Character> st,String part,int pn)
    {
        Stack<Character> st1 = new Stack<>();
        st1.addAll(st);
        for(int k=pn-1;k>=0;k--)
        {
            if(st1.isEmpty() || st1.peek()!=part.charAt(k))return false;
            st1.pop();
        }
        return true;

    }
}
