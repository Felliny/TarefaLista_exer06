package Controller;

import Biblioteca.ListaObject.Lista;
import Model.Cliente;

import javax.imageio.IIOException;
import java.io.*;

public class ModificacaoCadastroController {

    public ModificacaoCadastroController(){
        super();
    }

    private void novoArquivo(Lista l, String nomeArquivo) throws IOException {
        File dir= new File("D:\\TEMP");
        File file= new File("D:\\TEMP", nomeArquivo);
        if (dir.exists() && dir.isDirectory()){
            String Cadastro= "";
            StringBuffer buffer= new StringBuffer(Cadastro);
            boolean existe= false;
            if (file.exists()){
                existe= true;
            }
            while (!l.isEmpty()) {
                try {
                    Cliente cliente= (Cliente) l.get(0);
                    Cadastro= String.valueOf(buffer.append(cliente.getCPF() +";"+ cliente.getNome() +";"+ cliente.getIdade() +";"+ cliente.getLimiteCredito() +"\n"));
                    l.removeFirst();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            FileWriter fileWriter= new FileWriter(file, existe);
            PrintWriter print= new PrintWriter(fileWriter);
            print.write(String.valueOf(Cadastro));
            print.flush();
            print.close();
            fileWriter.close();
        }
        else {
            throw new IOException("Diretório Inválido!");
        }

    }


    public void novoCadastro(int idadeMin, int idadeMax, double limiteCredito) throws IOException{
        File file= new File("D:\\TEMP", "cadastro.csv");
        Lista l =new Lista();
        if (file.exists() && file.isFile()){
            FileInputStream fluxo= new FileInputStream(file);
            InputStreamReader leitor= new InputStreamReader(fluxo);
            BufferedReader buffer= new BufferedReader(leitor);
            String linha= buffer.readLine();
            String[] vet=linha.split(";");
            vet[3]= vet[3].replaceAll(",", ".");
            while (linha != null){
                if (Integer.parseInt(vet[2]) >= idadeMin && Integer.parseInt(vet[2]) <= idadeMax && Double.parseDouble(vet[3]) > limiteCredito){
                    l.addFirst(new Cliente(vet[0], vet[1], Integer.parseInt(vet[2]), Double.parseDouble(vet[3])));
                }
                linha= buffer.readLine();
                if (linha != null){
                    vet=linha.split(";");
                    vet[3]= vet[3].replaceAll(",", ".");
                }
            }
            novoArquivo(l, "Idade "+ vet[2] +" Limite "+ vet[3] +".csv");
            buffer.close();
            fluxo.close();
            leitor.close();
        }
        else {
            throw new IOException("Arquivo Inválido!");
        }

    }
}
