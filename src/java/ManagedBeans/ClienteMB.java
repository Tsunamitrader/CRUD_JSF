package ManagedBeans;

import javax.faces.bean.ManagedBean;
import DAO.ClienteDAO;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Fabricio
 */
@ManagedBean (name = "clienteMB")
@SessionScoped
public class ClienteMB {

private Entidades.Cliente cliente;
private ClienteDAO DAOCliente;
private ListDataModel clientes;

    public ListDataModel getClientes() {
        return clientes;
    }

    public void setClientes(ListDataModel clientes) {
        this.clientes = clientes;
    }
    
    public void recuperarClientes(){
        DAOCliente = new ClienteDAO();
         this.clientes = new ListDataModel(DAOCliente.recuperarTodos());
    }
    

    public Entidades.Cliente getCliente() {
        
        if(cliente == null){
            cliente = new Entidades.Cliente();
        }
        
        return cliente;
    }

    public void setCliente(Entidades.Cliente cliente) {
        this.cliente = cliente;
    }

    public String montarSalvar(){
        cliente = null;
        return "/ClienteSalvar";
    }
    
    public String salvar(){
        DAOCliente = new ClienteDAO();
        DAOCliente.salvar(cliente);        
        return "/ClienteListar";
    }
    
    public String alterar(){
        DAOCliente = new ClienteDAO();
        DAOCliente.alterar(cliente);
        return "/ClienteListar";
    }
    
public String montarAlteracao(){
    this.cliente = (Entidades.Cliente) getClientes().getRowData();
    return "/ClienteAlterar";
}  

public String excluir(){
    DAOCliente = new ClienteDAO();
    DAOCliente.excluir(this.getCliente());
    return "/ClienteListar";
}

public String montarExcluir(){
    this.cliente = (Entidades.Cliente) getClientes().getRowData();
    return "/ClienteExcluir";
}
    
   
}