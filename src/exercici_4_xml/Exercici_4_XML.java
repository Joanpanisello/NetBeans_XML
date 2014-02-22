package exercici_4_xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Exercici_4_XML {

    private static final ArrayList<Bicycle> bList1 = new ArrayList<>();
    
    public static void main(String[] args) throws JAXBException, FileNotFoundException, IOException {
       
       Exercici_4_XML handler = new Exercici_4_XML();
       JAXBContext context = JAXBContext.newInstance(Bicicleta.class);
       Unmarshaller um = context.createUnmarshaller();
       Bicicleta bicicleta2 = (Bicicleta) um.unmarshal(new FileReader("bicis.xml"));
       ArrayList<Bicycle> list = bicicleta2.getbeList();
       for(Bicycle bicycle : list){
           bList1.add(bicycle);
       } 
       BufferedReader br = new BufferedReader (new InputStreamReader(System.in));            
       int opcio=0;
       Bicycle b2, b3;
       String marca, auxMarca;
       String model, auxModel;
       int num_suspensions=0, auxSuspensions;
       double dim_rodes=0;
       boolean valida=true;
       int modificar=0, eliminar=0;
        
        
       do{
                System.out.println("---------------------------------------");
                System.out.println("\nTria una opció:\n\n"
                                   + "1. Llistar Bicicletes.\n"
                                   + "2. Afegir Bicicleta.\n"
                                   + "3. Modificar Bicicleta.\n"
                                   + "4. Eliminar Bicicleta.\n"
                                   + "5. Crear el fitxer XML i sortir.\n");
                try{
                    opcio=Integer.parseInt(br.readLine().trim());
                }catch(NumberFormatException e){
                     System.out.println("\nOpció no vàlida!\n");
                     valida=false;

                }
                if(opcio<1 || opcio>5){

                    if(valida)System.out.println("\nLa opció no existeix!\n");                       

                }else{

                    switch(opcio){

                        case 1:                     // Opció llistar bicicletes

                                handler.readList();
                                break; 

                        case 2:                     // Opció crear bicicleta  

                              System.out.println("\nMarca: ");
                                marca=br.readLine().trim();
                                if(marca.equals("")){
                                    System.out.println("\nHas d'introduïr la marca!.");
                                    break;
                                }
                                System.out.println("Model: ");
                                model=br.readLine().trim();
                                if(model.equals("")){
                                    System.out.println("\nHas d'introduïr el model!");
                                    break;
                                }
                                System.out.println("Nº suspensions (disponibles: 1, 2): ");
                                try{
                                    num_suspensions=Integer.parseInt(br.readLine().trim());
                                }catch(NumberFormatException e){
                                    System.out.println("\nHas d'introduïr un número de suspensions vàlid!");
                                    break;
                                }
                                if(num_suspensions<=0|(num_suspensions!=1&num_suspensions!=2)){
                                    System.out.println("\nHas d'introduïr un número de suspensions vàlid!");
                                    break;
                                }
                                System.out.println("Dimensió rodes (disponibles: 10.0, 16.0, 20.0, 26.0, 27.5, 29.0): ");
                                try{
                                    dim_rodes=Double.parseDouble(br.readLine().trim());
                                }catch(NumberFormatException e){
                                    System.out.println("\nHas d'introduïr una dimensió vàlida!");
                                    break;
                                }
                                if(dim_rodes<=0|(dim_rodes!=10.0&dim_rodes!=16.0&dim_rodes!=20.0&dim_rodes!=26.0&dim_rodes!=27.5&dim_rodes!=29.0)){
                                    System.out.println("\nHas d'introduïr una dimensió vàlida!");
                                    break;
                                }else{
                                    b2 = new Bicycle(marca, model, num_suspensions, dim_rodes);
                                    bList1.add(b2);
                                    num_suspensions=0;
                                    dim_rodes=0;
                                    marca="";
                                    model="";
                                    System.out.println("\nBicicleta afegida correctament!");
                                }
                                break;

                        case 3:                     // Opció modificar bicicleta

                               handler.readList();
                                System.out.println("\nQuina bicicleta vols modificar?");
                                try{
                                    modificar=Integer.parseInt(br.readLine().trim());
                                }catch(NumberFormatException e){
                                    System.out.println("\nLa opció no és vàlida!");
                                    break;
                                }
                                modificar--;
                                if(modificar<0|modificar>=bList1.size()){
                                    System.out.println("\nLa bicicleta no existeix!"); 
                                }else{
                                    b3=bList1.get(modificar);
                                    System.out.println("\nMarca (actual: "+b3.getMarca()+"):");
                                    marca=br.readLine().trim();
                                    auxMarca=b3.getMarca();
                                    if(marca.equals("")){
                                        System.out.println("\nHas d'introduïr la marca!.");
                                        break;
                                    }else b3.setMarca(marca);   
                                    System.out.println("Model (actual: "+b3.getModel()+"):");
                                    model=br.readLine().trim();
                                    auxModel = b3.getModel();
                                    if(model.equals("")){
                                         b3.setMarca(auxMarca);
                                         System.out.println("\nHas d'introduïr el model!");
                                         break;
                                    }else b3.setModel(model);
                                    System.out.println("Nº suspensions (actual: "+b3.getNum_suspensions()+", disponibles 1, 2):");
                                    try{
                                        num_suspensions=Integer.parseInt(br.readLine().trim());
                                        auxSuspensions=b3.getNum_suspensions();
                                    }catch(NumberFormatException e){
                                        b3.setMarca(auxMarca); 
                                        b3.setModel(auxModel);
                                        System.out.println("\nHas d'introduïr un número de suspensions vàlid!");
                                        break;
                                    }
                                    if(num_suspensions<=0|(num_suspensions!=1&num_suspensions!=2)){
                                        b3.setMarca(auxMarca); 
                                        b3.setModel(auxModel);
                                        System.out.println("\nHas d'introduïr un número de suspensions vàlid!");
                                        break;
                                    }else b3.setNum_suspensions(num_suspensions);                                     
                                    System.out.println("Dimensió rodes (actual: "+b3.getDim_rodes()+", disponibles: 10.0, 16.0, 20.0, 26.0, 27.5, 29.0):");
                                    try{
                                        dim_rodes=Double.parseDouble(br.readLine().trim());
                                    }catch(NumberFormatException e){
                                        b3.setMarca(auxMarca); 
                                        b3.setModel(auxModel);
                                        b3.setNum_suspensions(auxSuspensions);
                                        System.out.println("\nHas d'introduïr una dimensió vàlida!");
                                        break;
                                    }
                                    if(dim_rodes<=0|(dim_rodes!=10.0&dim_rodes!=16.0&dim_rodes!=20.0&dim_rodes!=26.0&dim_rodes!=27.5&dim_rodes!=29.0)){
                                         b3.setMarca(auxMarca); 
                                         b3.setModel(auxModel);
                                         b3.setNum_suspensions(auxSuspensions);
                                         System.out.println("\nHas d'introduïr una dimensió vàlida!");
                                         break; 
                                    }else{
                                        b3.setDim_rodes(dim_rodes);
                                        System.out.println("\nBicicleta modificada correctament!");
                                    }
                                }
                                break;

                        case 4:                     // Opció eliminar bicicleta

                                handler.readList();
                                System.out.println("\nQuina bicicleta vols eliminar?");

                                try{
                                    eliminar=Integer.parseInt(br.readLine().trim());
                                }catch(NumberFormatException e){
                                    System.out.println("\nLa opció no és vàlida!");
                                    break;
                                }
                                eliminar--;
                                if(eliminar<0|eliminar>=bList1.size()){
                                    System.out.println("\nLa bicicleta no existeix!");
                                }else{
                                    bList1.remove(eliminar);
                                    System.out.println("\nBicicleta "+(eliminar+1)+" eliminada!");
                                }
                                break;

                        case 5:                     // Opció crear XML i sortir

                            Bicicleta bicicleta = new Bicicleta();
                            bicicleta.setbList(bList1);
                            Marshaller m = context.createMarshaller();
                            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                            m.marshal(bicicleta, new File("final3.xml"));
                            
                            break;
                    }  
                }
                valida=true;
        }while(opcio!=5); 
    }
    
    private void readList() {
        
              System.out.println("Llistat de bicicletes: \n" );
              Iterator<Bicycle> it = bList1.iterator();
              int i=1;
              while (it.hasNext()) {
                     System.out.println(i+" "+it.next().toString());
                     i++;
              }
              System.out.println("\nEn aquest moment hi ha " + bList1.size()  + " bicicleta(es).\n");
       } 
}   

