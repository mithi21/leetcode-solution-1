/*
    Time Complexity: N K Log(K), N is size of input, k is the length of string
    Space Complexity:  O(N)
    worked on leetcode : YES
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    // ["eat", "tea", "tan", "ate", "nat", "bat"],
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String> > map = new HashMap<>();
        if ( strs == null || strs.length == 0 ) return new ArrayList<>();
        for(String s : strs){
            // convert to char array then sort and then converted back to string
            char [] charArr =  s.toCharArray();
            Arrays.sort(charArr);
            String sorted = String.valueOf(charArr);
            // check if sorted string is not in map or not
            // if sorted string is not in map add otherwise add value in list
            if(!map.containsKey(sorted)){
                map.put(sorted,new ArrayList<>()); 
            }
            map.get(sorted).add(s);
        }
        return new ArrayList<>( map.values());
    }
    public static void main(String[] args) {
        
    }
}