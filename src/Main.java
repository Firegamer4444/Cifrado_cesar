import java.util.Scanner;

public class Main {

    /**
     * metodo que construye el texto cifrado usando el metodo auxiliar "cifradoCesar" por cada caracter del texto pasado por parametro
     * @param texto texto que se quiere cifrar
     * @param claveCifrado clave para hacer el cifrado cesar
     * @return
     */
    public static String cifradoTexto(String texto , int claveCifrado) {
        String textoCifrado = "";
        for (int i = 0 ; i < texto.length() ; i++){
            int caracter = (int) texto.charAt(i);
            // si el caracter es un ñ o Ñ se trata como si fuese una n o N respectivamente
            if (caracter == 164){
                caracter = 110;
            }
            if (caracter == 165){
                caracter = 78;
            }
            // si el caracter no es un caracter alfabetico , no se le aplica el cifrado
            if ((caracter < 65 | caracter > 90) && (caracter < 97 | caracter > 122)){
                textoCifrado += (char) caracter;
            }
            else{
                textoCifrado += (char) cifradoCesar(caracter, claveCifrado);
            }
        }
        return textoCifrado;
    }

    /**
     * metodo que cifra el caracter usando el cifrado cesar usando la clave pasada por parametro
     * @param caracter caracter que se va a cifrar
     * @param claveCifrado clave para hacer el cifrado cesar
     * @return
     */
    public static int cifradoCesar(int caracter , int claveCifrado) {
        int limiteMaximo;
        // si el caracter es mayuscula o minuscula se establece el limite que tienen los caracteres mayuscula o minuscula en ascii respectivamente
        if (caracter < 90){
            limiteMaximo = 90;
        }
        else{
            limiteMaximo = 122;
        }
        caracter += claveCifrado;
        // mientras el caracter este por encima del limite, se le resta 26 para evitar que se desborde
        while (caracter > limiteMaximo){
            caracter -= 26;
        }
        return caracter;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el texto que quieres cifrar: ");
        String texto = scanner.nextLine();
        System.out.println("Introduzca la clave para cifrar el texto: ");
        int claveCifrado = scanner.nextInt();
        System.out.println("Texto cifrado: " + cifradoTexto(texto, claveCifrado));
    }
}
