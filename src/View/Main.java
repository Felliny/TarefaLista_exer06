package View;

import Controller.ModificacaoCadastroController;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ModificacaoCadastroController p =new ModificacaoCadastroController();


        try {
            p.novoCadastro(41, 60, 8000.00);
            p.novoCadastro(31, 40, 5000.00);
            p.novoCadastro(21, 30, 3000.00);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
