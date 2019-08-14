package jwapahorcado.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jwapahorcado.model.Palabra;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-11T21:03:19")
@StaticMetamodel(Tipo.class)
public class Tipo_ { 

    public static volatile SingularAttribute<Tipo, String> descripcion;
    public static volatile SingularAttribute<Tipo, Integer> idTipo;
    public static volatile CollectionAttribute<Tipo, Palabra> palabraCollection;

}