/*Algoritmos y Esctructuras de Datos
 *BinaryHeap
 *Xavier Cifuentes -13316 
 *Pablo de leon - 13227
 * Esta clase implementa el algoritmo de huffMan para la generacion del codigo. metodo codeGenerator().
 */


import java.util.*;


public class Controller {
	
	private Stack<Letter> thisLetter;
	private BinaryHeap<BinaryTree<Letter>> fullTree ;


		
	
	public Controller(String word){
		thisLetter = new Stack<Letter>();
		createLetterStack(word);
		setFullTree(new BinaryHeap<BinaryTree<Letter>>());
		createBinaryHeap();	
		setReferencedTree();
		setCode();
		
	}
	
	public void PrintLetters(){
		ListIterator<Letter> ListItr = thisLetter.listIterator() ;
		while (ListItr.hasNext()){
			System.out.println(ListItr.next().toString()+"\n");
			
		}
	}
		
	public void createLetterStack(String word){
		Stack<String> charsInWord = new Stack<String>();
		word = word.toUpperCase();
		for (int i = 0; i<word.length(); i++){
			String thisChar = String.valueOf(word.charAt(i));
			charsInWord.add(thisChar);
		}
		int size = charsInWord.size();
		
		for (int i=0; i<size; i++){
			Letter newLetter = new Letter(1, charsInWord.pop());
			if (i==0){
				thisLetter.add(newLetter);
			}
			else if (thisLetter.contains(newLetter)){
				//thisLetter.get(thisLetter.search(newLetter)-1).plusOne();
				for (int j=0; j<thisLetter.size();j++){
					if (thisLetter.get(j).equals(newLetter)) thisLetter.get(j).plusOne();
				}
			}
			else{
				thisLetter.push(newLetter);
			}
		}
	}		
	
	public void createBinaryHeap(){
		Stack<Letter> newLetter = thisLetter;
		while (!newLetter.isEmpty()){
			fullTree.addOrdered(new BinaryTree<Letter>(thisLetter.pop()));
		}
		this.thisLetter = newLetter;
	}

	public BinaryHeap<BinaryTree<Letter>> getFullTree() {
		return fullTree;
	}

	public void setFullTree(BinaryHeap<BinaryTree<Letter>> fullTree) {
		this.fullTree = fullTree;
	}

	public void setReferencedTree() {
		BinaryHeap<BinaryTree<Letter>> referencedTree = new BinaryHeap<BinaryTree<Letter>>();
		Letter parentValue = new Letter();
		BinaryTree<Letter> parentTree = null;
		

		
		for (int i = 1; i<fullTree.getSize(); i++){		
			
			if (i == 1){
				parentValue = fullTree.get(i-1).getValue().concatenatedLetter(fullTree.get(i).getValue());
				parentTree = new BinaryTree<Letter>(parentValue);					
				referencedTree.add(fullTree.get(i-1));
				referencedTree.add(fullTree.get(i));
				referencedTree.add(parentTree);	
			}
			else if( i>1){
				parentValue = parentTree.getValue().concatenatedLetter(fullTree.get(i).getValue());
				parentTree = new BinaryTree<Letter>(parentValue);
				referencedTree.add(fullTree.get(i));
				referencedTree.add(parentTree);		
			}		
		}		
		
		this.fullTree = referencedTree;	
	}
	
	public void codeGenerator(String a){

		String Code = "";
		
		for (int i = fullTree.getSize()-1; i>=0; i--){
			if (fullTree.get(i).getValue().getThisChar().length()>1) ;
			else{
				if (!a.equals(fullTree.get(i).getValue().getThisChar())){
					if (i-2 > 0){
						Code = Code + "1";
					}
				}
				else {
					if (i%2 == 0){
						Code = Code + "1"; 
						fullTree.get(i).getValue().setCode(Integer.parseInt(Code));
						thisLetter.add(fullTree.get(i).getValue());
					}
					else {
						Code = Code + "0";
						fullTree.get(i).getValue().setCode(Integer.parseInt(Code));
						thisLetter.add(fullTree.get(i).getValue());
					}
				}
			}
		}
	}
		
	public void setCode(){
		for (int i = 0; i<fullTree.getSize(); i++){
			codeGenerator(fullTree.get(i).getValue().getThisChar());
		}
	}
	
	public String decodeMessage(String a){
		String message = "";
		String lookFor = "";
		Integer code = 0;
		
		for (int i = 0; i<a.length(); i++){
			lookFor = lookFor + String.valueOf(a.charAt(i));
			code = Integer.parseInt(lookFor);
			for (int j = 0; j<thisLetter.size(); j++)
				if (thisLetter.get(j).codeFound(code)){
					message = message + thisLetter.get(j).getThisChar();
					lookFor = "";
				}	
		}
		return message;	
	}
			
		
		
	
}
