package br.edu.ifes.sr.poo2.model;

import br.edu.ifes.sr.poo2.api.model.Model;


public class LogConfig extends Model {
	
	
	private static final long serialVersionUID = 1L;
	

	private long servicoId;

	private long gerenteId;
	
	public long getServicoId() {
		return servicoId;
	}

	public void setServicoId(long servicoId) {
		this.servicoId = servicoId;
	}

	public long getGerenteId() {
		return gerenteId;
	}

	public void setGerenteId(long gerenteId) {
		this.gerenteId = gerenteId;
	}

}
