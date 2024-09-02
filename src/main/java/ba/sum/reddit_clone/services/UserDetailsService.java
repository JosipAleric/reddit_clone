package ba.sum.reddit_clone.services;

import ba.sum.reddit_clone.models.User;
import ba.sum.reddit_clone.models.UserDetails;
import ba.sum.reddit_clone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = repository.findByEmail(username);
        return new UserDetails(u);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
}