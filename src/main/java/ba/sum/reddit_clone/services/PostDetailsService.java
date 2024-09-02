package ba.sum.reddit_clone.services;

import ba.sum.reddit_clone.models.Post;
import ba.sum.reddit_clone.models.User;
import ba.sum.reddit_clone.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostDetailsService {
    private final PostRepository postRepository;
    private final UserDetailsService userDetailsService;

    @Autowired
    public PostDetailsService(PostRepository postRepository, UserDetailsService userDetailsService) {
        this.postRepository = postRepository;
        this.userDetailsService = userDetailsService;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post updatePost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public String getUsernameFromPost(Post post) {
        User user = userDetailsService.getUserById(post.getUserId());
        String username = user.getIme() + " " + user.getPrezime();
        return username;
    }
}