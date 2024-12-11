package za.hp.cwengandudula;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contact implements Serializable {
    private String name, email;
    private String phoneNo;
    public Contact(String name, String email, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public String getEmail() {
        return email;
    }
    public static List<Contact> getContacts(){
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("John Doe", "johndoe@gmail.com","0831230000"));
        contacts.add(new Contact("Themba Nje", "thembanje@yahoo.com","0831230000"));
        contacts.add(new Contact("Anne Smith", "asmith@gmail.com","0831230000"));
        contacts.add(new Contact("Jane Doe", "janedh@gmail.com","0831230000"));
        return contacts;
    }
}
