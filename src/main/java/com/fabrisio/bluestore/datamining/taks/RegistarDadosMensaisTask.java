package com.fabrisio.bluestore.datamining.taks;

import com.fabrisio.bluestore.datamining.core.VendaMensaisEntity;
import com.fabrisio.bluestore.datamining.core.repository.VendaMensaisRepository;
import com.fabrisio.bluestore.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class RegistarDadosMensaisTask extends TimerTask {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaMensaisRepository vendaMensaisRepository;

    @Override
    public void run() {
        try {
            Long qtdVendas = vendaRepository.countByDataDeCriacaoBetween(LocalDateTime.now().minusHours(1), LocalDateTime.now());
            vendaMensaisRepository.save(new VendaMensaisEntity(null, qtdVendas, LocalDateTime.now(), LocalDateTime.now()));
        } catch (Exception ex) {
            System.out.println("error running thread " + ex.getMessage());
        }
    }
}
