package Entidades;

import Entidades.Compra;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T21:58:33")
@StaticMetamodel(Fornecedor.class)
public class Fornecedor_ { 

    public static volatile SingularAttribute<Fornecedor, Integer> idFornecedor;
    public static volatile CollectionAttribute<Fornecedor, Compra> compraCollection;
    public static volatile SingularAttribute<Fornecedor, String> nome;
    public static volatile SingularAttribute<Fornecedor, Integer> cnpj;

}