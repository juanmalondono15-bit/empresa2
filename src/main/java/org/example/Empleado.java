package org.example;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected double salarioBase;
    protected CategoriaEmpleado categoria;
    protected double descuentoSalud;
    protected double descuentoPension;

    public Empleado(String nombre, String documento, int edad, double salarioBase,
                    CategoriaEmpleado categoria, double descuentoSalud, double descuentoPension) {

        if (salarioBase < 0) throw new IllegalArgumentException("Salario base inválido");
        if (descuentoSalud < 0 || descuentoSalud > 100) throw new IllegalArgumentException("Salud inválida");
        if (descuentoPension < 0 || descuentoPension > 100) throw new IllegalArgumentException("Pensión inválida");

        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.descuentoSalud = descuentoSalud;
        this.descuentoPension = descuentoPension;
    }

    public abstract double calcularSalarioBruto();

    public double calcularBonificacionCategoria() {
        return switch (categoria) {
            case JUNIOR -> salarioBase * 0.05;
            case SEMI_SENIOR -> salarioBase * 0.10;
            case SENIOR -> salarioBase * 0.15;
        };
    }

    public double calcularDescuentos() {
        double bruto = calcularSalarioBruto();
        return bruto * (descuentoSalud / 100) + bruto * (descuentoPension / 100);
    }

    public double calcularSalarioNeto() {
        return calcularSalarioBruto() - calcularDescuentos();
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
        System.out.println("Salario Neto: " + calcularSalarioNeto());
    }

    public ResumenPago generarResumenPago() {
        return new ResumenPago(documento, nombre, this.getClass().getSimpleName(),
                calcularSalarioBruto(), calcularDescuentos(), calcularSalarioNeto());
    }

    public String getDocumento() {
        return documento;
    }
}