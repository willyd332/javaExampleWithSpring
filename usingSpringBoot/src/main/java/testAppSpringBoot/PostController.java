package testAppSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public Iterable<Post> indexPosts(){
        return postRepository.findAll();

    }

    @PostMapping
    public Post post(@RequestBody Post request){
        Post newPost = postRepository.save(request);
        return newPost;

    }


    @GetMapping("/{id}")
    public Post show(@PathVariable("id") Long id) throws Exception{
        Optional<Post> response = postRepository.findById(id);
        if (response.isPresent()){
            Post post = response.get();
            return post;
        }
        throw new Exception("this post doesn't exists");
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        postRepository.deleteById(id);
        return "Deleting " + id;

    }


    @PutMapping("/{id}")
    public Post put(@RequestBody Post updatedPost, @PathVariable("id") Long id) throws Exception{
        Optional<Post> response = postRepository.findById(id);
        if (response.isPresent()){
            Post post = response.get();
            post.setText(updatedPost.getText());
            return postRepository.save(post);
        }
        throw new Exception("Post to update not found");
    }




}


