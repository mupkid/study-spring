package org.ohx.studyspring.service;

import org.springframework.stereotype.Service;

/**
 * 注解的value属性值可以不写，默认是类名称，首字母小写
 *
 * @author mudkip
 * @date 2022/7/19
 */
@Service("userService")
public class UserService {
    public void add() {
        System.out.println("service add ...");
    }
}
