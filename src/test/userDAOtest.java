package test;

import static org.hamcrest.MatchaerAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class userDAOtest {

    private userDAO userdao;

    @Before
    public void setup() {
        userdao = new userDAO;
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id = 1;
        User user = userdao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("임승우"));
        assertThat(user.getPass(), is("1234"));
    }

    @Test
    public void add() throws SQLExecption, ClassNotFoundException {
        User user = new User();
        user.setname("테스트");
        user.setPassword("1111");

        Integer id = userdao.insert(user);

        user inserteUser = userdao.getId(id);
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }
}
