package effective.mobile.task_management_system.service;

import effective.mobile.task_management_system.entity.UserEntity;
import effective.mobile.task_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity saveUser(UserEntity userEntity) {

        checkUserByEmail(userEntity.getEmail());

        return userRepository.save(userEntity);
    }

    public void checkUserByEmail(String email) {

        if (userRepository.existsByEmail(email)) {

            throw new RuntimeException();
        }
    }

    public UserEntity findByUserById(Long id) {

        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Пользователь с указанным ID не найден"));
    }
}
