package edu.ic6821.pmfmercado.users;

import edu.ic6821.pmfmercado.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByExtId(String extId);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
