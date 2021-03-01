package com.backpack.springboot.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {userRepository.deleteAll();}

    @Test
    public void 유저저장_불러오기(){
        //given
        String name = "테스트계정";
        String email = "test@example.com";

        userRepository.save(User.builder()
                .name(name)
                .email(email)
                .role(Role.USER)
                .picture("Test")
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
    }//end 유저저장_불러오기()

}
