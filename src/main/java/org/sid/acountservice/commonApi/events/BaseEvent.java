package org.sid.acountservice.commonApi.events;

import lombok.Getter;
import org.sid.acountservice.commonApi.commands.BaseCommand;

public abstract class BaseEvent<T> {

    @Getter private T id;

    public BaseEvent(T id){
        this.id = id;
    }
}
