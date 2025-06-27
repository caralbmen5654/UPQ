package P17_Quirofano;
/*
    Nombre, Padecimiento, Habitación
    Titular:
    Id, nombre, especialidad,
    Neurología, Urología, Gastroentorología, Ginecología, Cardiología, Oncología, Geriatría, Ortopedía, Pediatría
*/
class Personas{
    String id, nombre;
    public Personas(String id, String nombre){
        this.id= id;
        this.nombre=nombre;
    }
    public String getID(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }

}

class Titular extends Personas{
    String especialidad;
    public Titular(String id, String nombre, String especialidad){
        super(id, nombre);
        this.especialidad= especialidad;
    }
    public String getEspecialidad(){
        return especialidad;
    }
}

/*public class Paciente{

}*/