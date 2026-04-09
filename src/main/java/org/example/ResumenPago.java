package org.example;

public record ResumenPago(
        String documento,
        String nombre,
        String tipoEmpleado,
        double salarioBruto,
        double descuentos,
        double salarioNeto
) {}