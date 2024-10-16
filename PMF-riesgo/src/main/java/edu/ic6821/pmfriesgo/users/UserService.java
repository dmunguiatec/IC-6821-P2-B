package edu.ic6821.pmfriesgo.users;

import edu.ic6821.pmfriesgo.users.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> signup(String username, String password, String name, String email);
}
