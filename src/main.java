/*
    Hoja de trabajo 9

    Integrantes:
    Alejandro Chaclan 15018
    Jose Javier Jo 14343

    Este programa utiliza implementaciones de SplayTree y Hash para usar un diccionario y traducir un texto
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in); //Variable para leer los datos ingresados por el usuario
        Map<String, Association<String, String>> diccionario = null;
        String linea, key, value;
        boolean respFlag = false;
        int resp = 0;

        System.out.println("Hoja de trabajo 9 \n");

        while(!respFlag) {
            System.out.println("¿Qué implementación desea utilizar?\n" +
                    "1. Splay Tree\n" +
                    "2. Hashing");

            try {
                resp = (int) teclado.nextDouble();
                if (resp == 1 || resp == 2)
                    respFlag = true;
            } catch (Exception e) {
                System.out.println("Ingrese un dato correcto");
                teclado.next();
            }
        }

        // Se utiliza la implementacion de Factory para instanciar el diccinario segun la opcion elegida por el usuario
        if (resp == 1)
            diccionario = new SplayTreeMap<>(); //Si hay varias entradas con la misma key el SplayTree guarda el primero encontrado en el archivo
        else if (resp == 2)
            diccionario = new OwnHashMap<>(); //Si hay varias entradas con la misma key el HashMap guarda todos los datos pero muestra el ultimo ingresado a la hora de buscar

        //Se trata de leer el archivo en el directorio actual, donde se encuentran los archivos .java
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\Spanish.txt"))) {

            StringBuilder sb = new StringBuilder();
            linea = br.readLine();

            //Se hace un ciclo para leer todo el archivo
            while(linea!=null) {

                //Se eliminan los separadores de linea
                sb.append(linea);

                //Se buscan en cada linea el value y key
                linea = linea.toLowerCase();
                key = "";
                value = "";
                boolean keyFlag = false;
                for (int i = 0; i < linea.length(); i++) {
                    char c = linea.charAt(i);
                    if (Character.isLetter(c)) {
                        if (!keyFlag)
                            key += c;
                        else
                            value += c;
                    } else {
                        // Se levanta la bandera si ya se tiene el valor de 'key'
                        if (!key.isEmpty())
                            keyFlag = true;
                        // Se revisan ciertos caracteres para leer las palabras traducidas
                        if (keyFlag && !value.isEmpty()) {
                            if (Character.compare(c, ' ') == 0)
                                value += c;
                            else if (Character.compare(c, ' ') != 0 && Character.compare(c, '/') != 0)
                                break;
                        }
                    }
                }

                //Se agrega la entrada al arbol
                Association<String, String> temp = new Association<>(key, value);
                System.out.println(temp);
                diccionario.put(temp.getKey(), temp);

                //Se lee una nueva linea
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\texto.txt"))) {
            //Se lee la linea de texto y se eliminan los separadores de linea
            StringBuilder sb = new StringBuilder();
            linea = br.readLine();
            sb.append(linea);

            //Se muestra en pantalla el texto sin traducir
            System.out.println("El texto sin traducir:\n" + linea);

            //Se convierten todas las letras a minusculas
            linea = linea.toLowerCase();

            //Variables para guardar la traduccion final y cada palabra leida del texto
            String traduccion = "";
            String palabra = "";
            int i = 0;

            //Ciclo que recorre todo el texto buscando palabras
            while (i < linea.length()) {
                char c = linea.charAt(i);

                //Cada vez que encuentra una letra la agrega al string
                if (Character.isLetter(c)) {
                    palabra += c;

                    //Cuando encuentra algo que no es una letra, se usa la palabra que se fue construyendo para buscarla en el diccionario y traducirla
                } else  if (palabra.length() > 0){
                    //Se busca la palabra en el diccionario
                    Association<String, String> temp = new Association<>(palabra);
                    Association<String, String> palabraTrad = diccionario.get(temp.getKey());

                    //Si no la encontro en el diccionario, deja la palabra en ingles y le agrega asteriscos
                    if (palabraTrad == null)
                        traduccion += "*" + palabra + "* ";
                        //De lo contrario, usa la palabra traducida
                    else
                        traduccion += palabraTrad.getValue() + " ";
                    palabra = "";
                }
                i++;
            }

            //Se arreglan partes del texto (Suponiendo que solo se va a ingresar una oracion para traducir)
            int cont = 0;
            while (!Character.isLetter(traduccion.charAt(cont))) {
                cont++;
            }
            traduccion = traduccion.substring(0,cont) + Character.toUpperCase(traduccion.charAt(cont)) + traduccion.substring(cont+1, traduccion.length()-1) + ".";

            //Se muestra el texto traducido
            System.out.println("El texto traducido es:\n" + traduccion);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
