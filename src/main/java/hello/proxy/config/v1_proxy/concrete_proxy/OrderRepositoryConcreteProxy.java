package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {
    private final OrderRepositoryV2 target;
    private final LogTrace trace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace trace) {
        this.target = target;
        this.trace = trace;
    }

    @Override
    public void save(String itemId) {
        //저장 로직
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외발생");
        }
        sleep(1000);
    }

    private void sleep(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
