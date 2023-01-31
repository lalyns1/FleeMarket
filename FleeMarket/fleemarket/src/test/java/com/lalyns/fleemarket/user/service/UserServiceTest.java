package com.lalyns.fleemarket.user.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lalyns.fleemarket.user.dto.RegistReq;
import com.lalyns.fleemarket.user.dto.RegistRes;
import com.lalyns.fleemarket.user.entity.User;
import com.lalyns.fleemarket.user.entity.UserRoleEnum;
import com.lalyns.fleemarket.user.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Spy
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    void testRegisterUser() {
        // given
        RegistReq request = new RegistReq("User1", "1q2w3e4r!");
        User user = new User("User1", passwordEncoder.encode("1q2w3e4r!"), UserRoleEnum.USER);
        when(userRepository.existsByUsername(any(String.class))).thenReturn(false);
        when(userRepository.saveAndFlush(any(User.class))).thenReturn(user);
        
        // when
        RegistRes res = userService.registerUser(request);

        // then
        assertThat(res.getUsername()).isEqualTo(request.getUsername());
        assertThat(res.getRole()).isEqualTo(UserRoleEnum.USER);

        verify(userRepository).saveAndFlush(any(User.class));
    }
}
