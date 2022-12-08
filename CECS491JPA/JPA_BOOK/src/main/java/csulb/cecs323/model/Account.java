package csulb.cecs323.model;

import javax.persistence.*;


@Entity

public class Account {
    @Id
    @Column(nullable = false, length = 20)
    private String userName;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 100)
    private String emailAddress;

    @Column(nullable = false, length = 8)
    private String merchantOrCustomer;

    //Constructors
    public Account(String userName, String password,String emailAddress, String merchantOrCustomer) {
        this.userName = userName;
        this.password = password;
        this.emailAddress = emailAddress;
        this.merchantOrCustomer = merchantOrCustomer;
    }

    public Account() {

    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getmerchantOrCustomer() {
        return merchantOrCustomer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "UserName='" + userName + '\'' +
                ", Password='" +  password + '\'' +
                ", Email Address=" + emailAddress +
                ", merchant or customer =" + merchantOrCustomer +
                '}';
    }
}
