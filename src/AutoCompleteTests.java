import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class AutoCompleteTests
{
    @Test
    public void AutoTest(){
        TrieConstructor test = new TrieConstructor();
        String[] inputs = {"hello","high","seattle","seatac","see","hollow","how","cow","chain","cheese"
            ,"spider","book","rain","castle","hero","dark","hat","cheif","pay","robot","war"};
        String[] testcases = {"h","se","sea","ho","xyz","c","ch","bo","robotic","s"};
        //no empty search case as the Trie is build off of a empty node, meaning it shows everything
        ArrayList<String>[] expected = new ArrayList[10];
        String[][] sets = {
                {"hello","hero","high","hollow","how","hat"},
                {"seattle","seatac","see"},
                {"seattle","seatac"},
                {"hollow","how"},
                {},
                {"cow","chain","cheese","cheif","castle"},
                {"chain","cheese","cheif"},
                {"book"},
                {},
                {"seattle","seatac","see","spider"}
            };

        for(int i = 0; i < inputs.length; i++){
            test.add(inputs[i]);
        }
        for(int i = 0; i < expected.length; i++){
            expected[i] = new ArrayList<String>();
        }
        
        for(int j = 0; j < expected.length; j++){
            for(int i = 0; i < sets[j].length; i++){
                expected[j].add(sets[j][i]);
            }
        }

        for (int i = 0; i < testcases.length; i++){
            List output = test.autocomplete(testcases[i]);
            display(output);
            System.out.println("-----");
            assertEquals(output,expected[i]);
        }   
    }

    public static void display(List input){
        for(int i = 0; i < input.size(); i++){
            System.out.println(input.get(i));
        }
    }
}
