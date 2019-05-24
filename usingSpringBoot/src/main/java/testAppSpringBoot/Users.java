package testAppSpringBoot;


import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String nameInput){
        this.name = nameInput;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }
}