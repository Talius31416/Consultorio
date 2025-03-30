package Java.Principiantes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Consultorio {
    ArrayList<RegistroPaciente> RegistroPacientes = new ArrayList<>();
    ArrayList<Odontologo> odontologos = new ArrayList<>();
    ArrayList<RegistroPaciente> citasGratis = new ArrayList<>();
    
    public String crearPaciente(String nombre, int edad, String telefono, String direccion, LocalDate ultimaConsulta, int numeroHistoricoPaciente){
        String texto = "El paciente fue creado con exito";
        for(RegistroPaciente registroPacientesAux : RegistroPacientes){
            if(registroPacientesAux.getNumeroHistoricoPaciente() == numeroHistoricoPaciente){
                return "El paciente ya existe";
            }
        }
        Paciente paciente = new Paciente(nombre, edad, telefono, direccion, ultimaConsulta, numeroHistoricoPaciente);
        RegistroPaciente registroPaciente = new RegistroPaciente(numeroHistoricoPaciente);
        registroPaciente.setRegistroPaciente(paciente);
        RegistroPacientes.add(registroPaciente);
        return texto;
    }
    public String editarPaciente(String nombre, int edad, String telefono, String direccion, LocalDate ultimaConsulta, int numeroHistoricoPaciente){
        String texto = "El paciente fue editado con exito";
        RegistroPaciente aux = null;
        for(RegistroPaciente registroPacienteAux : RegistroPacientes){
            if(registroPacienteAux.getNumeroHistoricoPaciente() == numeroHistoricoPaciente){
                aux = registroPacienteAux;
            }
        }
        if(aux == null){
            return "El paciente no existe";
        }
        Paciente paciente = new Paciente(nombre, edad, telefono, direccion, ultimaConsulta, numeroHistoricoPaciente);
        aux.setRegistroPaciente(paciente);
        return texto;
    }
    public String mostrarRegistroPaciente(int historicoMedico){
        String texto = "";
        for(RegistroPaciente registroPacienteAux : RegistroPacientes){
            if(registroPacienteAux.getNumeroHistoricoPaciente() == historicoMedico){
                for(Paciente pacienteAux : registroPacienteAux.getRegistroPaciente()){
                    texto += pacienteAux.toString()+"\n";
                }
            }
        }
        if(texto.equals("")){
            return "El paciente no existe";
        }
        return texto;
    }
    public String crearOdontologo(String ID, String nombre, String licenciaProfesional, EspecialidadOdontologica espOdontologica){
        String texto = "El Odontologo fue creado con exito";
        for(Odontologo odontologoAux : odontologos){
            if(Objects.equals(odontologoAux.getID(), ID)){
                return "El odontologo ya existe";
            }
        }
        Odontologo odontologo = new Odontologo(ID, nombre, licenciaProfesional, espOdontologica);
        odontologos.add(odontologo);
        return texto;
    }
    public String mostrarOdontologo(String ID){
        String texto = "No se encontro el odontologo";
        for(Odontologo odontologoAux : odontologos){
            if(odontologoAux.getID().equals(ID)){
                return odontologoAux.odontologoToString();
            }
        }
        return texto;
    }
    public String editarOdontologo(String ID, String nombre, String licenciProfesionalq, EspecialidadOdontologica espOdontologica){
        String texto = "El odontologo fue editado con exito";
        Odontologo aux = null;
        for(Odontologo odontologoAux : odontologos){
            if(odontologoAux.getID().equals(ID)){
                aux = odontologoAux;
            }
        }
        if(aux == null){
            return "El odontologo no existe";
        }
        aux.setNombre(nombre);
        aux.setLicenciaProfesional(licenciProfesionalq);
        aux.setEspecialidadOdontologica(espOdontologica);
        aux.setID(ID);
        return texto;
    }
    public String eliminarOdontologo(String ID){
        String texto = "El odontologo fue eliminado con exito";
        Odontologo aux = null;
        for(Odontologo odontologoAux : odontologos){
            if(odontologoAux.getID().equals(ID)){
                aux = odontologoAux;
            }
        }
        if(aux == null){
            return "El odontologo no existe";
        }
        odontologos.remove(aux);
        return texto;
    }
    public void pacientesCitasGratis(){
        for(RegistroPaciente registroPacienteAux : RegistroPacientes){
            if(registroPacienteAux.getRegistroPaciente().size() >= 5){
                citasGratis.add(registroPacienteAux);
            }
        }
    }
}
