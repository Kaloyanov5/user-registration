package form.user_registration.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    public Student(){};

    public Student(Long id, String fullName, Integer age, String phoneNumber, String address) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Student(String fullName, Integer age, String phoneNumber, String address, User user) {
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long user_id) {
        this.id = user_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
