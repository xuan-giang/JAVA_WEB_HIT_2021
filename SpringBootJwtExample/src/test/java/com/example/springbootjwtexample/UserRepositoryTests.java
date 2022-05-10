package com.example.springbootjwtexample;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springbootjwtexample.dto.UserDTO;
import com.example.springbootjwtexample.entity.User;
import com.example.springbootjwtexample.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

//    @Autowired
//    private final ModelMapper mapper;
//
//    public UserRepositoryTests(ModelMapper mapper) {
//        this.mapper = mapper;
//    }

    @Test
    public void testCreateUser() {
        UserDTO userDTO = new UserDTO("Nguyen Xuan Giang", "Ha Noi", "0344253080");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("xuangiang");

        User newUser = new User("xuangiang", password);
//        newUser = mapper.map(userDTO, User.class);
        User savedUser = repo.save(newUser);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
}

