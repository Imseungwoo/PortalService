package test;

import static org.hamcrest.MatchaerAssert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class userDAOtest {

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        userDAO userdao = new userDAO();
        int id = 1;
        User user = userdao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("임승우"));
        assertThat(user.getPass(), is("1234"));
    }
}
