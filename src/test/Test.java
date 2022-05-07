package test;

import java.util.Set;

import exception.ConstructorInvalidoException;
import factory.*;
import model.Agencia;
import model.ticket.DatosDeEmpleo;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import model.usuario.Empleador;
import negocio.RondaDeEncuentro;
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
		
		Empleador arcor = new Empleador("Soy ARCORRRR", "Arcor", "caramelo.22", TipoPersona.FISICA,
				Rubro.COMERCIO_INTERNACIONAL);
		Empleador medife = new Empleador("Mauri", "Medife", "salud2022", TipoPersona.FISICA, Rubro.SALUD);
		agencia.registraEmpleador(arcor);
		agencia.registraEmpleador(medife);

		agencia.mostrarEmpleador();
		agencia.mostrarEmpleados();
		try {
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

			agencia.mostrarTicketBusqueda();
			RondaDeEncuentro.ejecutarRondaDeEncuentros(agencia);
			System.out.println(t4.getListaDeAsignaciones());
		
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
