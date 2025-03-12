package effective.mobile.task_management_system.service;

import effective.mobile.task_management_system.entity.UserEntity;
import effective.mobile.task_management_system.exception.ExceptionMessage;
import effective.mobile.task_management_system.exception.UserEntityExistsEmailException;
import effective.mobile.task_management_system.exception.UserEntityNotFoundException;
import effective.mobile.task_management_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final ExceptionMessage exceptionMessage;

    public UserEntity saveUser(UserEntity userEntity) {

        checkUserByEmail(userEntity.getEmail());

        return userRepository.save(userEntity);
    }

    public void checkUserByEmail(String email) {

        if (userRepository.existsByEmail(email)) {

            throw new UserEntityExistsEmailException(exceptionMessage.getUserExistsByEmail());
        }
    }

    public UserEntity findByUserById(Long id) {

        return userRepository.findById(id).orElseThrow(
                () -> new UserEntityNotFoundException(exceptionMessage.getUserEntityNotFound() + id));
    }
}
