package modules;

import java.util.Properties;

import com.google.inject.PrivateModule;
import com.google.inject.name.Names;

import services.UserService;
import services.impl.UserServiceImpl;

public class UserModule extends PrivateModule {

    @Override
    protected void configure() {
        install(new UserMyBatisModule());

        final Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "default");
        Names.bindProperties(this.binder(), myBatisProperties);
        bind(UserService.class).to(UserServiceImpl.class);
        expose(UserService.class);
    }
}
