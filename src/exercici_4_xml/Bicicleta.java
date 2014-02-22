package exercici_4_xml;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Bicicleta")
public class Bicicleta{
   
   
    @XmlElement(name = "Bicycle")
    private ArrayList<Bicycle> bList;

    public ArrayList<Bicycle> getbeList() {
        return bList;
    }

   

    public void setbList(ArrayList<Bicycle> bList) {
        this.bList = bList;
    }

  
        
}
    
    

