
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADM
 */
public class Login extends ArrayList<Account> {

    public Login() {
        this.add(new Account("admin", "123", "ADMIN"));
        this.add(new Account("user", "123", "USER"));
    }
    
    public void addAccount (Account account){
        for (Account acc : this) {
            if (acc.getUsername().equals(account.getUsername())){
                System.out.println("Username da ton tai!");
                return;
            }
        }
        this.add(account);
    }
    
    public Account checkAccount (String username, String password){
        for (Account acc : this) {
            if (acc.getUsername().equals(username) && acc.getPassword().equals(password)){
                return acc;
            }
        }
        return null;
    }
    
}
