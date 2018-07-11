package ManagedBeans;

import DAO.CompraDAO;
import Entidades.Compra;
import Entidades.Fornecedor;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;


@ManagedBean(name = "compraMB")
@SessionScoped
public class CompraMB {

    private Compra compra;
    private CompraDAO compraDAO;
    private ListDataModel compras;
    private Integer idFornecedorSelecionado;
    private String vencimento;
    private Fornecedor fornecedor;

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    
    
    public void recuperarFornecedores(){
        compraDAO = new CompraDAO();
         this.compras = new ListDataModel(
                compraDAO.recuperarTodos());
    }    
    
    public Integer getIdFornecedorSelecionado() {
        return idFornecedorSelecionado;
    }

    public void setIdFornecedorSelecionado(Integer idFornecedorSelecionado) {
        this.idFornecedorSelecionado = idFornecedorSelecionado;
    }

    
    
    public Fornecedor getFornecedor() {

        if (fornecedor == null) {
            fornecedor = new Fornecedor();
        }

        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Compra getCompra() {

        if (compra == null) {
            compra = new Compra();
        }

        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public ListDataModel getCompras() {
        return compras;
    }

    public void setCompras(ListDataModel compras) {
        this.compras = compras;
    }

    public String salvar() {
        compraDAO = new CompraDAO();
        fornecedor = new Fornecedor();
        Date data = new Date (vencimento);
        compra.setVencimento(data);
        fornecedor.setIdFornecedor(idFornecedorSelecionado);
        this.compra.setFornecedor(fornecedor);
        compraDAO.salvar(compra);

        return "/CompraListar";
    }
    
    public String alterar() {
        compraDAO = new CompraDAO();
        fornecedor = new Fornecedor();
        fornecedor.setIdFornecedor(idFornecedorSelecionado);
        this.compra.setFornecedor(fornecedor);
        compraDAO.alterar(compra);
        return "/CompraListar";
    }    
    
    
    public String excluir() {
        compraDAO = new CompraDAO();
        fornecedor = new Fornecedor();
        fornecedor.setIdFornecedor(idFornecedorSelecionado);
        this.compra.setFornecedor(fornecedor);
        compraDAO.excluir(compra);
        return "/CompraListar";
    }        

    public SelectItem[] getFornecedores() {
        DAO.FornecedorDAO fornecedorDAO = new DAO.FornecedorDAO();
        List<Fornecedor> fornecedoresCadastrados = fornecedorDAO.recuperarTodos();
        SelectItem[] fornecedores = new SelectItem[fornecedoresCadastrados.size()];
        Integer i = 0;
        for (Fornecedor fornecedor : fornecedoresCadastrados) {
            fornecedores[i++] = new SelectItem(fornecedor.getIdFornecedor(), fornecedor.getNome());
        }
        return fornecedores;
    }

    public String montarSalvar() {
        compra = null;
        idFornecedorSelecionado = 0;
        return "/CompraSalvar";
    }
    
    public String montarAlterar(){
        this.compra = (Compra) getCompras().getRowData();
        this.setIdFornecedorSelecionado(this.compra.getFornecedor().getIdFornecedor());
        return "/CompraAlterar";
    }
    
    public String montarExcluir(){
        this.compra = (Compra) getCompras().getRowData();
        this.setIdFornecedorSelecionado(this.compra.getFornecedor().getIdFornecedor());
        return "/CompraExcluir";
    }    

}
