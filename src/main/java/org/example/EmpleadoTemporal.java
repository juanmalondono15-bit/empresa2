package org.example;

public class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private double valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad,
                            CategoriaEmpleado categoria, double descuentoSalud, double descuentoPension,
                            int diasTrabajados, double valorDia) {

        super(nombre, documento, edad, 0, categoria, descuentoSalud, descuentoPension);

        if (diasTrabajados < 0 || valorDia < 0)
            throw new IllegalArgumentException("Datos inválidos");

        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    @Override
    public double calcularSalarioBruto() {
        double pago = diasTrabajados * valorDia;
        return pago + calcularBonificacionCategoria();
    }
}
