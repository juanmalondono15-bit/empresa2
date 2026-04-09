package org.example;

import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n1. Agregar empleado planta");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Mostrar nómina total");
            System.out.println("4. Mostrar resumen pagos");
            System.out.println("0. Salir");

            op = sc.nextInt();

            switch (op) {
                case 1 -> {
                    empresa.agregarEmpleado(new EmpleadoPLanta(
                            "Juan", "123", 25, 2000000,
                            CategoriaEmpleado.JUNIOR, 4, 4,
                            "Dev", 10, 5000, 200000
                    ));
                }
                case 2 -> empresa.mostrarEmpleados();
                case 3 -> System.out.println("Nómina: " + empresa.nominaTotal());
                case 4 -> empresa.mostrarResumenes();
            }

        } while (op != 0);
    }
}
