package org.ohx.studyspringboot;

import org.ohx.studyspringboot.handler.UserHandler;
import org.ohx.studyspringboot.service.UserService;
import org.ohx.studyspringboot.service.impl.UserServiceImpl;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

/**
 * @author mudkip
 * @date 2022/7/23
 */
public class Server {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    /**
     * 创建 Router 路由
     *
     * @return
     */
    public RouterFunction<ServerResponse> routingFunction() {
        UserService userService = new UserServiceImpl();
        UserHandler handler = new UserHandler(userService);

        // 设置路由
        return RouterFunctions.route(GET("/user/{id}").and(accept(APPLICATION_JSON)), handler::getUserById)
            .andRoute(GET("/user").and(accept(APPLICATION_JSON)), handler::getAllUsers)
            .andRoute(POST("/user").and(accept(APPLICATION_JSON)), handler::saveUser);
    }

    /**
     * 创建服务器完成适配
     */
    public void createReactorServer() {
        // 路由和handler适配
        RouterFunction<ServerResponse> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

        HttpServer httpServer = HttpServer.create();
        httpServer.handle(adapter).bindNow();
    }
}
