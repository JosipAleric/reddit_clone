package ba.sum.reddit_clone.controllers;

import ba.sum.reddit_clone.models.Post;
import ba.sum.reddit_clone.models.User;
import ba.sum.reddit_clone.repositories.PostRepository;
import ba.sum.reddit_clone.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ba.sum.reddit_clone.services.PostDetailsService;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PostDetailsService postService;

    @GetMapping("/posts")
    public String listPosts(Model model){
        List<Post> post = postRepository.findAll();
        model.addAttribute("posts", post);
        model.addAttribute("postService", postService);
        return "posts/index";
    }

//    @GetMapping("/posts/add")
//    public String showAddPostForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "posts/add";
//    }

    @PostMapping("/posts/add")
    public String addPost(Post post) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userDetailsService.findByEmail(userDetails.getUsername());
        post.setUserId(user.getId());
        post.setVoteCount(0);
        postRepository.save(post);
        return "redirect:/posts";
    }


    @PostMapping("/posts/upvote/{postId}")
    public ResponseEntity<Void> upvotePost(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }

        post.setVoteCount(post.getVoteCount() + 1);
        postService.updatePost(post);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/posts/downvote/{postId}")
    public ResponseEntity<Void> downvotePost(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }

        post.setVoteCount(post.getVoteCount() - 1);
        postService.updatePost(post);

        return ResponseEntity.ok().build();
    }

}
