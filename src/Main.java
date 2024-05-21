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
     * metodo que construye el texto descifrado usando el metodo auxiliar "descifradoCesar" por cada caracter del texto pasado por parametro
     * @param texto texto que se quiere descifrar
     * @param claveCifrado clave para hacer el cifrado cesar
     * @return
     */
    public static String descifradoTexto(String texto , int claveCifrado) {
        String textoCifrado = "";
        for (int i = 0 ; i < texto.length() ; i++){
            int caracter = (int) texto.charAt(i);
            // si el caracter no es un caracter alfabetico , no se le aplica el cifrado
            if ((caracter < 65 | caracter > 90) && (caracter < 97 | caracter > 122)){
                textoCifrado += (char) caracter;
            }
            else{
                textoCifrado += (char) descifradoCesar(caracter, claveCifrado);
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
        if (caracter <= 90){
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

    /**
     * metodo que descifra el caracter usando la clave pasada por parametro
     * @param caracter caracter que se va a descifrar
     * @param claveCifrado clave para hacer el cifrado cesar
     * @return
     */
    public static int descifradoCesar(int caracter , int claveCifrado){
        int limiteMinimo;
        // si el caracter es mayuscula o minuscula se establece el limite que tienen los caracteres mayuscula o minuscula en ascii respectivamente
        if (caracter <= 90){
            limiteMinimo = 65;
        }
        else{
            limiteMinimo = 97;
        }
        caracter -= claveCifrado;
        // mientras el caracter este por debajo del limite, se le suma 26 para evitar que se desborde
        while (caracter < limiteMinimo){
            caracter += 26;
        }
        return caracter;
    }

    public static void main(String[] args) throws Exception {
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n--- Opciones: ---");
            System.out.println("1. cifrar texto");
            System.out.println("2. descifrar texto");
            System.out.println("3. cerrar programa");
            System.out.println("Elija una opcion: ");
            String opcion = scanner.nextLine();
            if (opcion.equals("1")){
                System.out.println("Introduzca el texto que quieres cifrar: ");
                String texto = scanner.nextLine();
                System.out.println("Introduzca la clave para cifrar el texto: ");
                int claveCifrado = scanner.nextInt();
                if (claveCifrado < 0){
                    System.out.println("No se puede poner una clave negativa");
                }
                else{
                    System.out.println("Texto cifrado: " + cifradoTexto(texto, claveCifrado));
                }
            }
            if (opcion.equals("2")){
                System.out.println("Introduzca el texto que quieres descifrar: ");
                String texto = scanner.nextLine();
                System.out.println("Introduzca la clave para descifrar el texto: ");
                int claveCifrado = scanner.nextInt();
                if (claveCifrado < 0){
                    System.out.println("No se puede poner una clave negativa");
                }
                else{
                    System.out.println("Texto cifrado: " + descifradoTexto(texto, claveCifrado));
                }
            }
            if (opcion.equals("3")){
                scanner.close();
                break;
            }
        }
        
    }
}
