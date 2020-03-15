import java.util.*;

public class TrieNode
{
    char data;     
    LinkedList<TrieNode> children; 
    TrieNode parent;
    boolean End;

    public TrieNode(char c){
        data = c;
        children = new LinkedList();
        End = false;        
    }  

    public TrieNode getChild(char c){
        if(children != null){
            for(TrieNode child : children){
                if(child.data == c){
                    return child;
                }
            }
        }
        return null;
    }

    public List getWords(){
        List list = new ArrayList();      
        if(End){
            list.add(toString());
        }

        if(children != null){
            for(int i=0; i< children.size(); i++){
                if(children.get(i) != null){
                    list.addAll(children.get(i).getWords());
                }
            }
        }       
        return list; 
    }

    @Override
    public String toString(){ //make tests easier to run as can compare strings
        if(parent == null){
            return "";
        }
        else{
            return parent.toString() + new String(new char[] {data});
        }
    }

}
