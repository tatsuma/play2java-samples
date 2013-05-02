import modules.AnotherModule;
import modules.UserModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

import play.Application;
import play.GlobalSettings;

public class Global extends GlobalSettings {

    private Injector injector;

    @Override
    public void onStart(Application app) {
        injector = Guice.createInjector(new UserModule(), new AnotherModule());
    }

    @Override
    public <A> A getControllerInstance(Class<A> clazz) throws Exception {
        return injector.getInstance(clazz);
    }
}
