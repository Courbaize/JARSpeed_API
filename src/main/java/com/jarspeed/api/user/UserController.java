package com.jarspeed.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for user management.
 * <p>
 * This controller handles HTTP requests for operations on.
 * users, such as retrieving, creating, updating and deleting
 * users.
 * </p>
 */
@RestController
@RequestMapping("/users")
public class UserController {

    // Dependency injection for the User service
    /**
     * Service to manage user-related operations.
     * The Spring framework automatically injects a UserService instance.
     */
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/findById")
    public User findByEmail(@RequestParam Integer pId) {
        return userRepository.findUserById(pId);
    }

    @PutMapping("/merge")
    public User merge(@RequestBody User pUser) {
        User user = userRepository.findUserById(pUser.getId());
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        if (pUser.getEmail() != null) {
            if (user.getEmail() != null) {
                // The new email is equals to the old
                if (!pUser.getEmail().equals(user.getEmail())) {
                    user.setEmail(pUser.getEmail());
                }
            } else {
                // Email has never been initialised
                user.setEmail(pUser.getEmail());
            }
        }
        if (pUser.getLastname() != null) {
            if (user.getLastname() != null) {
                // The new lastname is equals to the old
                if (!pUser.getLastname().equals(user.getLastname())) {
                    user.setLastname(pUser.getLastname());
                }
            } else {
                // Lastname has never been initialised
                user.setLastname(pUser.getLastname());
            }
        }
        if (pUser.getFirstname() != null) {
            if (user.getFirstname() != null) {
                // The new firstname is equals to the old
                if (!pUser.getFirstname().equals(user.getFirstname())) {
                    user.setFirstname(pUser.getFirstname());
                }
            } else {
                // Firstname has never been initialised
                user.setFirstname(pUser.getFirstname());
            }
        }
        if (pUser.getAge() != null) {
            if (user.getAge() != null) {
                // The new age is equals to the old
                if (!pUser.getAge().equals(user.getAge())) {
                    user.setAge(pUser.getAge());
                }
            } else {
                // Age has never been initialised
                user.setAge(pUser.getAge());
            }
        }
        if (pUser.getWeight() != null) {
            if (user.getWeight() != null) {
                // The new weight is equals to the old
                if (!pUser.getWeight().equals(user.getWeight())) {
                    user.setWeight(pUser.getWeight());
                }
            } else {
                // Weight has never been initialised
                user.setWeight(pUser.getWeight());
            }
        }
        if (pUser.getGender() != null) {
            if (user.getGender() != null) {
                // The new gender is equals to the old
                if (!pUser.getGender().equals(user.getGender())) {
                    user.setGender(pUser.getGender());
                }
            } else {
                // Gender has never been initialised
                user.setGender(pUser.getGender());
            }
        }
        if (pUser.getPassword() != null) {
            if (user.getPassword() != null) {
                // The new password is equals to the old
                if (!pUser.getPassword().equals(user.getPassword())) {
                    user.setPassword(pUser.getPassword());
                }
            } else {
                // Password has never been initialised
                user.setPassword(pUser.getPassword());
            }
        }
        return userRepository.save(user);
    }
}
