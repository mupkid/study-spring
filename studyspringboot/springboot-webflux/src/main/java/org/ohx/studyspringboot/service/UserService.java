package org.ohx.studyspringboot.service;

import org.ohx.studyspringboot.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mudkip
 * @date 2022/7/23
 */
public interface UserService {
    Mono<User> getUserById(int id);

    Flux<User> getAllUser();

    Mono<Void> saveUserInfo(Mono<User> user);
}
