package modules;

import java.util.Properties;

import com.google.inject.PrivateModule;
import com.google.inject.name.Names;

import services.AdminService;
import services.impl.AdminServiceImpl;

public class AnotherModule extends PrivateModule {

    @Override
    protected void configure() {
        install(new AnotherMyBatisModule());

        final Properties myBatisProperties = new Properties();
        myBatisProperties.setProperty("mybatis.environment.id", "default");
        Names.bindProperties(this.binder(), myBatisProperties);
        bind(AdminService.class).to(AdminServiceImpl.class);
        expose(AdminService.class);
    }
}
