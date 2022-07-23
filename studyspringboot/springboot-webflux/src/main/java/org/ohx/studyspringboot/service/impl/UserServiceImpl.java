package org.ohx.studyspringboot.service.impl;

import org.ohx.studyspringboot.entity.User;
import org.ohx.studyspringboot.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mudkip
 * @date 2022/7/23
 */
@Service
public class UserServiceImpl implements UserService {
    private final Map<Integer, User> userMap = new HashMap<>();

    public UserServiceImpl() {
        this.userMap.put(1, new User("张三", "123456", 20, "男"));
        this.userMap.put(2, new User("李四", "123456", 20, "男"));
        this.userMap.put(3, new User("王五", "123456", 20, "男"));
        this.userMap.put(4, new User("赵六", "123456", 20, "男"));
    }

    @Override
    public Mono<User> getUserById(int id) {
        return Mono.justOrEmpty(this.userMap.get(id));
    }

    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.userMap.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> user) {
        return user.doOnNext(u -> userMap.put(userMap.size() + 1, u)).thenEmpty(Mono.empty());
    }
}
