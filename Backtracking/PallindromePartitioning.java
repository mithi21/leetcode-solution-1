/*
    Given a string s, partition s such that every substring of the partition is a palindrome.

    Return all possible palindrome partitioning of s.

    Example:

    Input: "aab"
    Output:
    [
    ["aa","b"],
    ["a","a","b"]
    ]


*/

/*

    Time complexity : O(2^n *n)
    space complexity : O(2^n)
    worked on leetcde : yes
*/

public class PallindromePartitioning {
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        result=new ArrayList();
        if(s==null || s.length()==0){
            return result;
        }
        backtrack(s,new ArrayList(),0);
        return result;
    }
     private void backtrack(String s,List<String> temp,int start ){
        //base
        if(start==s.length()){
            result.add(new ArrayList(temp));
        }
        //logic
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                backtrack(s,temp,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
     private boolean isPalindrome(String s,int low,int high){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }   
}