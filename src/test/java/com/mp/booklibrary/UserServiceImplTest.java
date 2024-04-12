package com.mp.booklibrary;

import com.mp.booklibrary.dto.UserDto;
import com.mp.booklibrary.entity.UserProfile;
import com.mp.booklibrary.enums.UserProfileType;
import com.mp.booklibrary.repository.UserRepository;
import com.mp.booklibrary.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public  void getUsersFromRepoTest(){
        when(userRepository.findAll()).thenReturn(Arrays.asList(
                new UserProfile(1L,"One User","myemail_one@myemail.com", UserProfileType.BORROWER, true),
                new UserProfile(2L,"Other User","myemail_two@myemail.com", UserProfileType.BACKOFFICE, false)
        ));

       List<UserDto> users =   userService.findAll();
       assertEquals("One User", users.get(0).getName());
       assertEquals("Other User", users.get(1).getName());
    }

}
