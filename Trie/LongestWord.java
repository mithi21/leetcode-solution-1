/*
    https://leetcode.com/problems/longest-word-in-dictionary/
    Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
    Example 1:
        Input: 
            words = ["w","wo","wor","worl", "world"]
        Output: "world"
        Explanation: 
            The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
    Example 2:
        Input: 
    
            words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
        Output: "apple"
        Explanation: 
        Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
        Note:

    All the strings in the input will only contain lowercase letters.
    The length of words will be in the range [1, 1000].
    The length of words[i] will be in the range [1, 30].

*/

public class LongestWord {
    

    Trie root;
    class Trie{
        String word;
        Trie [] children;

        public Trie(){
            children = new Trie[26];
        }
    
    }

    //Trie insert method
    private void add_word(String word){
        Trie cur = root;
        for( int i =0; i < word.length() ; i++){
            char c = word.charAt(i);
            
            if(cur.children[c - 'a'] == null){
                cur.children [c - 'a'] = new Trie();
            }
            cur = cur.children[c -  'a'];
        }
        
        cur.word = word;
    }
    public String longestWord(String[] words) {
        root = new Trie();
        
       //add words in Trie for processing
        for(String word :  words){
            add_word(word);
        }
        
        // add root in queue 
        Queue<Trie> q = new LinkedList();
        q.add(root);
        Trie node = null;
        // while queue is not empty popped out trie node from queue
        // and if any children of popped out node is not null and it is word add to the queue
        // when queue become empty the last word is the lonest lexographically smallest word
        // for getting longest lexographically smallest word we are processing the children in //reverse order
        while(!q.isEmpty()){
            
            node  =  q.poll();
            Trie [] children = node.children;
            for(int i=25; i >=0; i--){
                if( children[i] != null && children[i].word != null){
                    q.add(children[i]);
                }
            }
        }
        
        return node.word;
    }
}