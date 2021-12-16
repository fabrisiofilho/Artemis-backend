package com.fabrisio.bluestore.datamining.taks;

import com.fabrisio.bluestore.datamining.core.VendaSemanalEntity;
import com.fabrisio.bluestore.datamining.core.repository.VendaSemanalRepository;
import com.fabrisio.bluestore.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class RegistarDadosSemanaisTask extends TimerTask {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaSemanalRepository vendaSemanalRepository;

    @Override
    public void run() {
        try {
            Long qtdVendas = vendaRepository.countByDataDeCriacaoBetween(LocalDateTime.now().minusHours(1), LocalDateTime.now());
            vendaSemanalRepository.save(new VendaSemanalEntity(null, qtdVendas, LocalDateTime.now(), LocalDateTime.now()));
        } catch (Exception ex) {
            System.out.println("error running thread " + ex.getMessage());
        }
    }
}
