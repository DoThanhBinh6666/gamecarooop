/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import javax.swing.JFrame;
import model.User;
import view.Register;
import view.Home;
import view.Login;
import view.BoardClient;
import view.BoardAI;
import view.Graft;
import view.Ratings;
/**
 *
 * @author admin
 */
public class Client {
    public enum View{
        Login,
        Home,
        Ratings,
        Register,
        Graft,
        BoardAI,
        BoardClient
    }
    //giao dien
    public static User user;
    public static Login login;
    public static Home home;
    public static Ratings ratings;
    public static Register register;
    public static Graft graft;
    public static BoardAI boardAI;
    public static BoardClient boardClient;
    
    public Client() {
    }
    
    public void initView(){
        
        login = new Login();
        login.setVisible(true);
    }
    public static JFrame getVisibleJFrame(){
        if(ratings!=null && ratings.isVisible())
            return ratings;
        if(graft != null && graft.isVisible()){
            return graft;
        }
        if(boardAI!=null&&boardAI.isVisible()){
            return boardAI;
        }
        if(register != null && register.isVisible()){
            return register;
        }
        return home;
    }
    public static void openView(View viewName){
        if(viewName != null){
            switch(viewName){
                case Login:
                    login = new Login();
                    login.setVisible(true);
                    break;
                case Home:
                    home = new Home();
                    home.setVisible(true);
                    break;                    
                case Register:
                    register = new Register();
                    register.setVisible(true);
                    break;
                case Ratings:
                    ratings = new Ratings();
                    ratings.setVisible(true);
                    break;
                case Graft:
                    graft = new Graft();
                    graft.setVisible(true);
                case BoardAI:
                    boardAI = new BoardAI();
                    boardAI.setVisible(true);
                case BoardClient:
                    boardClient = new BoardClient();
                    boardClient.setVisible(true);
            }
        }        
    }
    public static void closeView(View viewName){
        if(viewName != null){
            switch(viewName){
                case Login:
                    login.dispose();
                    break;
                case Home:
                    home.dispose();
                    break;                    
                case Register:
                    register.dispose();
                    break;
                case Ratings:
                    ratings.dispose();
                    break;
                case Graft:
                    graft.dispose();
                case BoardAI:
                    boardAI.dispose();
                case BoardClient:
                    boardClient.dispose();
            }
        }        
    }
    public static void closeAllview(){
        if(login != null){ 
            login.dispose(); 
        }
        if(home != null){
            home.dispose();
        }
        if(graft != null){
            graft.dispose();
        }
        if(register != null){
            register.dispose();
        }
        if(ratings != null){
            ratings.dispose();
        }
        if(boardAI != null){
            boardAI.dispose();
        }
        if(boardClient != null){
            boardClient.dispose();
        }
    }
    

    public static void main(String[] args) {
        new Client().initView();
    }
        
    }
