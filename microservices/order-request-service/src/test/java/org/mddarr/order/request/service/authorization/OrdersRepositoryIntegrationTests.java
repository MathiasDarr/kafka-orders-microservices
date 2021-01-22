package org.mddarr.order.request.service.authorization;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mddarr.order.request.service.AbstractIntegrationTest;
import org.mddarr.order.request.service.models.UserEntity;
import org.mddarr.order.request.service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrdersRepositoryIntegrationTests extends AbstractIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test_save_and_get_user_by_id() {
        UserEntity userEntity = new UserEntity();
        final String userid1 = UUID.randomUUID().toString();

        userEntity.setUserid(userid1);
        userEntity.setFirst_name("Charles");
        userEntity.setLast_name("Goodwin");
        userEntity.setEmail("cgoodwin@gmail.com");
        userEntity.setPassword("password");

        userEntity.setUpdate_ts(new Date(System.currentTimeMillis()));

        UserEntity userEntity2 = new UserEntity();
        final String userid2 = UUID.randomUUID().toString();

        userEntity2.setUserid(userid2);
        userEntity2.setFirst_name("Erik");
        userEntity2.setLast_name("Baldwin");
        userEntity2.setEmail("cadhar@gmail.com");
        userEntity2.setPassword("password");
        userEntity2.setUpdate_ts(new Date(System.currentTimeMillis()));

        userRepository.save(userEntity);
        userRepository.save(userEntity2);

        List<UserEntity> allUsers = userRepository.findAll();

        assertThat(allUsers).isNotEmpty();

        Optional<UserEntity> optionalUserEntity = userRepository.findById(userid1);
        Assertions.assertTrue(optionalUserEntity.isPresent());
        UserEntity foundUser1 = optionalUserEntity.get();

        Optional<UserEntity> optionalUserEntity2 = userRepository.findById(userid2);
        Assertions.assertTrue(optionalUserEntity2.isPresent());
        UserEntity foundUser2 = optionalUserEntity2.get();

        Assertions.assertEquals(userEntity, foundUser1);
        Assertions.assertEquals(userEntity2, foundUser2);

    }

}
