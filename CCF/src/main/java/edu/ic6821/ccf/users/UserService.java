package edu.ic6821.ccf.users;

import edu.ic6821.ccf.users.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> signup(String username, String password, String name, String email);
}
