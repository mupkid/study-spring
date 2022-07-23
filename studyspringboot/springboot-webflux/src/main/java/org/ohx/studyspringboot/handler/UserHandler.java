package org.ohx.studyspringboot.handler;

import org.ohx.studyspringboot.entity.User;
import org.ohx.studyspringboot.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mudkip
 * @date 2022/7/23
 */
public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        // 获取参数
        int id = Integer.parseInt(request.pathVariable("id"));
        // 空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> user = this.userService.getUserById(id);
        return user.flatMap(
            u -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(u))
                .switchIfEmpty(notFound));
    }

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        // 空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Flux<User> users = this.userService.getAllUser();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
            .body(users, User.class)
            .switchIfEmpty(notFound);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(userService.saveUserInfo(userMono));
    }
}
