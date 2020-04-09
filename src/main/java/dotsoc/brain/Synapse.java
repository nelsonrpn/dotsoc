package dotsoc.brain;

import java.util.Random;

public class Synapse {
	
	private Neuron inputNeuron;
	private Neuron outputNeuron;
	private double output;
	private double weight;
	
	public Synapse(Neuron inputNeuron, Neuron outputNeuron) {
		this.inputNeuron = inputNeuron;
		this.outputNeuron = outputNeuron;
		weight = randomBetween(-1000,1000);
	}
	
	//"Pulsa" a entrada do inputNeuron multiplicada pelo peso para a saida, para posteriormente ser
	//somada ao "pulso" de todos as sinapses conectadas a um neuron da camada a frente
	//para por fim ser aplicada a função de ativação (sigmoid)
	public void pulse(double input) {
		output = input * weight;
	}
	
	private double randomBetween(double min, double max) {
		Random rand = new Random();
		return min + (rand.nextDouble() * (max - min));
	}
	
	public Neuron getInputNeuron() {
		return inputNeuron;
	}
	public void setInputNeuron(Neuron inputNeuron) {
		this.inputNeuron = inputNeuron;
	}
	public Neuron getOutputNeuron() {
		return outputNeuron;
	}
	public void setOutputNeuron(Neuron outputNeuron) {
		this.outputNeuron = outputNeuron;
	}
	public double getWeight() {
		return weight;
	}
	public void updateWeight(double weight) {
		this.weight = weight;
	}
	public double getOutput() {
		return output;
	}
	public void setOutput(double output) {
		this.output = output;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
	

}
