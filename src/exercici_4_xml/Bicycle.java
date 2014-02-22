package exercici_4_xml;

import java.util.Arrays;
import java.util.TreeSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Bicycle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bicycle{
    
    private static final TreeSet dimensions=new TreeSet(Arrays.asList(new Double[]{10.0, 16.0, 20.0, 26.0, 27.5, 29.0}));

    @XmlElement(name="marca")
    private String marca;

    @XmlElement(name="model")
    private String model;

    @XmlElement(name="num_suspensions")
    private int num_suspensions;

    @XmlElement(name="dim_rodes")
    private double dim_rodes;

    public Bicycle(String marca, String model, int num_suspensions, double dim_rodes) {
        this.marca = marca;
        this.model = model;
        this.num_suspensions = num_suspensions;
        this.dim_rodes = dim_rodes;
    }

    public Bicycle(){

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNum_suspensions() {
        return num_suspensions;
    }

    public boolean setNum_suspensions(int num_suspensions) {
        if(num_suspensions>=0 && num_suspensions<3)
            this.num_suspensions = num_suspensions;
        else return false;
        return true;
    }

    public double getDim_rodes() {
        return dim_rodes;
    }

    public boolean setDim_rodes(double dim_rodes) {
        if(dimensions.contains(dim_rodes))
            this.dim_rodes = dim_rodes;
        else return false;
        return true;
    }

     public String toString() {
                  StringBuffer sb = new StringBuffer();

                  sb.append("Marca: " + getMarca());
                  sb.append(", ");
                  sb.append("Model: " + getModel());
                  sb.append(", ");
                  sb.append("Nº suspensions: " + getNum_suspensions());
                  sb.append(", ");
                  sb.append("Dimensió rodes: " + getDim_rodes());
                  sb.append(".");

                  return sb.toString();
       }

    }
    
 

