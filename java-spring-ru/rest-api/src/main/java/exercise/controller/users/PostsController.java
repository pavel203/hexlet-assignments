package exercise.controller.users;

import exercise.model.Post;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private static final List<Post> posts = new ArrayList<>();

    @GetMapping("/users/{id}/posts")
    public List<Post> posts(@PathVariable(name = "id") int id) {
        return posts.stream().filter(post -> post.getUserId() == id).toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@PathVariable(name = "id") int id, @RequestBody Post post) {
        post.setUserId(id);
        posts.add(post);
        return post;
    }
}
// END
