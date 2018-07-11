package DAO;

import java.util.List;

public class FornecedorDAO extends Util{
    
    public List<Entidades.Fornecedor> recuperarTodos(){
       List<Entidades.Fornecedor> fornecedores; 
       this.abreConexao();
       fornecedores = em.createQuery("select f from Fornecedor as f").getResultList();
       this.fecharConexao();
       return fornecedores;
    }
    
}