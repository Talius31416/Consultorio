package Java.Principiantes;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Consultorio consultorio = new Consultorio();
        String opciones[] = {"Crear Paciente", "Editar paciente", "Mostrar Paciente", "Crear Odontologo", "Mostrar odontologo", "Editar odontologo", "eliminar odontologo", "Salir"};
        boolean salida = false;
        while(!salida){
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Lista de Opciones",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch(seleccion){
                case 0 -> JOptionPane.showMessageDialog(null, consultorio.crearPaciente(ingresarTexto("Ingrese el nombre del paciente: "),
                        ingresarNumero("Ingrese la edad del paciente: "),
                        ingresarTexto("Ingrese el numero de telefono del paciente: "),
                        ingresarTexto("Ingrese el direccion del paciente: "),
                        ingresarFecha(),
                        ingresarNumero("Ingrese el numero del historico del paciente: ")));
                case 1 -> JOptionPane.showMessageDialog(null, consultorio.editarPaciente(ingresarTexto("Ingrese el nombre del paciente: "),
                        ingresarNumero("Ingrese la edad del paciente: "),
                        ingresarTexto("Ingrese el numero de telefono del paciente: "),
                        ingresarTexto("Ingrese el direccion del paciente: "),
                        ingresarFecha(),
                        ingresarNumero("Ingrese el numero del historico del paciente: ")));
                case 2 -> JOptionPane.showMessageDialog(null, consultorio.mostrarRegistroPaciente(ingresarNumero("ingrese el numero de historico del paciente: ")));
                case 3 -> JOptionPane.showMessageDialog(null, consultorio.crearOdontologo(ingresarTexto("Ingrese el ID del odontologo: "),
                        ingresarTexto("Ingrese el nombre del odontologo: "),
                        ingresarTexto("Ingrese el numero de la licencia profecional del odontologo: "),
                        ingresarEspecialidadOdontologica("Ingrese la especialidad odontologica: ")));
                case 4 -> JOptionPane.showMessageDialog(null, consultorio.mostrarOdontologo(ingresarTexto("Ingrese el ID del odontologo: ")));
                case 5 -> JOptionPane.showMessageDialog(null, consultorio.editarOdontologo(ingresarTexto("Ingrese el ID del odontologo: "),
                        ingresarTexto("Ingrese el nombre del odontologo: "),
                        ingresarTexto("Ingrese el numero de la licencia profecional del odontologo: "),
                        ingresarEspecialidadOdontologica("Ingrese la especialidad odontologica: ")));
                case 6 -> JOptionPane.showMessageDialog(null, consultorio.eliminarOdontologo(ingresarTexto("Ingrese el ID del odontologo: ")));
                case 7 -> salida = true;
            }
        }
    }
    public static String ingresarTexto(String textoAMostrar) {
        String texto = "";
        boolean salida = false;
        while (!salida) {
            texto = JOptionPane.showInputDialog(null, textoAMostrar);
            if(texto.isBlank()){
                JOptionPane.showMessageDialog(null, "Ingrese un texto");
            }else{
                salida = true;
            }
        }
        return texto;
    }
    public static int ingresarNumero(String textoAMostrar) {
        int numero = 0;
        boolean salida = false;
        while (!salida) {
            try{
                numero = Integer.parseInt(JOptionPane.showInputDialog(null, textoAMostrar));
                if(numero < 0){
                    JOptionPane.showMessageDialog(null, "Ingrese un numero valido");
                }
                salida = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un numero");
            }
        }
        return numero;
    }
    public static LocalDate ingresarFecha() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = null;
        while (fecha == null) {
            try {
                String fechaString = JOptionPane.showInputDialog("Ingrese fecha (yyyy-MM-dd):");
                fecha = LocalDate.parse(fechaString, formatter);
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "Formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return fecha;
    }
    public static EspecialidadOdontologica ingresarEspecialidadOdontologica(String textoAMostrar) {
        EspecialidadOdontologica especialidadOdontologica = null;
        boolean salida = false;
        while (!salida) {
            try{
                especialidadOdontologica = EspecialidadOdontologica.valueOf(JOptionPane.showInputDialog(null, textoAMostrar).toUpperCase());
                salida = true;
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Formato incorrecto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return especialidadOdontologica;
    }
}