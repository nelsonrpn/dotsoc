package dotsoc.brain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import exceptions.NotHiddenLayerException;

public class Layer {

	private List<Neuron> neurons;
	private Layer layerAhead;
	private Layer layerBehind;
	private double bias;
	private boolean alreadyCreatedSynapsis = false;
	private boolean activated = false;

	public Layer(double bias) {
		this.bias = bias;
		neurons = new ArrayList<>();
	}

	public Layer(Layer behind, Layer ahead, double bias) {
		layerAhead = ahead;
		layerBehind = behind;
		this.bias = bias;
		neurons = new ArrayList<>();
	}

	public void createSynapsis() {
		if (!validateSynapsisCreation()) {
			return;
		}

		for (Neuron thisNeuron : neurons) {
			for (Neuron nextNeuron : layerAhead.neurons) {
				Synapse syn = new Synapse(thisNeuron, nextNeuron);
				thisNeuron.addFrontSynapse(syn);
				nextNeuron.addBackSynapse(syn);
			}
		}

		alreadyCreatedSynapsis = true;
	}

	public void feedFoward() throws NotHiddenLayerException {
		if (!activated) {
			activateNeurons();
		}

		try {
			
			for (Neuron nextNeuron : layerAhead.neurons) {
				nextNeuron.inputPhase(bias);
			}
			
		} catch (NotHiddenLayerException ex) {
			
			System.out.println(ex.getMessage());
			
			for(Neuron nextNeuron : layerAhead.neurons) {
				nextNeuron.setInput(0d);
			}
			
			System.out.println("Next layer reseted and feedfoward operation stopped");
			
			throw ex;
		}

		activated = false;
	}

	private void activateNeurons() {
		for (Neuron neuron : neurons) {
			neuron.activate();
		}

		activated = true;
	}

	private boolean validateSynapsisCreation() {
		if (alreadyCreatedSynapsis || layerAhead == null) {
			return false;
		}
		return true;
	}

	public void addNeuron(Neuron neuron) {
		neurons.add(neuron);
	}
	
	public Collection<Neuron> getNeurons() {
		return neurons;
	}
	public Layer getAhead() {
		return layerAhead;
	}
	public Layer getBehind() {
		return layerBehind;
	}
	public void setBehind(Layer behind) {
		layerBehind = behind;
	}
	public void setAhead(Layer ahead) {
		layerAhead = ahead;
	}

}
