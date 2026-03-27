
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADM
 */
public class DictionaryApp {
    private Dictionary d;
    private DictionaryIO io;
    private Login login;
    private Account currentUser;
    private Scanner sc;

    public DictionaryApp() {
        d = new Dictionary();
        io = new DictionaryIO("dict.txt");
        login = new Login();
        sc = new Scanner(System.in, StandardCharsets.UTF_8);
        d.setData(io.loadFromFile());
    }

    public void run() {
        int choice;
        do {
            showMenu();
            System.out.print("Chon: ");
            try{
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        login();
                        break;
                    case 2:
                        addWord();
                        System.out.println("------------------ Successfully ------------------");
                        break;
                    case 3:
                        lookupWord();
                        System.out.println("------------------ Successfully ------------------");
                        break;
                    case 0:
                        System.out.println("Exit!");
                        break;
                    default:
                        System.out.println("Khong hop le!");
                }
            } catch (NumberFormatException e){
                System.out.println("Loi: Vui long nhap tu 1 den 4!");
                choice = -1;
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.println("1. Login");
        System.out.println("2. Them tu");
        System.out.println("3. Tra tu");
        System.out.println("0. Exit");
    }

    private void login() {
        System.out.println("------------------ LOGIN ------------------");
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        
        currentUser = login.checkAccount(username, password);
        
        if (currentUser != null) {
            System.out.println("Chao mung " + currentUser.getUsername());
        } else {
            System.out.println("Sai tai khoan hoac mat khau!");
        }
    }

    private void addWord() {
        if (currentUser == null || !currentUser.getRole().equals("ADMIN")){
            System.out.println("Ban chua dang nhap hoac khong co quyen!");
            return;
        }
        System.out.println("------------------ ADD WORD ------------------");
        System.out.print("Nhap word: ");
        String word = sc.nextLine();
        System.out.print("Nhap mean: ");
        String mean = sc.nextLine();

        d.addWord(word, mean);
        io.saveToFile(d.getData());
    }

    private void lookupWord() {
        if (currentUser == null){
            System.out.println("Ban chua dang nhap!");
            return;
        }
        System.out.println("------------------LOOK UP WORD------------------");
        System.out.print("Nhap tu: ");
        String search = sc.nextLine();
        String result = d.lookupWord(search);
        if (result != null){
            System.out.println(search + ": " + result);
        }
        else {
            System.out.println("N/A");
        }
    }
    
    
    
}
