package csulb.cecs323.app;
import java.util.*;
public class user_interface {
    //scanner for input
    Scanner stringInput = new Scanner(System.in);
    Scanner integerInput = new Scanner(System.in);
    /**
     * display the menu options
     */
    public void menu(){
        System.out.println("1. Add Account");
        System.out.println("0. Exit");
    }

    /**
     * prompt user to input publisher name
     * @return name;
     */
    public String getPublisherName(){
        System.out.print("Please enter the name of Publisher: ");
        String name = stringInput.nextLine();
        return name;
    }
    /**
     * prompt user to input phone number
     * @return phone;
     */
    public String getPhoneNumber(){
        System.out.print("Please Enter the phone number: ");
        String phone = stringInput.nextLine();
        return phone;
    }
    /**
     * prompt user to input email
     * @return email;
     */
    public String getEmail(){
        System.out.print("please enter the email: ");
        String email = stringInput.nextLine();
        return email;
    }
    /**
     * prompt user to input name
     * @return name;
     */
    public String getName(){
        System.out.print("Please enter the Username: ");
        String name = stringInput.nextLine();
        return name;
    }
    /**
     * prompt user to input head writer
     * @return name;
     */
    public String getPassword(){
        System.out.print("Password: ");
        String name = stringInput.nextLine();
        return name;
    }
    /**
     * prompt user to input year
     * @return year;
     */

    public String getMerOrCus(){
        System.out.print("Enter Merchant or Customer Status: ");
        String name = stringInput.nextLine();
        return name;
    }
    public int getYear(){
        int year = integerInput.nextInt();
        return year;
    }
    /*

     */
}