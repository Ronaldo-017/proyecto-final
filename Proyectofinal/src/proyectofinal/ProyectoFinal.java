/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ronaldo
 */
public class ProyectoFinal {

    public static class Usuario {
        private String nombre;
        private String contrasena;

        public Usuario(String nombre, String contrasena) {
            this.nombre = nombre;
            this.contrasena = contrasena;
        }

        public String getNombre() {
            return nombre;
        }

        public boolean verificarContrasena(String contrasena) {
            return this.contrasena.equals(contrasena);
        }
    }

    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al sistema de votaciones");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Selecciona una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre de usuario: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String nuevaContrasena = scanner.nextLine();

                    Usuario nuevoUsuario = new Usuario(nuevoNombre, nuevaContrasena);
                    usuarios.add(nuevoUsuario);
                    System.out.println("Usuario registrado con éxito.");
                    break;
                case 2:
                    System.out.print("Nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenaUsuario = scanner.nextLine();

                    boolean usuarioEncontrado = false;
                    for (Usuario usuario : usuarios) {
                        if (usuario.getNombre().equals(nombreUsuario) && usuario.verificarContrasena(contrasenaUsuario)) {
                            System.out.println("Inicio de sesión exitoso. Ahora puedes votar.");
                            usuarioEncontrado = true;
                            break;
                        }
                    }

                    if (!usuarioEncontrado) {
                        System.out.println("Inicio de sesión fallido. Verifica tus credenciales.");
                    }
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema de votaciones.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
}
