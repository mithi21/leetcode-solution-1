/*
 N is the size of input array
Time Complexity : O(N)
    Space Complexity : O(1)
    Is worked on Leetcode : YES
*/

/*

    // time complexity : O(N)
    // space complexity :O(N)
    // is worked on leetcode : YES
    Two HashMap Solution

    class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length ()) return false;
        HashMap<Character, Character> smap =  new HashMap<>();
        HashMap<Character, Character> tmap =  new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(smap.containsKey(sChar)){
                if(smap.get(sChar) !=  tChar){
                    return false;
                }
            }else{
                smap.put(sChar,tChar);
            }
            
             if(tmap.containsKey(tChar)){
                if(tmap.get(tChar) !=  sChar){
                    return false;
                }
            }else{
                tmap.put(tChar,sChar);
            }
            
        }
        
        
        return true;
    }
}
*/
class IsoMorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length ()) return false;
        char[] smap = new char[100];
        char[] tmap = new char[100];
        
        for(int i=0;i<s.length();i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
//             if hash of charchter char - ' ' will return index position for charachter 
            
            if (smap[sChar - ' '] != 0){
                if(smap[sChar - ' '] != tChar)return false;
            }else{
                smap[sChar - ' ']  = tChar;
            }
            
            if (tmap[tChar - ' '] != 0){
                if(tmap[tChar - ' '] != sChar)return false;
            }else{
                tmap[tChar - ' ']  = sChar;
            }
            
        }
        
        return true;
    }
}