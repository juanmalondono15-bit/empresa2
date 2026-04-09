package org.example;

public class EmpleadoPLanta extends Empleado {
    private String cargo;
    private int horasExtra;
    private double valorHorasExtra;
    private double auxilioTransporte;

    public EmpleadoPLanta(String nombre, String documento, int edad, double salarioBase,
                          CategoriaEmpleado categoria, double descuentoSalud, double descuentoPension,
                          String cargo, int horasExtra, double valorHorasExtra, double auxilioTransporte) {

        super(nombre, documento, edad, salarioBase, categoria, descuentoSalud, descuentoPension);

        if (horasExtra < 0 || valorHorasExtra < 0) throw new IllegalArgumentException("Horas extra inválidas");

        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHorasExtra = valorHorasExtra;
        this.auxilioTransporte = auxilioTransporte;
    }

    @Override
    public double calcularSalarioBruto() {
        return salarioBase + calcularBonificacionCategoria()
                + (horasExtra * valorHorasExtra) + auxilioTransporte;
    }
}
