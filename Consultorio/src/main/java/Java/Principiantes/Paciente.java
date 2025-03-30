package Java.Principiantes;

import java.time.LocalDate;

public record Paciente(String nombre, int edad, String telefono, String direccion, LocalDate ultimaConsulta, int numeroHistoricoPaciente) {
}
