package com.workflow.event;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named("Calcular")
public class ValorTotalJurosDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
            long valor = (long) execution.getVariable("valor");
            long mes = (long) execution.getVariable("quantidadeMeses");

            double montante = valor * Math.pow((1 + 0.04), mes);

            execution.setVariable("total", montante);

        System.out.println(execution.getCurrentActivityName());
    }
}
