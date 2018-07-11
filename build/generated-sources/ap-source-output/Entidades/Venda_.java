package Entidades;

import Entidades.Cliente;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-12-04T21:58:33")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, BigInteger> valor;
    public static volatile SingularAttribute<Venda, Date> vencimento;
    public static volatile SingularAttribute<Venda, Integer> idVenda;

}