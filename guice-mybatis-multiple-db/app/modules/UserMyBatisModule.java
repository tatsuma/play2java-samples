package modules;

import javax.sql.DataSource;

import models.mappers.UserMapper;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;

import com.google.inject.Provider;
import com.google.inject.name.Names;

import play.db.DB;

public class UserMyBatisModule extends MyBatisModule {

    @Override
    protected void initialize() {
        bindDataSourceProvider(new Provider<DataSource>() {
            @Override
            public DataSource get() {
                return DB.getDataSource("default");
            }
        });
        addMapperClass(UserMapper.class);

        bindConstant().annotatedWith(Names.named("mybatis.configuration.mapUnderscoreToCamelCase")).to(true);
        bindTransactionFactoryType(JdbcTransactionFactory.class);
    }
}
