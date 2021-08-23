package com.luxoft.springcore.travel;

import java.util.Collections;
import java.util.List;

public class TravellingOpportunities {
	
	private List<Connection> connections;

	public List<Connection> getConnections() {
		return Collections.unmodifiableList(connections);
	}

	public void setConnections(List<Connection> connections) {
		this.connections = connections;
	}

}
