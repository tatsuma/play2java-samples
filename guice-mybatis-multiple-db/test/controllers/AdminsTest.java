package controllers;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.test.Helpers.inMemoryDatabase;

import java.util.HashMap;
import java.util.Map;

import models.domains.Admin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import play.Application;
import play.GlobalSettings;
import play.mvc.Result;
import play.test.FakeApplication;
import play.test.Helpers;

import services.AdminService;

public class AdminsTest {

    private FakeApplication app;
    private AdminService adminService = mock(AdminService.class);

    private class FakeGlobalClass extends GlobalSettings {
        private Injector injector;

        @Override
        public void onStart(Application app) {
            injector = Guice.createInjector(new AbstractModule() {

                @Override
                protected void configure() {
                    bind(AdminService.class).toInstance(adminService);
                }
            });

        }

        @Override
        public <A> A getControllerInstance(Class<A> clazz) throws Exception {
            return injector.getInstance(clazz);
        }
    }

    @Before
    public void setup() {
        Map<String, String> replaceConfig = new HashMap<String, String>();
        replaceConfig.putAll(inMemoryDatabase("default"));
        replaceConfig.put("logger.root", "ERROR");
        replaceConfig.put("logger.play", "ERROR");
        replaceConfig.put("logger.application", "ERROR");
        app = Helpers.fakeApplication(replaceConfig, new FakeGlobalClass());
        Helpers.start(app);
    }

    @Test
    public void shouldGetAdmin() {

        Admin returnedAdmin = new Admin();
        returnedAdmin.setId(1L);
        returnedAdmin.setEmail("example1@example.com");
        returnedAdmin.setName("foo");
        when(adminService.getUser(1L)).thenReturn(returnedAdmin);

        Result result = Helpers.route(Helpers.fakeRequest(Helpers.GET, "/admins/1"));
        assertThat(Helpers.status(result)).isEqualTo(Helpers.OK);
        assertThat(Helpers.contentAsString(result)).isEqualTo(
                "{\"id\":1,\"email\":\"example1@example.com\",\"name\":\"foo\"}");

        try {
            Helpers.route(Helpers.fakeRequest(Helpers.GET, "/api/1/admins/2"));
            fail();
        } catch (Throwable t) {
            assertTrue(t instanceof NullPointerException);
        }
    }

    @After
    public void teardown() {
        Helpers.stop(app);
    }
}