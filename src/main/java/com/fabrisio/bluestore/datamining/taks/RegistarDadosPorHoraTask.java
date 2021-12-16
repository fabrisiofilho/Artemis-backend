package com.fabrisio.bluestore.datamining.taks;

import com.fabrisio.bluestore.datamining.core.VendaPorHoraEntity;
import com.fabrisio.bluestore.datamining.core.repository.VendaPorHoraRepository;
import com.fabrisio.bluestore.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class RegistarDadosPorHoraTask extends TimerTask {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaPorHoraRepository vendaPorHoraRepository;

    @Override
    public void run() {
        try {
            Long qtdVendas = vendaRepository.countByDataDeCriacaoBetween(LocalDateTime.now().minusHours(1), LocalDateTime.now());
            vendaPorHoraRepository.save(new VendaPorHoraEntity(null, qtdVendas, LocalDateTime.now(), LocalDateTime.now()));
        } catch (Exception ex) {
            System.out.println("error running thread " + ex.getMessage());
        }
    }
}
