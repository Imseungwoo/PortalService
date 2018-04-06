package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
    @Value("${db.classname}");
    private String className;
    @Value("${db.url}");
    private String url;
    @Value("${db.username}");
    private String username;
    @Value("${db.password}");
    private String password;

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource;
        try{
            dataSource.setDriverClass(Class.forName(className));
        } catch (ClassNotfoundexception) {
            new Runtimeexception(e);
        }
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
