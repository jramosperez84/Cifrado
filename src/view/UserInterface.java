package view;

public class UserInterface {

    public static void mainMenu() {
        System.out.print(

                "\nACTIVIDAD UF1 PROGRAMACIÓN DE SERVICIOS Y PROCESOS\n\n" +
                        """
                                \t1.Cifrar mensaje
                                \t2.Descifrar mensaje
                                \t-------------------------
                                \t3.Salir\s
                                """
                        + "\nOpcion: "
        );
    }

    public static void getDocumentName() {
        System.out.print("Introduzca el nombre del documento: ");
    }

    public static void getStrText() {
        System.out.print("Introduzca el texto a codificar: ");
    }
}
