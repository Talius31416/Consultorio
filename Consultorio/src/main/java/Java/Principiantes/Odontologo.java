package Java.Principiantes;

public class Odontologo {
    private String ID;
    private String nombre;
    private String licenciaProfesional;
    EspecialidadOdontologica especialidadOdontologica;
    public Odontologo(String ID, String nombre, String licenciaProfesional, EspecialidadOdontologica espOdontologica) {
        this.ID = ID;
        this.nombre = nombre;
        this.licenciaProfesional = licenciaProfesional;
        this.especialidadOdontologica = espOdontologica;
    }
    public String getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }
    public String getLicenciaProfesional() {
        return licenciaProfesional;
    }
    public EspecialidadOdontologica getEspecialidadOdontologica() {
        return especialidadOdontologica;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setLicenciaProfesional(String licenciProfesional) {
        this.licenciaProfesional = licenciProfesional;
    }
    public void setEspecialidadOdontologica(EspecialidadOdontologica especialidadOdontologica) {
        this.especialidadOdontologica = especialidadOdontologica;
    }
    public String odontologoToString() {
        return "ID: "+ID+"\n"+"Nombre: "+nombre+"\n"+"LicenciaProfesional: "+licenciaProfesional+"\n"+"EspecialidadOdontologica: "+especialidadOdontologica;
    }
}
