package Java.Principiantes;

import java.util.ArrayList;

public class RegistroPaciente {
    private int numeroHistoricoPaciente;
    private ArrayList<Paciente> registroPaciente;
    public RegistroPaciente(int numeroHistoricoPaciente) {
        this.registroPaciente = new ArrayList<>();
        this.numeroHistoricoPaciente = numeroHistoricoPaciente;
    }
    public void setRegistroPaciente(Paciente paciente) {
        registroPaciente.add(paciente);
    }
    public int getNumeroHistoricoPaciente() {
        return numeroHistoricoPaciente;
    }
    public ArrayList<Paciente> getRegistroPaciente() {
        return registroPaciente;
    }
}
