package edu.ic6821.pmfriesgo.auth;

import java.util.Optional;

public interface AuthService {
    Optional<String> authenticate(String username, String password);
    IdentityDTO validateToken(String token);
}
