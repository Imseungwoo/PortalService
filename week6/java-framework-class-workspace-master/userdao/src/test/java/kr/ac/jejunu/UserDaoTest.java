package kr.ac.jejunu;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class UserDaoTest {

    private UserDao userDao;
    private DaoFactory daoFactory;

    @Before
    public void setup() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
        //ApplicationContexet applicationContexet = new GenericXmlAppliContext("classPath:docFactory.xml");
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void update() {
        User user = new user();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.update(user);

        user.setName("허윤호");
        user.setPassword("1234");
        userDao.update(user);
        user updateuser = userDao.get(id);

        assertThat(updatedUser.getId(), is(user.getId()));
        assertThat(updatedUser.getName(), is(user.getName()));
        assertThat(updatedUser.getPassword(), is(user.getPassword()));
    }

    private Integer insertuserTest() throws SQLException, ClassNotFoundException {
        user.setName("헐크");
        user.setPassword("1111");
        return userDao.insert(user);
    }

    public void delete() {
        User user = new User();
        Integer id = insertUserTest(user);

        userDao.delete(id);

        User deletedUser = userDao.get(id);
        assertThat(deletedUser, nullValue());
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id= 1;
        User user = userDao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        User user = new User();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        User insertedUser = userDao.get(id);
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

}
