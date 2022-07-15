package org.ohx.springbootsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class TestBCrypt {

    @Test
    public void test1(){
        String hashpw = BCrypt.hashpw("123456", BCrypt.gensalt());
        String hashpw2 = BCrypt.hashpw("password", BCrypt.gensalt());
        System.out.println(hashpw);
        System.out.println(hashpw2);

        boolean checkpw = BCrypt.checkpw("123", hashpw);
        boolean checkpw2 = BCrypt.checkpw("123", hashpw2);
        System.out.println(checkpw);
        System.out.println(checkpw2);
    }
}
