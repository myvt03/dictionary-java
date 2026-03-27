
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADM
 */
public class Dictionary {
    private HashMap<String, String> data;

    public Dictionary() {
        data = new HashMap<String, String>();
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
    
    public void addWord (String word, String meaning){
        data.put(word.toLowerCase(), meaning);
    }
    
    public String lookupWord (String word){
        return data.get(word.toLowerCase());
    }
    
    
}
