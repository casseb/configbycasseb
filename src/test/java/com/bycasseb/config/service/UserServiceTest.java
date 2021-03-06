package com.bycasseb.config.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.bycasseb.config.common.ClassTest;
import com.bycasseb.config.ds.User;
import com.bycasseb.config.repository.UserRepository;

public class UserServiceTest extends ClassTest {

	@InjectMocks
	private UserServiceImpl userService;
	@Mock
    private UserRepository userRepoMock;

    @Before
	public void before(){
        Optional<User> optional = Optional.of(new User(USER_TEST, PASSWORD_TEST));
        doReturn(optional).when(userRepoMock).findById(USER_TEST);
    }

	@Test
	public void createUser() {
	    User user = new User(USER_TEST, PASSWORD_TEST);
		userService.newUser(USER_TEST, PASSWORD_TEST);

		verify(userRepoMock, times(1)).save(user);
	}

    @Test
    public void verifiedExistUser() {
        User user = new User(USER_TEST, PASSWORD_TEST);
        userService.newUser(USER_TEST, PASSWORD_TEST);

        verify(userRepoMock, times(1)).save(user);
    }

	@Test
	public void successLogin() {
		userService.newUser(USER_TEST, PASSWORD_TEST);
		assertTrue(userService.login(USER_TEST, PASSWORD_TEST));
	}
	
	@Test
	public void incorrectUserName() {
		userService.newUser(USER_TEST, PASSWORD_TEST);
		assertFalse(userService.login(INVALID_TEST, PASSWORD_TEST));
	}
	
	@Test
	public void incorrectPassword() {
		userService.newUser(USER_TEST, PASSWORD_TEST);
		assertFalse(userService.login(USER_TEST, INVALID_TEST));
	}
	
}
