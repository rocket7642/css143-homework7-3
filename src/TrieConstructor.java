import java.util.*;
import java.lang.*;

class TrieConstructor {
    private TrieNode root;

    public TrieConstructor(){
        root = new TrieNode(' '); 
    }

    public void add(String input){
        if (search(input) == true){
            return;    
        }

        TrieNode curr = root; //will immediately be moved to something else, just here to ease into for
        TrieNode post;
        TrieNode pre;
        for(char cha : input.toCharArray()){
            char ch = Character.toLowerCase(cha); 
            pre = curr;
            TrieNode child = curr.getChild(ch);
            if(!(child == null)){
                curr = child;
                child.parent = pre;
            }
            else{
                curr.children.add(new TrieNode(ch));
                curr = curr.getChild(ch);
                curr.parent = pre;
            }
        }
        curr.End = true;
    }

    public boolean search(String input){
        TrieNode curr = root;      
        for(char cha : input.toCharArray()){
            char ch = Character.toLowerCase(cha); 
            if(curr.getChild(ch) == null){
                return false;
            }
            else{
                curr = curr.getChild(ch);    
            }
        }      
        if(curr.End == true){       
            return true;
        }
        return false;
    }

    public List autocomplete(String input){     
        TrieNode last = root;
        for(int i = 0; i< input.length(); i++){
            last = last.getChild(input.charAt(i));      
            if (last == null){
                return new ArrayList();  
            }
        }

        return last.getWords();
    }
}
