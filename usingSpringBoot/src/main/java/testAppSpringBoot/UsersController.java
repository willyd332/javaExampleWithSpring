package testAppSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersRepository UsersRepository;

    @Autowired
    private PostRepository PostRepository;

    @GetMapping
    public Iterable<Users> indexUsers(){
        return UsersRepository.findAll();
    }


    @PostMapping
    public Users user(@RequestBody Users request){
        Users newUser = UsersRepository.save(request);
        return newUser;

    }


    @GetMapping("/{id}")
    public HashMap<String, Object> show(@PathVariable("id") Long id) throws Exception{
        Optional<Users> response = UsersRepository.findById(id);
        if (response.isPresent()){
            Users user = response.get();
            Iterable<Post> posts = PostRepository.findByUser(user);
            HashMap<String, Object> results = new HashMap<>();
            results.put("user", user);
            results.put("posts", posts);
            return results;
        }
        throw new Exception("this user doesn't exists");
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        UsersRepository.deleteById(id);
        return "Deleting " + id;

    }


    @PutMapping("/{id}")
    public Users put(@RequestBody Users updatedUsers, @PathVariable("id") Long id) throws Exception{
        Optional<Users> response = UsersRepository.findById(id);
        if (response.isPresent()){
            Users user = response.get();
            user.setName(updatedUsers.getName());
            return UsersRepository.save(user);
        }
        throw new Exception("User to update not found");
    }

}
