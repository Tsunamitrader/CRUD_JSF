package DAO;

import java.util.List;

public class VendaDAO extends Util{
    
    public List<Entidades.Venda> recuperarTodos(){
       List<Entidades.Venda> vendas; 
       this.abreConexao();
       vendas = em.createQuery("select v from Venda as v").getResultList();
       this.fecharConexao();
       return vendas;
    }
    
}