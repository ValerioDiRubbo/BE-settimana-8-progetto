package it.wallet.rest;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import it.wallet.pojo.ContoCorrente;
import it.wallet.pojo.Movimenti;

@Path("/wallet")
public class GestioneWallet {

	private static List<ContoCorrente> listacc = new ArrayList<ContoCorrente>();
	private static List<Movimenti> movimenti = new ArrayList<Movimenti>();
	
	@POST
	@Path("/inserisci")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserisciCC(ContoCorrente cc) {
		
		listacc.add(cc);
		
		return Response.status(200).entity("Conto corrente con iban " + cc.getIban() + " creato").build();
	}
	
	@GET
	@Path("/getconti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ContoCorrente> getConti () {
		
		return listacc;
	}
	
	@GET
	@Path("/getmovimenti")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movimenti> getMovimenti () {
		
		return movimenti;
	}
	
	@DELETE
	@Path("/deleteconto/{iban}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cancellaCC(@PathParam("iban")int iban) {
		
		for (ContoCorrente conto : listacc) {
			if (conto.getIban() == iban) {
				listacc.remove(conto);
				break;
			}
		}
		return Response.status(200).entity("Eliminazione conto corrente andata a buon fine.").build();
	}
	
	@PUT
	@Path("/modifica")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiornaCC(ContoCorrente cc) {
		
		
		for (ContoCorrente conto : listacc) {
			if (conto.getIban() == cc.getIban()) {
				int index = listacc.lastIndexOf(conto);
				listacc.set(index, cc);
				break;
			}
				
			}
		
		return Response.status(200).entity("Aggiornamento avvenuto con successo.").build();
	}
	
	@PUT
	@Path("/deposito/{iban}/{data}/{importo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deposito(@PathParam("iban")int iban,@PathParam("data")String data,
			@PathParam("importo") double importo) {
		
		ContoCorrente cc = null;
		for (ContoCorrente conto : listacc) {
			if (conto.getIban() == iban) {
				
				cc = conto;
//				int index = listacc.lastIndexOf(conto);
//				listacc.set(index, cc);
				cc.setSaldo(conto.getSaldo()+importo);
				Movimenti mov = new Movimenti();
				mov.setData(data);
				mov.setImporto(importo);
				mov.setIban(cc.getIban());
				mov.setTipoMovimento("Deposito.");
				movimenti.add(mov);
				break;
			}
				
			}
		return Response.status(200).entity("Depositati : " + importo + " dal conto con IBAN :" + cc.getIban() ).build();
	}
	
	@PUT
	@Path("/prelievo/{iban}/{data}/{importo}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response prelievo(@PathParam("iban")int iban,@PathParam("data")String data,
			@PathParam("importo") double importo) {
		
		ContoCorrente cc = null;
		for (ContoCorrente conto : listacc) {
			if (conto.getIban() == iban) {
				
				cc = conto;
//				int index = listacc.lastIndexOf(conto);
//				listacc.set(index, cc);
				cc.setSaldo(conto.getSaldo()-importo);
				Movimenti mov = new Movimenti();
				mov.setData(data);
				mov.setImporto(importo);
				mov.setIban(cc.getIban());
				mov.setTipoMovimento("Prelievo.");
				movimenti.add(mov);
				break;
			}
				
			}
		return Response.status(200).entity("Prelevati : " + importo + " dal conto con IBAN :" + cc.getIban() ).build();
	}
}
