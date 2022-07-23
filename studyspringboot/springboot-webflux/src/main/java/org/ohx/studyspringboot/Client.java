package org.ohx.studyspringboot;

import org.ohx.studyspringboot.entity.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


/**
 * @author mudkip
 * @date 2022/7/23
 */
public class Client {
    public static void main(String[] args) {
        // 调用服务器地址
        WebClient webClient = WebClient.create("http://127.0.0.1:52720");

        // 根据id查询
        String id = "1";
        User user = webClient.get().uri("/user/{id}", id).accept(MediaType.APPLICATION_JSON)
            .retrieve().bodyToMono(User.class).block();

        System.out.println(user.getUsername());

        webClient.get().uri("/user").accept(MediaType.APPLICATION_JSON).retrieve()
            .bodyToFlux(User.class).map(User::getUsername).buffer().doOnNext(System.out::println).blockFirst();
    }
}
