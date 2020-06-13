/*
    Time Complexity: O(N*K), N is size of input, k is the length of string
    Space Complexity:  O(N)
    worked on leetcode : YES
*/

public class Anagram_using_prime_product {

    int primes[];
    public List<List<String>> groupAnagrams(String[] strs) {
        primes= new int[]{2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,67,71,73,79,83,89,97,101,103};
        HashMap<String, List<String> > map = new HashMap<>();
        if ( strs == null || strs.length == 0 ) return new ArrayList<>();
        for(String s : strs){
            long prime_prod = prime_product(s);
            if(!map.containsKey(prime_prod)){
                map.put(sorted,new ArrayList<>()); 
            }
            map.get(prime_prod).add(s);
        }
        return new ArrayList<>( map.values());
    }
    //  get the prime product of string
    // if the string is anagram of each other prime product will be same
    //  use that logic to put similar  prime product as key and value as anagram list

    private long prime_product(String s){
        long result = 1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            result *= primes[c - 'a'];
        }
        return result;
    }
    public static void main(String[] args) {
        
    }
    
}