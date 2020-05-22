import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Criptografa {

        public static String lerMensagem () {
            // achar arquivo SecretMessage
            File file = new File("SecretMessage.txt");
            FileReader fileReader = null;

            // adicionar ele a um novo file
            try {
                fileReader = new FileReader(file);
            }

            // caso arquivo não for encontrado
            catch (java.io.FileNotFoundException e) {
                System.out.println("Arquivo não encontrado!");
            }

            // escrever arquivo
            Scanner in = new Scanner(fileReader);

            // continuar linha x linha e retornar STRING
            String msg = "";
            while (in.hasNextLine()) {
                String line = in.nextLine();
                msg += line;
            }
            return msg;
        }

        // lista de posições e letras (array)
        private char[] listCriptogafa = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
                'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.', ',', ';', '!', '?'};

        private char[] criptografaMensagem;

        // chave
        private int key = 15;


    public Criptografa() {
            this.criptografaMensagem = lerMensagem().toUpperCase().toCharArray();
        }

        public String descriptografar () {
            //pegar lista de caracteres (mensagem)
            char[] listaDeCaracteres = this.listaCaracteres();

            //adicionar eles a um array
            ArrayList<Character> listaDeCaracteresDescriptografados = new ArrayList<Character>();
            String stringCaracteres = new String(this.listCriptogafa);

            // percorrendo o array
            for (char c : listaDeCaracteres) {
                // deixar em letra maiuscula caso nao houver
                char letraMaiuscula = Character.toUpperCase(c);
                // posição da letra, ex: A = 0
                int posicaoLetra = stringCaracteres.indexOf(letraMaiuscula);
                // adicionando a chave na posição da letra EERROO
                int indiceLetraDescriptografada = posicaoLetra + key;
                indiceLetraDescriptografada = indiceLetraDescriptografada % 31;
                // letra descriptografada
                char letraDescriptografada = stringCaracteres.charAt(indiceLetraDescriptografada);
            } // fim for



            char[] arrayCaracteres = new char[listaDeCaracteresDescriptografados.size()];
            return new String(String.valueOf(listaDeCaracteresDescriptografados));

        }

        private char[] listaCaracteres () {
            return this.criptografaMensagem;
        }

        private int cont ( int i){
           int cont = Math.abs(30 + (i - key));
            while (cont > 30) {
                cont = Math.abs(cont - 30);
            }
            return cont;
        }



}