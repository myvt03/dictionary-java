
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADM
 */
public class DictionaryIO {
    private String fileName;

    public DictionaryIO(String fileName) {
        this.fileName = fileName;
    }
    
    public void saveToFile(HashMap<String, String> data){
        try(BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8))) { // mo file de ghi (byte) => chuyen chu => ghi nhanh hon
            for (String key : data.keySet()) { // duyet tung tu
                bw.write(key + ":" + data.get(key));
                bw.newLine();
                bw.flush();
            }
        } catch (IOException ex) {
            System.out.println("Loi ghi file!");
        }         
    }
    
    public HashMap<String, String> loadFromFile(){
        HashMap<String, String> data = new HashMap<String, String>();
        File file = new File(fileName);
        
        if (!file.exists()){
            return data;
        }
        
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))){ // doc file => byte -> chu => doc nhanh
            String line;
            while ((line = br.readLine())!= null){ // doc tung dong cho den khi het file
                String [] parts = line.split(":", 2);
                if (parts.length == 2){
                    data.put(parts[0], parts[1].trim());
                }
            }
        } catch (IOException e){
            System.out.println("Loi doc file!");
        }
        return data;
    }
}
