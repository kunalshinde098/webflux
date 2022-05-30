package com.study.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("Test1")
                //.then(Mono.error(new RuntimeException("dfsdf")))
                .log();

        monoString.subscribe(System.out::println, throwable -> System.err.println(throwable));
    }

    @Test
    public void testFlux(){
        Flux<Integer> ref = Flux.just(1,2,3,5)
                .concatWithValues(Integer.valueOf(0))
                .log();
        ref.subscribe(System.out::println);
    }

}
