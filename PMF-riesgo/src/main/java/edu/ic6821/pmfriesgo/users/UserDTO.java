package edu.ic6821.pmfriesgo.users;

public record UserDTO(String username, String password, String name, String email) {
    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
