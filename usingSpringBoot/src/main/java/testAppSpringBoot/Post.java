package testAppSpringBoot;


import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;

    public Users getUser() { return user; }

    public void setUser(Users user) { this.user = user; }

    public String getText() {
        return text;
    }

    public void setText(String textInput){
        this.text = textInput;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
}