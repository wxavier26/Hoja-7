/*Algoritmos y Esctructuras de Datos
 *BinaryHeap
 *Xavier Cifuentes -13316 
 *Pablo de leon - 13227
 */

public class Letter implements Comparable<Letter> {
	
	private int times;
	private String thisChar;
	private int code;
	
	public Letter() {
		this.times = 0;
		this.thisChar = "";
		this.code =0;
	}
	
	public Letter(int times, String thisChar) {
		this.times = times;
		this.thisChar = thisChar;
		this.code =0;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public String getThisChar() {
		return thisChar;
	}

	public void setThisChar(String thisChar) {
		this.thisChar = thisChar;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Letter [Frecuencia=" + times + ", Letra=" + thisChar + ", Codigo=" + code + "]";
	}

	@Override
	public int compareTo(Letter o) {
		if (o.getTimes()<this.times) return -1;
		else if (o.getTimes()>this.times) return 1;
		else return 0;
	}
	
	public boolean equals(Object o){
		if (this.thisChar.equals(((Letter) o).getThisChar())) return true;
		else return false;
	}
	
	public boolean codeFound(int o){
		if (code == o ) return true;
		else return false;
	}
	
	public Letter concatenatedLetter(Letter o){
		int newLetterTimes = this.times + o.getTimes();
		String newLetterChar = this.thisChar + o.getThisChar();
		return new Letter(newLetterTimes, newLetterChar);
	}
	
	public void plusOne(){
		this.times++;
	}
}
