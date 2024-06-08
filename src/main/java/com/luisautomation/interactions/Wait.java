package com.luisautomation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.concurrent.TimeUnit;

public class Wait implements Interaction {

    private TimeUnit timeUnit;

    private long duration;


    public Wait(TimeUnit timeUnit, long duration){
        this.timeUnit=timeUnit;
        this.duration=duration;
    }

    public static Wait seconds(long duration){
        return new Wait(TimeUnit.SECONDS, duration);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            timeUnit.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
