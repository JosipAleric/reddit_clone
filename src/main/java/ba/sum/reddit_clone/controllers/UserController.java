package ba.sum.reddit_clone.controllers;

import ba.sum.reddit_clone.models.User;
import ba.sum.reddit_clone.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

//    @GetMapping("/users")
//    public String listUsers(Model model){
//        List<User> users = userRepository.findAll();
//        model.addAttribute("users", users);
//        return "users/index";
//    }
//
//    // U klasi UserController
//    @GetMapping("/users/add")
//    public String showAddUserForm(Model model) {
//        model.addAttribute("user", new User());
//        return "users/add";
//    }
//    @PostMapping("/users/add")
//    public String addUser(@Valid User user, BindingResult result, Model model) {
//        if (result.hasErrors()){
//            model.addAttribute("user", user);
//            return "users/add";
//        } else {
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            String passwordEncoded = encoder.encode(user.getLozinka());
//            user.setLozinka(passwordEncoded);
//            user.setPotvrdaLozinke(passwordEncoded);
//            userRepository.save(user);
//            return "redirect:/users";
//        }
//    }
//
//    @GetMapping("/users/delete/{id}")
//    public String deleteUser(@PathVariable("id") long id, Model model) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//        userRepository.delete(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/users/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika:" + id));
//        model.addAttribute("user", user);
//        return "users/edit";
//    }
//
//    @PostMapping("/users/edit/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid User user,
//                             BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "users/edit";
//        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String passwordEncoded = encoder.encode(user.getLozinka());
//        user.setLozinka(passwordEncoded);
//        user.setPotvrdaLozinke(passwordEncoded);
//        userRepository.save(user);
//        return "redirect:/users";
//    }
}