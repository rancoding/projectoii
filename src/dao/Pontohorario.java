package dao;
// Generated May 23, 2018 12:39:58 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pontohorario generated by hbm2java
 */
public class Pontohorario  implements java.io.Serializable {


     private PontohorarioId id;
     private Funcionario funcionario;
     private Horario horario;
     private boolean diasemana;
     private Set<Pontosentrada> pontosentradas = new HashSet<Pontosentrada>(0);
     private Set<Pontossaida> pontossaidas = new HashSet<Pontossaida>(0);

    public Pontohorario() {
    }

	
    public Pontohorario(PontohorarioId id, Funcionario funcionario, Horario horario, boolean diasemana) {
        this.id = id;
        this.funcionario = funcionario;
        this.horario = horario;
        this.diasemana = diasemana;
    }
    public Pontohorario(PontohorarioId id, Funcionario funcionario, Horario horario, boolean diasemana, Set<Pontosentrada> pontosentradas, Set<Pontossaida> pontossaidas) {
       this.id = id;
       this.funcionario = funcionario;
       this.horario = horario;
       this.diasemana = diasemana;
       this.pontosentradas = pontosentradas;
       this.pontossaidas = pontossaidas;
    }
   
    public PontohorarioId getId() {
        return this.id;
    }
    
    public void setId(PontohorarioId id) {
        this.id = id;
    }
    public Funcionario getFuncionario() {
        return this.funcionario;
    }
    
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Horario getHorario() {
        return this.horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    public boolean isDiasemana() {
        return this.diasemana;
    }
    
    public void setDiasemana(boolean diasemana) {
        this.diasemana = diasemana;
    }
    public Set<Pontosentrada> getPontosentradas() {
        return this.pontosentradas;
    }
    
    public void setPontosentradas(Set<Pontosentrada> pontosentradas) {
        this.pontosentradas = pontosentradas;
    }
    public Set<Pontossaida> getPontossaidas() {
        return this.pontossaidas;
    }
    
    public void setPontossaidas(Set<Pontossaida> pontossaidas) {
        this.pontossaidas = pontossaidas;
    }




}


