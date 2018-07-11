package DAO;

import java.util.List;

public class CompraDAO extends Util{
    
    public List<Entidades.Compra> recuperarTodos(){
       List<Entidades.Compra> compras; 
       this.abreConexao();
       compras = em.createQuery("select c from Compra as c").getResultList();
       this.fecharConexao();
       return compras;
    }
    
}