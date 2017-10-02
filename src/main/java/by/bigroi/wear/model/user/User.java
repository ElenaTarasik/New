package by.bigroi.wear.model.user;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_USER")
    private long id;

    @Column(name = "SURNAME", nullable = false)
    @Pattern(regexp="^[a-zA-Z]+$", message = "${user.surname.invalid}")
    private String surname;

    @Column(name = "NAME", nullable = false)
    @Pattern(regexp="^[a-zA-Z]+$", message = "${user.name.invalid}")
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    @Email(message = "{user.email.invalid}")
    @Pattern(regexp="^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]+$", message = "${user.email.invalid}")
    private String email;

    @Size(min = 5, message = "${size.user.password}")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE", nullable = false, unique = true)
    @Size(min = 12, message = "${size.user.phone}")
    @Pattern(regexp="^\\+[0-9][0-9][0-9]?[\\s]*\\(?\\d{2}\\)?[-\\s]?\\d{3}[-\\s]?\\d{2}[-\\s]?\\d{2}$", message = "{user.phone.invalid}")
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "REG_DATE")
    @DateTimeFormat(pattern = "MM/dd/yy")
    private String regDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "USER_USER_ROLE", joinColumns = {
            @JoinColumn (name = "ID_USER")}, inverseJoinColumns = {
            @JoinColumn (name = "ID_ROLE")})
    private Set<UserRole> roles = new HashSet<>();

    ////////////////  CONSTRUCTORS ///////////////////////////





    //////////////// GETTERS + SETTERS ///////////////////////////

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    ///////////// EQUALS + HASHCODE + ToSTRING ///////////////////////


}
