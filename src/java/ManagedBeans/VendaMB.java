package ManagedBeans;


import DAO.VendaDAO;
import Entidades.Venda;
import Entidades.Cliente;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;


@ManagedBean(name = "vendaMB")
@SessionScoped
public class VendaMB {

    private Venda venda;
    private VendaDAO vendaDAO;
    private ListDataModel vendas;
    private Integer idClienteSelecionado;
    private Cliente cliente;
    private String vencimento;
    
    
 
    public String getVencimento() {
        return vencimento;
    }
 
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }
    
    

    public void recuperarClientes(){
        vendaDAO = new VendaDAO();
         this.vendas = new ListDataModel(
                vendaDAO.recuperarTodos());
    }    
    
    public Integer getIdClienteSelecionado() {
        return idClienteSelecionado;
    }

    public void setIdClienteSelecionado(Integer idClienteSelecionado) {
        this.idClienteSelecionado = idClienteSelecionado;
    }

    
    
    public Cliente getCliente() {

        if (cliente == null) {
            cliente = new Cliente();
        }

        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venda getVenda() {

        if (venda == null) {
            venda = new Venda();
        }

        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ListDataModel getVendas() {
        return vendas;
    }

    public void setVendas(ListDataModel vendas) {
        this.vendas = vendas;
    }

    public String salvar() {
        vendaDAO = new VendaDAO();
        cliente = new Cliente();
        Date data = new Date (vencimento);
        venda.setVencimento(data);
        cliente.setIdCliente(idClienteSelecionado);
        this.venda.setCliente(cliente);
        vendaDAO.salvar(venda);

        return "/VendaListar";
    }
    
    public String alterar() {
        vendaDAO = new VendaDAO();
        cliente = new Cliente();
        cliente.setIdCliente(idClienteSelecionado);
        this.venda.setCliente(cliente);
        vendaDAO.alterar(venda);
        return "/VendaListar";
    }    
    
    
    public String excluir() {
        vendaDAO = new VendaDAO();
        cliente = new Cliente();
        cliente.setIdCliente(idClienteSelecionado);
        this.venda.setCliente(cliente);
        vendaDAO.excluir(venda);
        return "/VendaListar";
    }        

    public SelectItem[] getClientes() {
        DAO.ClienteDAO clienteDAO = new DAO.ClienteDAO();
        List<Cliente> clientesCadastrados = clienteDAO.recuperarTodos();
        SelectItem[] clientes = new SelectItem[clientesCadastrados.size()];
        Integer i = 0;
        for (Cliente cliente : clientesCadastrados) {
            clientes[i++] = new SelectItem(cliente.getIdCliente(), cliente.getNome());
        }
        return clientes;
    }

    public String montarSalvar() {
        venda = null;
        idClienteSelecionado = 0;
        return "/VendaSalvar";
    }
    
    public String montarAlterar(){
        this.venda = (Venda) getVendas().getRowData();
        this.setIdClienteSelecionado(this.venda.getCliente().getIdCliente());
        return "/VendaAlterar";
    }
    
    public String montarExcluir(){
        this.venda = (Venda) getVendas().getRowData();
        this.setIdClienteSelecionado(this.venda.getCliente().getIdCliente());
        return "/VendaExcluir";
    }    

}
