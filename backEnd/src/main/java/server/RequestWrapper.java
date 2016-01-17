package server;

import java.util.List;

public class RequestWrapper {

	List<Sentencia> sentens;

	public List<Sentencia> getSentens() {
			return sentens;
	}

	public void setSentens(List<Sentencia> sentens) {
			this.sentens = sentens;
	}

	public String toString(){
		return ("sentencias: "+ this.sentens.toString());
	}


}
