package DAO;

import java.util.List;

public class ClienteDAO extends Util{
    
    public List<Entidades.Cliente> recuperarTodos(){
       List<Entidades.Cliente> clientes; 
       this.abreConexao();
       clientes = em.createQuery("select c from Cliente as c").getResultList();
       this.fecharConexao();
       return clientes;
    }
    
}
