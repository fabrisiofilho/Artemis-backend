package com.fabrisio.bluestore.datamining.taks;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

@Component
public class RecolhedorDeDados {

    RecolhedorDeDados(){
        Timer time = new Timer();
        recolhedorDiario(time);
        recolhedorPorHora(time);
        recolhedorMensal(time);
        recolhedorSemanal(time);
    }

    void recolhedorDiario(Timer time){
        time.schedule(new RegistarDadosDiariosTask(), setCalendar().getTime(), TimeUnit.DAYS.toMillis(1));
    }

    void recolhedorPorHora(Timer time){
        time.schedule(new RegistarDadosPorHoraTask(), setCalendar().getTime(), TimeUnit.HOURS.toMillis(1));
    }

    void recolhedorMensal(Timer time){
        time.schedule(new RegistarDadosMensaisTask(), setCalendar().getTime(), TimeUnit.DAYS.toMillis(30));
    }

    void recolhedorSemanal(Timer time){
        time.schedule(new RegistarDadosSemanaisTask(), setCalendar().getTime(), TimeUnit.DAYS.toMillis(7));
    }

    Calendar setCalendar(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(
                Calendar.DAY_OF_WEEK,
                Calendar.MONDAY
        );
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

}
