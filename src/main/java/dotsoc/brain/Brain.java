package dotsoc.brain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import exceptions.NotHiddenLayerException;

public class Brain {

	private List<Layer> layers;
	
	public Brain() {
		layers = new ArrayList<>();
	}
	
	//TODO: Que porra é essa
	public void constructBrain() {
		for(Layer layer : layers) {
			layer.createSynapsis();
		}
	}
	
	//TODO: Tratar exceção
	public void feedFowardNetwork() throws NotHiddenLayerException {
		for(Layer layer : layers) {
			
			if(layer.getAhead() == null) {
				break;
			}
			layer.feedFoward();
		}
	}
	
	public void printNet() {
		DecimalFormat df = new DecimalFormat("0.00");
		
		for(int i = 0; i < layers.size(); i++) {
			System.out.println("Layer=" + i);
			for(Neuron n : layers.get(i).getNeurons()) {
				System.out.print("Input=" + df.format(n.getInput()) + " -- ");
				for(Synapse s : n.getFrontSynapsis()) {
					System.out.print("W=" + df.format(s.getWeight()) + " Output=" + df.format(s.getOutput()) + " | ");
				}
				
				System.out.println();
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws NotHiddenLayerException {
		Neuron n11 = new Neuron(true);
		Neuron n12 = new Neuron(true);
		Neuron n13 = new Neuron(true);
		Neuron n21 = new Neuron(false);
		Neuron n22 = new Neuron(false);
		Neuron n23 = new Neuron(false);
		Neuron n31 = new Neuron(false);
		Neuron n32 = new Neuron(false);
		Neuron n33 = new Neuron(false);
		Layer input = new Layer(1); 
		Layer hidden = new Layer(1);
		Layer output = new Layer(1);

		input.setAhead(hidden);
		hidden.setBehind(input);
		hidden.setAhead(output);
		output.setBehind(hidden);

		input.addNeuron(n11);
		input.addNeuron(n12);
		input.addNeuron(n13);
		hidden.addNeuron(n21);
		hidden.addNeuron(n22);
		hidden.addNeuron(n23);
		output.addNeuron(n31);
		output.addNeuron(n32);
		output.addNeuron(n33);

		n11.setInput(5.32);
		n12.setInput(4.3);
		n13.setInput(1.43);
		
		Brain brain = new Brain();
		brain.layers.add(input);
		brain.layers.add(hidden);
		brain.layers.add(output);
		
		brain.constructBrain();
		brain.feedFowardNetwork();
		brain.printNet();
		
	}
}
