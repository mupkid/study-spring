package org.ohx.studyspring;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * @author mudkip
 * @date 2022/7/22
 */
public class ReactorTest {
    @Test
    public void Test1() {
        // just方法直接声明元素
        Flux.just(1, 2, 3, 4).subscribe(System.out::println);
        Mono.just(1).map(e -> e + 2).subscribe(System.out::println);

        Integer[] array = {1, 2, 3, 4};
        Flux.fromArray(array);

        List<Integer> list = Arrays.asList(array);
        Flux.fromIterable(list);
        Flux.fromStream(list.stream());
    }
}
