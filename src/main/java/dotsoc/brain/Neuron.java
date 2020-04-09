package dotsoc.brain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exceptions.NotHiddenLayerException;

public class Neuron {

	private double input;
	private List<Synapse> backSynapsis;
	private List<Synapse> frontSynapsis;
	private boolean activated = false;

	public Neuron(boolean inputLayer) {
		if (!inputLayer) {
			backSynapsis = new ArrayList<>();
		}
		frontSynapsis = new ArrayList<>();
	}

	public void activate() {
		for (Synapse syn : frontSynapsis) {
			syn.pulse(input);
		}
		
		activated = true;
	}
	
	//Will only be activated by the layer ahead, that is, never will be called by the input layer
	public void inputPhase(double bias) throws NotHiddenLayerException {
		if(backSynapsis == null) {
			throw new NotHiddenLayerException();
		}
		
		if(!activated) {
			activate();
		}
		
		double sum = 0d;
		
		for(Synapse syn : backSynapsis){
			sum += syn.getOutput();
		}
		
		input = sigmoid(sum + bias);
		
		activated = false;
	}

	private double sigmoid(double x) {
		return (1 / (1 + Math.pow(Math.E, -1 * x)));
	}
	
	public void addBackSynapse(Synapse syn) {
		backSynapsis.add(syn);
	}

	public void addFrontSynapse(Synapse syn) {
		frontSynapsis.add(syn);
	}

	public Collection<Synapse> getFrontSynapsis() {
		return frontSynapsis;
	}
	public Collection<Synapse> getBackSynapsis() {
		return backSynapsis;
	}
	public double getInput() {
		return input;
	}
	public void setInput(double input) {
		this.input = input;
	}



}
