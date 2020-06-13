/*
    Share
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
*/


/*
1) Two HashMap approach

Time Complexity :  O(N)
Space Complexity : O(N) N is size of String or pattern 
Worked on leetcode : YES
difficulty : handling few corner cases
*/

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();
        
        
        String[] values = str.split(" ");
        char[] p_arr =  pattern.toCharArray();
//             edge case 
        
        if (values.length != p_arr.length ) return false;
        for(int i=0;i<p_arr.length;i++){
            
            if(!map1.containsKey(p_arr[i])){
                map1.put(p_arr[i], values[i]);
            }else{
                if(!map1.get(p_arr[i]).equals( values[i])){
                    System.out.print("___"+i);
                    return false;
                }
            }
            
            if(!map2.containsKey(values[i])){
                map2.put(values[i], p_arr[i]);
            }else{
                if(!map2.get(values[i]).equals( p_arr[i])){
                     System.out.print(i);
                    return false;
                }
            }
        }   
        return true;
    }

    /*
        Hash Set Method Faster

    */
    public boolean wordPattern_better(String pattern, String str) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashSet<String> set=new HashSet();
        
        String[] values = str.split(" ");
        char[] p_arr =  pattern.toCharArray();
//             edge case 
        
        if (values.length != p_arr.length ) return false;
        for(int i=0;i<p_arr.length;i++){
            if(!map1.containsKey(p_arr[i])){
                if(set.contains(values[i])){
                    return false;
                }else{
                    map1.put(p_arr[i], values[i]);
                    set.add(values[i]);
                }
            }else{
                if(!map1.get(p_arr[i]).equals( values[i])){       
                    return false;
                }
            }
        }   
        return true;
    }
}