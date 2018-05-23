package dao;
// Generated May 23, 2018 12:39:58 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private byte idfuncionario;
     private Horario horario;
     private Localtrabalho localtrabalho;
     private String nome;
     private String username;
     private short password;
     private Date datanascimento;
     private char sexo;
     private boolean activo;
     private boolean tipo;
     private Set<Entrega> entregasForIdfuncionarioentrega = new HashSet<Entrega>(0);
     private Set<Entrega> entregasForIdfuncionariorecebe = new HashSet<Entrega>(0);
     private Set<Venda> vendas = new HashSet<Venda>(0);
     private Set<Pontohorario> pontohorarios = new HashSet<Pontohorario>(0);

    public Funcionario() {
    }

	
    public Funcionario(byte idfuncionario, String nome, String username, short password, Date datanascimento, char sexo, boolean activo, boolean tipo) {
        this.idfuncionario = idfuncionario;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.datanascimento = datanascimento;
        this.sexo = sexo;
        this.activo = activo;
        this.tipo = tipo;
    }
    public Funcionario(byte idfuncionario, Horario horario, Localtrabalho localtrabalho, String nome, String username, short password, Date datanascimento, char sexo, boolean activo, boolean tipo, Set<Entrega> entregasForIdfuncionarioentrega, Set<Entrega> entregasForIdfuncionariorecebe, Set<Venda> vendas, Set<Pontohorario> pontohorarios) {
       this.idfuncionario = idfuncionario;
       this.horario = horario;
       this.localtrabalho = localtrabalho;
       this.nome = nome;
       this.username = username;
       this.password = password;
       this.datanascimento = datanascimento;
       this.sexo = sexo;
       this.activo = activo;
       this.tipo = tipo;
       this.entregasForIdfuncionarioentrega = entregasForIdfuncionarioentrega;
       this.entregasForIdfuncionariorecebe = entregasForIdfuncionariorecebe;
       this.vendas = vendas;
       this.pontohorarios = pontohorarios;
    }
   
    public byte getIdfuncionario() {
        return this.idfuncionario;
    }
    
    public void setIdfuncionario(byte idfuncionario) {
        this.idfuncionario = idfuncionario;
    }
    public Horario getHorario() {
        return this.horario;
    }
    
    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    public Localtrabalho getLocaltrabalho() {
        return this.localtrabalho;
    }
    
    public void setLocaltrabalho(Localtrabalho localtrabalho) {
        this.localtrabalho = localtrabalho;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public short getPassword() {
        return this.password;
    }
    
    public void setPassword(short password) {
        this.password = password;
    }
    public Date getDatanascimento() {
        return this.datanascimento;
    }
    
    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }
    public char getSexo() {
        return this.sexo;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public boolean isActivo() {
        return this.activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public boolean isTipo() {
        return this.tipo;
    }
    
    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }
    public Set<Entrega> getEntregasForIdfuncionarioentrega() {
        return this.entregasForIdfuncionarioentrega;
    }
    
    public void setEntregasForIdfuncionarioentrega(Set<Entrega> entregasForIdfuncionarioentrega) {
        this.entregasForIdfuncionarioentrega = entregasForIdfuncionarioentrega;
    }
    public Set<Entrega> getEntregasForIdfuncionariorecebe() {
        return this.entregasForIdfuncionariorecebe;
    }
    
    public void setEntregasForIdfuncionariorecebe(Set<Entrega> entregasForIdfuncionariorecebe) {
        this.entregasForIdfuncionariorecebe = entregasForIdfuncionariorecebe;
    }
    public Set<Venda> getVendas() {
        return this.vendas;
    }
    
    public void setVendas(Set<Venda> vendas) {
        this.vendas = vendas;
    }
    public Set<Pontohorario> getPontohorarios() {
        return this.pontohorarios;
    }
    
    public void setPontohorarios(Set<Pontohorario> pontohorarios) {
        this.pontohorarios = pontohorarios;
    }




}


