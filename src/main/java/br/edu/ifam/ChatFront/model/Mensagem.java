package br.edu.ifam.ChatFront.model;

public class Mensagem {

	    private Long id;
	    private String corpo;
	    private String remetente;
	    private String destinatario;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCorpo() {
			return corpo;
		}
		public void setCorpo(String corpo) {
			this.corpo = corpo;
		}
		public String getRemetente() {
			return remetente;
		}
		public void setRemetente(String remetente) {
			this.remetente = remetente;
		}
		public String getDestinatario() {
			return destinatario;
		}
		public void setDestinatario(String destinatario) {
			this.destinatario = destinatario;
		}

	  
	    
	}

