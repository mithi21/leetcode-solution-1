//https://leetcode.com/problems/replace-words/

/*

    In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

 

Example 1:

    Input: dict = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
    Output: "the cat was rat by the bat"
    

Constraints:

    The input will only have lower-case letters.
    1 <= dict.length <= 1000
    1 <= dict[i].length <= 100
    1 <= sentence words number <= 1000
    1 <= sentence words length <= 1000

*/


/*

    Time complexity : O(M*N) M is the length of dictionary and N is the length of the sentence ( no of words in senstence)

    Space complexity : O(1)
    worked in leetcode : YES

*/

public class Word_Replace {
    TrieNode root;
    class TrieNode{
        String word;
        TrieNode [] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void insert(String word){
            TrieNode curr = root;
            for(int i = 0; i< word.length();i++){
                char c  = word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] =  new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.word = word;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for( String w :  dict){
            insert(w);
        }
        
        StringBuilder sb = new StringBuilder();
        String [] words = sentence.split("\\s+");
        for(int i=0;i < words.length;i++){
            String word = words[i];
//              search  the word in trie
            TrieNode curr = root;
            if(i > 0 ) sb.append(" ");
            for(int j =0; j< word.length();j++){
                char ch = word.charAt(j);
                if( curr.children[ch - 'a'] == null || curr.word != null) break;
                curr = curr.children[ch - 'a'];
            }
            String replace;
            if( curr.word == null){
                replace = word;
            }else{
                replace = curr.word;
            }
            sb.append(replace);
        }
        
        return sb.toString();
    }
}

/*

    class Solution {
    TrieNode root;
    class TrieNode{
        boolean isEnd;
        TrieNode [] children;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    public void insert(String word){
            TrieNode curr = root;
            for(int i = 0; i< word.length();i++){
                char c  = word.charAt(i);
                if(curr.children[c - 'a'] == null){
                    curr.children[c - 'a'] =  new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
    }
    
    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        for( String w :  dict){
            insert(w);
        }
        
        StringBuilder sb = new StringBuilder();
        String [] words = sentence.split("\\s+");
        for(int i=0;i < words.length;i++){
            String word = words[i];
//              search  the word in trie
            TrieNode curr = root;
            if(i > 0 ) sb.append(" ");
            StringBuilder replacementsb =new StringBuilder();
            for(int j =0; j< word.length();j++){
                
                char ch = word.charAt(j);
                if( curr.children[ch - 'a'] == null || curr.isEnd ) break;
                replacementsb.append(ch);
                curr = curr.children[ch - 'a'];
            }
            String replace;
            if( !curr.isEnd ){
                replace = word;
                
            }else{
                replace = replacementsb.toString();
            }
            sb.append(replace);
        }
        
        return sb.toString();
    }
}

*/