package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void mostrarEmpleados() {
        empleados.forEach(Empleado::mostrarInformacion);
    }

    public Empleado buscarPorDocumento(String doc) {
        return empleados.stream()
                .filter(e -> e.getDocumento().equals(doc))
                .findFirst()
                .orElse(null);
    }

    public Empleado mayorSalario() {
        return empleados.stream()
                .max((a, b) -> Double.compare(a.calcularSalarioNeto(), b.calcularSalarioNeto()))
                .orElse(null);
    }

    public double nominaTotal() {
        return empleados.stream()
                .mapToDouble(Empleado::calcularSalarioNeto)
                .sum();
    }

    public void mostrarResumenes() {
        empleados.forEach(e -> System.out.println(e.generarResumenPago()));
    }
}