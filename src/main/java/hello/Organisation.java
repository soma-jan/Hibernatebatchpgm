package hello;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Organisation {
    @Id
    @TableGenerator(name = "Organisation_seq")
    // As we are doing batch insert, using TableGenerator,
    // unique key is determined
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "Organisation_SEQ")
    private Long Id;
    private Long customerId;
    private  String firstName;
    private  String LastName;
    private  String Company;
    private  String city;
    private  String phone1;
    private  String phone2;
    private  String email;
    private LocalDate Date;
    private  String website;

    public Organisation() {
    }

    public Organisation(Long id, Long customerId, String firstName, String lastName, String company, String city, String phone1, String phone2, String email, LocalDate date, String website) {
        Id = id;
        this.customerId = customerId;
        this.firstName = firstName;
        LastName = lastName;
        Company = company;
        this.city = city;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        Date = date;
        this.website = website;
    }

    public Long getId() {
        return Id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getCompany() {
        return Company;
    }

    public String getCity() {
        return city;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate() {
        return Date;
    }

    public String getWebsite() {
        return website;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
