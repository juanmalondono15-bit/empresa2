package org.example;

public class EmpleadoVentas extends Empleado {
    private double totalVentas;
    private double porcentajeComision;

    public EmpleadoVentas(String nombre, String documento, int edad, double salarioBase,
                          CategoriaEmpleado categoria, double descuentoSalud, double descuentoPension,
                          double totalVentas, double porcentajeComision) {

        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);

        if (porcentajeComision < 0 || porcentajeComision > 100)
            throw new IllegalArgumentException("Comisión inválida");

        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public double calcularSalarioBruto() {
        double comision = totalVentas * porcentajeComision / 100;
        return salarioBase + calcularBonificacionCategoria() + comision;
    }
}
