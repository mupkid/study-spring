package org.ohx.springbootfiledemo;

import org.junit.jupiter.api.Test;

/**
 * @author mudkip
 * @date 2022/7/23
 */
public class StringTest {
    @Test
    public void test1() {
        String aaa = "aaaa";
        aaa.matches("^\\S*WA_BASIC_FJ_1001\\S*$");
    }
}
