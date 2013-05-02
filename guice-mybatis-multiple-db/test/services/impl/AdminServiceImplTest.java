package services.impl;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import models.domains.Admin;
import models.mappers.AdminMapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import services.AdminService;

public class AdminServiceImplTest {

    private Injector injector;

    @Mock
    private AdminMapper userMapper = mock(AdminMapper.class);

    @Before
    public void setup() {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(AdminService.class).to(AdminServiceImpl.class);
                bind(AdminMapper.class).toInstance(userMapper);
            }

        });
    }

    @Test
    public void shouldInjectModules() {
        AdminService userService = injector.getInstance(AdminService.class);
        assertThat(userService).isNotNull();
    }

    @Test
    public void shouldGetAdmin() {
        AdminService userService = injector.getInstance(AdminService.class);
        Admin user = new Admin();
        user.setId(1L);
        user.setEmail("example@example.com");
        user.setName("foo");
        when(userMapper.getUser(1L)).thenReturn(user);
        when(userMapper.getUser(2L)).thenThrow(new NullPointerException());

        Admin result = userService.getUser(1L);
        assertThat(result.getEmail()).isEqualTo(user.getEmail());

        try {
            userService.getUser(2L);
            fail();
        } catch (Throwable t) {
            assertTrue(t instanceof NullPointerException);
        }
    }
}
