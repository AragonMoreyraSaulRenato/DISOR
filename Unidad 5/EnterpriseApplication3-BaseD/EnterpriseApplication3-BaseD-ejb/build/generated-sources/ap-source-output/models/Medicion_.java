package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Actividad;
import models.Persona;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-31T10:03:05")
@StaticMetamodel(Medicion.class)
public class Medicion_ { 

    public static volatile SingularAttribute<Medicion, Date> fecha;
    public static volatile SingularAttribute<Medicion, Actividad> idAct;
    public static volatile SingularAttribute<Medicion, Integer> cintura;
    public static volatile SingularAttribute<Medicion, Double> peso;
    public static volatile SingularAttribute<Medicion, Integer> idMedicion;
    public static volatile SingularAttribute<Medicion, Integer> cadera;
    public static volatile SingularAttribute<Medicion, Persona> idPersona;

}