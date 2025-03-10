package effective.mobile.task_management_system.service;

import effective.mobile.task_management_system.entity.User;
import effective.mobile.task_management_system.entity.UserRole;
import effective.mobile.task_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(User user) {

        user.setUserRole(UserRole.USER_ROLE);

        return userRepository.save(user);
    }
    public void userExistsByEmail(String email) {

        if (userRepository.existsByEmail(email)) {

            throw new RuntimeException();
        }
    }
}
