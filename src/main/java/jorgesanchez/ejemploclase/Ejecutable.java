/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jorgesanchez.ejemploclase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorog
 */
public class Ejecutable {
    
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("ddbb.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);;
            Contacto c1 = new Contacto("Pepe","123");
            Contacto c2 = new Contacto("Maria","556");
            List<Contacto> oro= new ArrayList();
            oro.add(c1); oro.add(c2);
            oos.writeObject(oro);
            oos.close();
            fos.close();
            
            FileInputStream fis = new FileInputStream("ddbb.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<Contacto> contactosLeidos=(List<Contacto>)ois.readObject();
            System.out.println(contactosLeidos);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
}
