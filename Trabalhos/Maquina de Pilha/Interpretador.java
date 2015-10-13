import java.io.*;
import java.util.*;
import java.util.InputMismatchException;

class Interpretador{
	private Stack<String> pilha;
	private int resultado;

	Interpretador(String[] codigo) throws IOException{
		this.pilha = new Stack<String>();
		this.resultado = 0;		
		String linha = "";
		for(int i = 0; i < codigo.length; i++){
			linha = codigo[i];
			if(linha.length()>=6){
				String[] aux2;
				//aux2 = "";
				aux2 = linha.split(" ");
				this.pilha.push(aux2[1]);	
			}
			else
				switch(linha){

				case("SUM"):{
					int op1=0;
					int op2=0;
					op2 = Integer.parseInt(this.pilha.pop());
					op1 = Integer.parseInt(this.pilha.pop());
					op1 = op1 + op2;
					this.pilha.push(Integer.toString(op1));					
					break;}
				case("DIV"):{
					int op1=0;
					int op2=0;
					op2 = Integer.parseInt(this.pilha.pop());
					op1 = Integer.parseInt(this.pilha.pop());
					try{
						op1 = op1 / op2;
						this.pilha.push(Integer.toString(op1));}
					catch(ArithmeticException arithmeticException){
						linha = null;						
						System.out.println("ERRO DIVISÃO POR ZERO");
						System.exit(1);
					}
			
					break;}
				case("SUB"):{	
					int op1=0;
					int op2=0;
					op2 = Integer.parseInt(this.pilha.pop());
					op1 = Integer.parseInt(this.pilha.pop());
					op1 = op1 - op2;
					this.pilha.push(Integer.toString(op1));					
					break;}
				case("MULT"):{					

					int op1=0;
					int op2=0;
					op2 = Integer.parseInt(this.pilha.pop());
					op1 = Integer.parseInt(this.pilha.pop());
					op1 = op1 * op2;
					this.pilha.push(Integer.toString(op1));					
					break;}
				case("PRINT"):{System.out.println(this.pilha.pop());break;}
				
				}
		}
	}




}
