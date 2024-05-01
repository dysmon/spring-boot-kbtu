package com.kbtu.event2.service;

import com.kbtu.event2.models.UserRemovedEvent;
import com.kbtu.event2.models.UserReturnedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class UserRemovedListener {

    @EventListener
    public UserReturnedEvent handleUserRemovedEvent(UserRemovedEvent event) {
        return new UserReturnedEvent();
    }

    @EventListener
    void handleReturnedEvent(UserReturnedEvent event) {
        // handle ReturnedEvent ...
    }
    @EventListener(condition = "#event.name eq 'reflectoring'")
    void handleConditionalListener(UserRemovedEvent event) {
        // handle UserRemovedEvent
    }
//    @TransactionalEventListener(phase=TransactionPhase.AFTER_COMPLETION)
//    void handleAfterUserRemoved(UserRemovedEvent event) {
//        // handle UserRemovedEvent
//    }

}
