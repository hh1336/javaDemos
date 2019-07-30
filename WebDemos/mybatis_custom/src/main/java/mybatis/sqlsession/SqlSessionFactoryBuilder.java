package mybatis.sqlsession;

import mybatis.cfg.Configuration;
import mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);

        return new DefaultSqlSessionFactory(cfg);
    }
}
