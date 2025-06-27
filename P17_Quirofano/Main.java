/*
    Quirofano A,B,C,D,E Se busca por fecha y hora
    Titular:
    Id, nombre, especialidad,
    Neurología, Urología, Gastroentorología, Ginecología, Cardiología, Oncología, Geriatría, Ortopedía, Pediatría

    Equipo:
    Enfermera (4-5)
    Anestesiologo (1)

    Material Quirúrjico:
    Instrumental Quirúrjico, Gasas, Tornillos, Placas

    Paciente (15):
    Nombre, Padecimiento, Habitación

    Fechas del 1 al 15 de Junio, lunes a Domingo las 24 horas

    Se debe agendar nuevas citas por fecha y hora. Debe decir si el quirófano está disponible o no
    y si está disponible debe dejar agendar. Pide Id titular, equipo que apoyará, el material a usar y datos del paciente.
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import  java.util.Scanner;
class Personas{
    String id, nombre;
    public Personas(String id, String nombre){
        this.id= id;
        this.nombre=nombre;
    }
    public String mostrarID(){
        return id;
    }
    public String mostrarNombre(){
        return nombre;
    }
}
class Titular extends Personas{
    String especialidad;
    public Titular(String id, String nombre, String especialidad){
        super(id, nombre);
        this.especialidad= especialidad;
    }
    public String mostrarEspecialidad(){
        return especialidad;
    }
}
class Paciente extends Personas{
    String padecimiento, habitacion;
    public Paciente(String id, String nombre, String padecimiento, String habitacion){
        super(id, nombre);
        this.padecimiento= padecimiento;
        this.habitacion= habitacion;
    }
    public String mostrarPadecimiento(){
        return padecimiento;
    }
    public String mostrarHabitacion(){
        return habitacion;
    }
}
class Main{
    public static void main(String[] args){
        Scanner teclado= new Scanner(System.in);
        Titular titulares[]={
            new Titular("123", "Carlos Mendoza", "Neurología"),
            new Titular("124", "Perla Sarahí", "Urología"),
            new Titular("125", "Daniyel Paulín", "Gastroentorología"),
            new Titular("126", "Ricardo Veledíaz", "Ginecología"),
            new Titular("127", "Arlo Carrillo", "Cardiología"),
            new Titular("128", "Abigail Soto", "Oncología"),
            new Titular("129", "Abigail Mendoza", "Geriatría"),
            new Titular("130", "Rosa Bibiana", "Ortopedía"),
            new Titular("131", "Yara", "Pediatría")
        };
        Paciente pacientes[]= {
            new Paciente("223", "Daniel Guerrero", "Pie quebrado","10"), new Paciente("224","Ramiro Hernández", "Dolor de espalda", "11"),
            new Paciente("225", "Jorge Gutiérrez", "Esguince","12"), new Paciente("226","Jhonatan Reséndiz", "Cabeza abierta", "13"),
            new Paciente("227", "Pedro Pascual", "Mano quebrada","14"), new Paciente("228","Mauricio Ramírez", "Esguince", "15"),
            new Paciente("229", "Elías Zar", "Uña enterrada","16"), new Paciente("230","Álvaro Carbajal", "Disparo", "17"),
            new Paciente("231", "Jummy Guerrero", "Hombro lastimado","18"), new Paciente("232","Ezquiel Montes", "Caída de altura", "19"),
            new Paciente("233", "Isaac Chávez", "Caida de bicicleta","20"), new Paciente("234","Gustavo Vigil", "Pie torcido", "21"),
            new Paciente("235", "Rafael Espinoza", "Dolor de cabeza","22"), new Paciente("236","Ricardo Salinas", "Infarto", "23"),
            new Paciente("237", "Benjamín Almonte", "Dolor estomacal","24")
        };
        List<List<String>> Agenda= new ArrayList<>();
        boolean repetir= true;
        while(repetir){
            System.out.print("\033[H\33[2J");
            System.out.flush();
            System.out.println("Qué quieres hacer?:\n1<- Ver agenda\n2<- Agregar un registro");
            int opc= teclado.nextInt(); teclado.nextLine();
            switch (opc) {
                case 1:
                    if(Agenda.isEmpty()){
                        System.out.println("No hay registros aún");
                    }else{
                        for(int i=0; i<Agenda.size(); i++){
                            List<String>registro= Agenda.get(i);    
                            System.out.println("\nRegistro (" + (i+1) + ")");                  
                            System.out.println("\tQuirófano: "+ (char)Integer.parseInt(registro.get(0)));
                            System.out.println("\tTitular: "+registro.get(1));
                            System.out.println("\tEquipo: "+ registro.get(2));
                            System.out.println("\tMaterial: "+ registro.get(3));
                            System.out.println("\tPaciente: "+ registro.get(4));
                            System.out.println("\tFecha: "+ registro.get(5));
                            System.out.println("\tHora: "+ registro.get(6));
                        }
                    }
                    break;
                case 2:
                    boolean encontrado=false;
                    String dato_paciente="";
                    while(!encontrado){
                        System.out.println("Ingresa el ID del paciente: ");
                        dato_paciente= teclado.nextLine();
                        for(int i=0; i<15; i++){
                            if(pacientes[i].mostrarID().contentEquals(dato_paciente)){
                                encontrado= true;
                                System.out.println("\nSe encontró el siguiente registro de paciente:");
                                System.out.println("ID: "+ pacientes[i].mostrarID());
                                System.out.println("Nombre: "+ pacientes[i].mostrarNombre());
                                System.out.println("Padecimiento: "+ pacientes[i].mostrarPadecimiento());
                                System.out.println("Habitación: "+ pacientes[i].mostrarHabitacion()+"\n");
                                dato_paciente= pacientes[i].mostrarNombre(); break;
                            }
                        }
                        if(!encontrado){
                            System.out.println("No se encontró el registro. Intenta de nuevo.");
                        }
                    }
                    encontrado= false;
                    String dato_Titular="";
                    while(!encontrado){
                        System.out.println("Ingresa el ID del Titular: ");
                        dato_Titular= teclado.nextLine();
                        for(int i=0; i<titulares.length; i++){
                            if(titulares[i].mostrarID().contentEquals(dato_Titular)){
                                encontrado= true;
                                System.out.println("\nSe encontró el siguiente registro de titular:");
                                System.out.println("ID: "+ titulares[i].mostrarID());
                                System.out.println("Nombre: "+ titulares[i].mostrarNombre());
                                System.out.println("Especialidad: "+ titulares[i].mostrarEspecialidad());
                                dato_Titular= titulares[i].mostrarNombre(); break;
                            }
                        }
                        if(!encontrado){
                            System.out.println("No se encontró el registro. Intenta de nuevo.");
                        }
                    }
                    encontrado= false;
                    char quirofano='Z';
                    while(!encontrado){
                        System.out.println("\nIngresa el Quirófano (A,B,C,D o E): ");
                        quirofano=  Character.toUpperCase(teclado.next().charAt(0));
                        teclado.nextLine();
                        if(quirofano=='A' || quirofano=='B' || quirofano=='C' || quirofano=='D' || quirofano=='E'){
                            encontrado=true;
                        }else{
                            System.out.println("Este quirófano no es válido.");
                        }
                    }
                    System.out.println("\nIngresa el equipo que apoyará: ");
                    String equipo= teclado.nextLine();
                    System.out.println("\nIngresa el Material a usar: ");
                    String material= teclado.nextLine();
                    String dia="", hora="";
                    boolean registrar= false;
                    while(!registrar){
                        encontrado=false;
                        while (!encontrado) {
                            System.out.println("Ingresa el día: ");
                            dia= teclado.nextLine();
                            if(Integer.parseInt(dia)<1 || Integer.parseInt(dia)>15){
                                System.out.println("Este día no es válido.");
                            } else{
                                encontrado= true;
                            }
                        }
                        encontrado= false;
                        while (!encontrado) {
                            System.out.println("Ingresa la hora (Formato 24h): ");
                            hora= teclado.nextLine();
                            if(Integer.parseInt(hora)<1 || Integer.parseInt(hora)>24){
                                System.out.println("Esta hora no es válida.");
                            } else{
                                encontrado= true;
                            }
                        }
                        encontrado= false;
                        for(int i=0; i<Agenda.size(); i++){
                            List<String> registro= Agenda.get(i);
                            if((char)Integer.parseInt(registro.get(0))==quirofano && registro.get(5).contentEquals(dia+"-06-2025")&& registro.get(6).contentEquals(hora+":00")){
                                System.out.println("Este espacio a esta hora ya está ocupado. Ingresa otra fecha y hora.");
                                encontrado=true;
                                break;
                            }
                        }
                        if(!encontrado){
                            registrar= true;
                            List<String> newRegistro= Arrays.asList(Integer.toString(quirofano), dato_Titular, equipo, material, dato_paciente, dia+"-06-2025", hora+":00");
                            Agenda.add(newRegistro);
                            System.out.println("REGISTRO GUARDADO CON EXITO");
                        }
                    }
                break;
                default:
                    System.out.println("Opcion no valida");
            }
            System.out.println("\n\n1<- Repetir programa\t2<-Salir");
            int rep= teclado.nextInt(); teclado.nextLine();
            if(rep==2){
                repetir= false;
            }
        }
    }
}