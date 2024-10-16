package edu.ic6821.ccf.auth;

import java.util.Optional;

public interface AuthService {
    Optional<String> authenticate(String username, String password);
    IdentityDTO validateToken(String token);
}
