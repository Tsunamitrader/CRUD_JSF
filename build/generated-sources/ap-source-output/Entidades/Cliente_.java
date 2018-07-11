package Entidades;

import Entidades.Venda;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T21:58:33")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Integer> cpf;
    public static volatile SingularAttribute<Cliente, String> nome;
    public static volatile CollectionAttribute<Cliente, Venda> vendaCollection;

}