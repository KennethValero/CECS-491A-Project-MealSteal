package csulb.cecs323.app;
import csulb.cecs323.model.*;

import javax.naming.Name;
import javax.persistence.*;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    private EntityManager entityManager;
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public Main(EntityManager manager) {
        this.entityManager = manager;
    }
    public static void main(String[]args){
        LOGGER.fine("Creating EntityManagerFactory and EntityManager");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Main");
        EntityManager manager = factory.createEntityManager();
        Main main = new Main(manager);
        user_interface user = new user_interface();
        EntityTransaction tx = manager.getTransaction();
        //Scanners
        Scanner string_input = new Scanner(System.in);
        Scanner integer_input= new Scanner(System.in);
        //display menu
        System.out.println("Select menu: ");
        user.menu();
        Scanner in = new Scanner(System.in);
        boolean isDone = false;
        while(!isDone) {
            user.menu();
            System.out.print("your choice: ");
            int n = in.nextInt();
            if(n >= 0 && n <= 1){
                switch (n) {
                    case 1:
                        LOGGER.fine("Creating EntityManagerFactory and EntityManager");
                        tx.begin();
                        String AccountName = user.getName();
                        String AccountEmail = user.getEmail();
                        String Password = user.getPassword();
                        String MerOrCus = user.getMerOrCus();
                        Account account = new Account(AccountName,AccountEmail,Password,MerOrCus);
                        manager.persist(account);
                        manager.getTransaction();
                        tx.commit();
                        LOGGER.fine("Begin of Transaction");
                        break;
                    case 0:
                        isDone = true;
                        break;
                }// end Switch
            }// end if
            else{
                System.out.println("Invalid input");
            }
        }
        string_input.close();
        integer_input.close();
    }//end of Main
    public <E> void createEntity(List <E> entities) {
        for (E next : entities) {
            LOGGER.info("Persisting: " + next);
            // Use the CarClub entityManager instance variable to get our EntityManager.
            this.entityManager.persist(next);
        }

        // The auto generated ID (if present) is not passed in to the constructor since JPA will
        // generate a value.  So the previous for loop will not show a value for the ID.  But
        // now that the Entity has been persisted, JPA has generated the ID and filled that in.
        for (E next : entities) {
            LOGGER.info("Persisted object after flush (non-null id): " + next);
        }
    } // End of createEntity member method
    /**
     * Think of this as a simple map from a String to an instance of Publishers that has the
     * same name, as the string that you pass in.  To create a new Cars instance, you need to pass
     * in an instance of Publishers to satisfy the foreign key constraint, not just a string
     * representing the name of the style.
     * @param name       The name of the publisher style that you are looking for.
     * @return           The publisher instance corresponding to that Publishers name.
     */


    /**
     * Think of this as a simple map from a String to an instance of Authoring_Entities that has the
     * same name, as the string that you pass in.  To create a new Cars instance, you need to pass
     * in an instance of Authoring_Entities to satisfy the foreign key constraint, not just a string
     * representing the name of the style.
     * @param name       The name of the Authoring_Entities style that you are looking for.
     * @return           The publisher instance corresponding to that Authoring_Entities name.
     */
}