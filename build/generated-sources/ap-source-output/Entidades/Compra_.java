package Entidades;

import Entidades.Fornecedor;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T21:58:33")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Integer> idCompra;
    public static volatile SingularAttribute<Compra, BigInteger> valor;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Compra, Date> vencimento;

}