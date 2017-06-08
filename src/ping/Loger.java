package ping;

import modelo.model;
import java.io.File;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Loger {
    
    Loger() {

    }
    public void Gravar(ArrayList<model> list){ 
    String conteudo = ""; 
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    String d = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(tm);
    try{  
        // o true significa q o arquivo será constante  
        FileWriter x = new FileWriter(new File("C:\\Users\\Gustavo\\Desktop\\"+d+".txt"));
        //FileWriter x = new FileWriter(new File("C:\\Users\\oficina\\Desktop\\"+d+".txt"));
        //"C:\\Users\\oficina\\Desktop",true
        for(model sate : list) {
            conteudo = sate.getIp()+" - " +sate.getHost();
            conteudo = conteudo + "    \n\r"; // criando nova linha e recuo no arquivo
            x.write(conteudo); // armazena o texto no objeto x, que aponta para o arquivo
            }
            x.close(); // cria o arquivo
        }  
    // em caso de erro apreenta mensagem abaixo
    catch(Exception e){  
    }  
} 
    
    public void Gravar(String list){ 
    String conteudo = ""; 
    Timestamp tm = new Timestamp(System.currentTimeMillis());
    String d = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss").format(tm);
    try{  
        // o true significa q o arquivo será constante  
        FileWriter x = new FileWriter(new File("C:\\Users\\Gustavo\\Desktop\\"+d+".txt"));
        //FileWriter x = new FileWriter(new File("C:\\Users\\oficina\\Desktop\\"+d+".txt"));
        //"C:\\Users\\oficina\\Desktop",true
            conteudo = list + "    \n\r"; // criando nova linha e recuo no arquivo
            x.write(conteudo); // armazena o texto no objeto x, que aponta para o arquivo
            x.close(); // cria o arquivo
        }  
    // em caso de erro apreenta mensagem abaixo
    catch(Exception e){  
    }  
} 

}
