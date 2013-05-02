package services.impl;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import models.domains.User;
import models.mappers.UserMapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import services.UserService;

public class UserServiceImplTest {

    private Injector injector;

    @Mock
    private UserMapper userMapper = mock(UserMapper.class);

    @Before
    public void setup() {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(UserService.class).to(UserServiceImpl.class);
                bind(UserMapper.class).toInstance(userMapper);
            }

        });
    }

    @Test
    public void shouldInjectModules() {
        UserService userService = injector.getInstance(UserService.class);
        assertThat(userService).isNotNull();
    }

    @Test
    public void shouldGetUser() {
        UserService userService = injector.getInstance(UserService.class);
        User user = new User();
        user.setId(1L);
        user.setEmail("example@example.com");
        user.setName("foo");
        when(userMapper.getUser(1L)).thenReturn(user);
        when(userMapper.getUser(2L)).thenThrow(new NullPointerException());

        User result = userService.getUser(1L);
        assertThat(result.getEmail()).isEqualTo(user.getEmail());

        try {
            userService.getUser(2L);
            fail();
        } catch (Throwable t) {
            assertTrue(t instanceof NullPointerException);
        }
    }
}
