package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exception.ConstructorInvalidoException;
import exception.ContrasenaIncorrectaException;
import exception.EstadoInvalidoException;
import exception.NoDuenoDeTicketException;
import exception.UsuarioIncorrectoException;
import factory.*;
import model.Agencia;
import model.ticket.DatosDeEmpleo;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import model.usuario.Empleador;
import model.usuario.Usuario;
import negocio.RondaDeContrataciones;
import negocio.RondaDeElecciones;
import negocio.RondaDeEncuentro;
import types.EstadoTicket;
import types.Rubro;
import types.TipoPersona;

public class Test {

	public static void main(String[] args) {
		Agencia agencia = Agencia.getAgencia();// singleton

		Empleado jere = new Empleado("jeresava1", "contrasena", "Jeremias Savarino", 21, "jere@gmail.com",
				"2235723081");
		Empleado facu = new Empleado("facuerro1", " contrasena11 ", "Facundo Errobidart", 60, "facu@gmail.com",
				"2233212342");
		Empleado agus = new Empleado("agusrojas1", " contra_sena ", " Agustin rojas", 40, "agus@gmail.com",
				"22351234255");
		Empleado bauti = new Empleado("tibau1 ", "contra_sena11", "Bautista Priano ", 48, "tibau@gmail.com",
				"223983131");
		agencia.registraEmpleado(jere);
		agencia.registraEmpleado(bauti);
		agencia.registraEmpleado(agus);
		agencia.registraEmpleado(facu);

		agencia.setRemuneracionV1(500F);
		agencia.setRemuneracionV2(3000F);
		
		Empleador arcor = new Empleador("ARCOR", "ArcorOficial", "caramelo.22", TipoPersona.FISICA,
				Rubro.COMERCIO_INTERNACIONAL);
		Empleador medife = new Empleador("Medife", "MedifeOficial", "salud2022", TipoPersona.FISICA, Rubro.SALUD);
		agencia.registraEmpleador(arcor);
		agencia.registraEmpleador(medife);
		
		
		
		System.out.println("------------------------------------------\n");
		System.out.println("EMPLEADORES REGISTRADOS EN LA PLATAFORMA:  ");
		agencia.mostrarEmpleador();
		System.out.println("------------------------------------------\n");
		System.out.println("EMPLEADOS REGISTRADOS EN LA PLATAFORMA:  ");
		agencia.mostrarEmpleados();
		System.out.println("------------------------------------------\n");
		try {
			agencia.loginEmpleado("jeresava1", "contrasena");
			
			TicketBusquedaDeEmpleado t5 = arcor.altaTicket(new FormularioBusqueda(
					RangoEtarioFactory.getRangoEtario(30, 10), LocacionFactory.getLocacion("INDISTINTO", 5),
					ExperienciaFactory.getExperiencia("MUCHA", 10), CargaHorariaFactory.getCargaHoraria("COMPLETA", 10),
					TipoDePuestoFactory.getTipoDePuesto("SR", 5), EstudiosFactory.getEstudios("TERCIARIO", 10), PretensionSalarialFactory.getPretensionSalarial(5,1000)),
					1);

			TicketBusquedaDeEmpleado t6 = medife.altaTicket(new FormularioBusqueda(
					RangoEtarioFactory.getRangoEtario(50, 5), LocacionFactory.getLocacion("INDISTINTO", 15),
					ExperienciaFactory.getExperiencia("MEDIA", 10), CargaHorariaFactory.getCargaHoraria("MEDIA", 10),
					TipoDePuestoFactory.getTipoDePuesto("JR", 5), EstudiosFactory.getEstudios("TERCIARIO", 10), PretensionSalarialFactory.getPretensionSalarial(5,1000)),
					2);
			agencia.addSolicitudes(t5);
			agencia.addSolicitudes(t6);
			System.out.println("TICKETS DE BUSQUEDA DE EMPLEADOS : ");
			agencia.mostrarTicketSolicitud();

			TicketBusquedaDeEmpleo t1 = jere.altaTicket(new FormularioBusqueda(

					RangoEtarioFactory.getRangoEtario(30, 10), LocacionFactory.getLocacion("INDISTINTO", 5),
					ExperienciaFactory.getExperiencia("MUCHA", 10), CargaHorariaFactory.getCargaHoraria("COMPLETA", 10),
					TipoDePuestoFactory.getTipoDePuesto("SR", 5), EstudiosFactory.getEstudios("SECUNDARIO", 10), PretensionSalarialFactory.getPretensionSalarial(5,1000)));

			TicketBusquedaDeEmpleo t2 = facu.altaTicket(new FormularioBusqueda(

					RangoEtarioFactory.getRangoEtario(30, 10), LocacionFactory.getLocacion("INDISTINTO", 5),
					ExperienciaFactory.getExperiencia("MUCHA", 10), CargaHorariaFactory.getCargaHoraria("COMPLETA", 10),
					TipoDePuestoFactory.getTipoDePuesto("SR", 5), EstudiosFactory.getEstudios("TERCIARIO", 10), PretensionSalarialFactory.getPretensionSalarial(5,1000)));

			TicketBusquedaDeEmpleo t3 = agus.altaTicket(new FormularioBusqueda(RangoEtarioFactory.getRangoEtario(50, 5),
					LocacionFactory.getLocacion("INDISTINTO", 15), ExperienciaFactory.getExperiencia("MEDIA", 10),
					CargaHorariaFactory.getCargaHoraria("MEDIA", 10), TipoDePuestoFactory.getTipoDePuesto("JR", 5),
					EstudiosFactory.getEstudios("PRIMARIO", 10), PretensionSalarialFactory.getPretensionSalarial(5,1000)));

			TicketBusquedaDeEmpleo t4 = bauti.altaTicket(new FormularioBusqueda(
					RangoEtarioFactory.getRangoEtario(50, 5), LocacionFactory.getLocacion("INDISTINTO", 15),
					ExperienciaFactory.getExperiencia("MEDIA", 10), CargaHorariaFactory.getCargaHoraria("MEDIA", 10),
					TipoDePuestoFactory.getTipoDePuesto("JR", 5), EstudiosFactory.getEstudios("TERCIARIO", 10), PretensionSalarialFactory.getPretensionSalarial(5,1000)));

			agencia.addBusquedas(t1);
			agencia.addBusquedas(t2);
			agencia.addBusquedas(t3);
			agencia.addBusquedas(t4);

			System.out.println("------------------------------------------\n");
			System.out.println("TICKETS DE BUSQUEDA DE EMPLEADOS:  \n");
			agencia.mostrarTicketBusqueda();
			System.out.println("------------------------------------------\n");
			RondaDeEncuentro.ejecutarRondaDeEncuentros(agencia);
			System.out.println("Lista de asignaciones de BAUTI:  \n");
			System.out.println(t4.getListaDeAsignaciones());
			System.out.println("------------------------------------------\n");
			System.out.println("LISTA DE ASIGNACIONES DE MEDIFE:   \n");
			System.out.println(t6.getListaDeAsignaciones());
			RondaDeElecciones.seleccionaCandidato(t4, medife);
			RondaDeElecciones.seleccionaCandidato(t3, medife);
			System.out.println("------------------------------------------\n");
			System.out.println("CANDIDATOS SELECCIONADOS POR BAUTI: ");
			RondaDeElecciones.muestraCandidatosSeleccionados(t4);
			System.out.println("------------------------------------------\n");
			List<Usuario> listaUsuarios=new ArrayList<>();
			listaUsuarios.add(t4.getDueno());
			listaUsuarios.add(t3.getDueno());
			RondaDeElecciones.seleccionaMultiplesCandidatos(t6, listaUsuarios);
			System.out.println("CANDIDATOS SELECCIONADOS POR MEDIFE: ");
			RondaDeElecciones.muestraCandidatosSeleccionados(t6);
			System.out.println("------------------------------------------\n");
			RondaDeContrataciones.ejecutarRondaDeContrataciones(agencia);
			System.out.println("MUESTRA CANDIDATOS CONTRATADOS POR MEDIFE: ");
			RondaDeContrataciones.muestraCandidatosContratados(t6);
			agencia.calculaComisionesEmpleado(t4);
			agencia.calculaComisionesEmpleador(t6);
			System.out.println("------------------------------------------\n");
			System.out.println("COMISION OBTENIDA: "+ agencia.getComisiones());
			
			agus.bajaTicket(t2);// se realiza una baja de un ticket que no pertenece al usuario para probar la excepcion
			
			} 
		catch(ContrasenaIncorrectaException e){
		    System.out.println(e.getMessage());	
		}
		catch(UsuarioIncorrectoException e) {
			System.out.println(e.getDato()+e.getMessage());
		}
		catch (ConstructorInvalidoException e) {
			System.out.println(e.getMessage());
		} catch (NoDuenoDeTicketException e) {
			System.out.println(e.getMessage());
		} catch (EstadoInvalidoException e) {
			System.out.println(e.getMessage());
		}
	}
}
