import java.util.ArrayList;

import factory.CargaHorariaFactory;
import factory.EstudiosFactory;
import factory.ExperienciaFactory;
import factory.LocacionFactory;
import factory.PretensionSalarialFactory;
import factory.RangoEtarioFactory;
import factory.TipoDePuestoFactory;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.DatosDeEmpleo;
import model.ticket.pretensionSalarial.*;
import model.usuario.Empleado;
import model.usuario.Empleador;
import negocio.RondaDeEncuentro;

public class main {

  public static void main(String[] args){
	    System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAA");


      Agencia agencia = Agencia.getAgencia();
      ArrayList<Empleado> empleados= new ArrayList<Empleado>();
      Empleado e1=new Empleado("Tibau","12345","Bautista Priano",20,"tibau@gmail.com","12323143");
      Empleado e2=new Empleado("Tibau2","12345","Bautista Sobenko",21,"tibau2@gmail.com","121233");
      Empleado e3=new Empleado("Tibau3","12345","Bauti tibau",22,"tibau3@gmail.com","12333");
      CargaHorariaFactory cargaH= new CargaHorariaFactory();
      EstudiosFactory estudios=new EstudiosFactory();
      ExperienciaFactory experiencia = new ExperienciaFactory();
      LocacionFactory locacion=new LocacionFactory();
      PretensionSalarialFactory pretension= new PretensionSalarialFactory();
      RangoEtarioFactory rangoEtario= new RangoEtarioFactory();
      TipoDePuestoFactory tipoDePuesto=new TipoDePuestoFactory();
      Empleador empleador3=new Empleador("Empleador","facu");
      
      empleador3.setNombre("Empresa");
      agencia.getEmpleados().add(e1);
      agencia.getEmpleados().add(e2);
      agencia.getEmpleados().add(e3);
      agencia.getEmpleadores().add(empleador3);
      
      try {
      FormularioBusqueda formularioEmpleado= new FormularioBusqueda(rangoEtario.getRangoEtario("MENOR_40",10),
    		  locacion.getLocacion("HOMEOFFICE",20),experiencia.getExperiencia("nada",40),cargaH.getCargaHoraria("media",30),
    		  tipoDePuesto.getTipoDePuesto("jr", 10),estudios.getEstudios("secundario", 20),100000);
      
      
      FormularioBusqueda formularioEmpleador= new FormularioBusqueda(rangoEtario.getRangoEtario("MENOR_40",10),
    		  locacion.getLocacion("HOMEOFFICE",20),experiencia.getExperiencia("nada",40),cargaH.getCargaHoraria("media",30),
    		  tipoDePuesto.getTipoDePuesto("jr", 10),estudios.getEstudios("secundario", 20),100000);
      

     agencia.getBusquedas().add(e1.altaTicket(formularioEmpleado)) ;
     agencia.getSolicitudes().add(empleador3.altaTicket(formularioEmpleador, 1));
     
     
       agencia.mostrarTicketBusqueda();
       agencia.mostrarTicketSolicitud();
      }
      catch(Exception e){
    	  
      }
      }


 }

