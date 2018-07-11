package ManagedBeans;

import javax.faces.bean.ManagedBean;
import DAO.FornecedorDAO;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Fabricio
 */
@ManagedBean (name = "fornecedorMB")
@SessionScoped
public class FornecedorMB {

private Entidades.Fornecedor fornecedor;
private FornecedorDAO DAOFornecedor;
private ListDataModel fornecedores;

    public ListDataModel getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(ListDataModel fornecedores) {
        this.fornecedores = fornecedores;
    }
    
    public void recuperarFornecedores(){
        DAOFornecedor = new FornecedorDAO();
         this.fornecedores = new ListDataModel(DAOFornecedor.recuperarTodos());
    }
    

    public Entidades.Fornecedor getFornecedor() {
        
        if(fornecedor == null){
            fornecedor = new Entidades.Fornecedor();
        }
        
        return fornecedor;
    }

    public void setFornecedor(Entidades.Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String montarSalvar(){
        fornecedor = null;
        return "/FornecedorSalvar";
    }
    
    public String salvar(){
        DAOFornecedor = new FornecedorDAO();
        DAOFornecedor.salvar(fornecedor);        
        return "/FornecedorListar";
    }
    
    public String alterar(){
        DAOFornecedor = new FornecedorDAO();
        DAOFornecedor.alterar(fornecedor);
        return "/FornecedorListar";
    }
    
public String montarAlteracao(){
    this.fornecedor = (Entidades.Fornecedor) getFornecedores().getRowData();
    return "/FornecedorAlterar";
}  

public String excluir(){
    DAOFornecedor = new FornecedorDAO();
    DAOFornecedor.excluir(this.getFornecedor());
    return "/FornecedorListar";
}

public String montarExcluir(){
    this.fornecedor = (Entidades.Fornecedor) getFornecedores().getRowData();
    return "/FornecedorExcluir";
}
    
   
}