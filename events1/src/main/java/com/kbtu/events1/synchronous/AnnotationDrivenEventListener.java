package com.kbtu.events1.synchronous;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;



@Component
@Getter
@Slf4j
public class AnnotationDrivenEventListener {

    @EventListener
    @Async
    public void handleContextStart(ContextStartedEvent cse) {
        System.out.println("Handling context started event");
    }

    @EventListener(condition = "#event.success")
    @Async
    public void handleSuccessful(GenericSpringEvent<String> event) {
        System.out.println("Handling generic event (conditional).");
    }

//    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
//    public void handleCustom(CustomSpringEvent event) {
//        System.out.println("Handling event inside a transaction BEFORE COMMIT.");
//    }
}
