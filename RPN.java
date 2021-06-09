package calculadora;

public class RPN {
	
	private String commando;
	private SacarPila arriba;
	
	//COnstructor
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	
	public void MeterPila(double nuevo_dato) {
		SacarPila nuevo_nodo = new SacarPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;	
		
	}
	public double SacarPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	
	
	public double resultado( ) {
		//variables generales
		double a, b;
		int j;
		
	
		
		for(int i = 0; i < commando.length( ); i++) {
			
			// si es un digito
			if(Character.isDigit(commando.charAt(i))) {
				double numero;
				
				// obtener un string a partir del numero
				String temp = "";
				for(j = 0; (j < 100) && (Character.isDigit(
						commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(commando.
							charAt(i));
				}
				// convertir a double y añadir a la pila
				
				numero = Double.parseDouble(temp);
				MeterPila(numero);
				
				
				//Dejamos solo las operaciones y las variables fuera
			} else if(commando.charAt(i) == '+') {
				suma();
			} else if(commando.charAt(i) == '-') {
				resta();
			} else if(commando.charAt(i) == '*') {
				multiplicar();
			} else if(commando.charAt(i) == '/') {
				dividir();
			}
			else if(commando.charAt(i) == '^') {
				elevado();
				}
			else if(commando.charAt(i) == '%') {
				percentage();
			
			} else if(commando.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
		double val = SacarPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	public void suma() {
		double a, b;
		b = SacarPila( );
		a = SacarPila( );
		MeterPila(a + b);
	}
	public void resta() {
		double a, b;
		b = SacarPila( );
		a = SacarPila( );
		MeterPila(a - b);
	}
	public void multiplicar() {
		double a, b;
		b = SacarPila( );
		a = SacarPila( );
		MeterPila(a * b);
	}
	public void dividir() {
		double a, b;
		b = SacarPila( );
		a = SacarPila( );
		MeterPila(a / b);
	}
	public void elevado() {
		double a,b;
		b = SacarPila( );
		a = SacarPila( );
		MeterPila(Math.pow(a, b));
	}
	public void percentage() {
		double a, b;
		b = SacarPila( );
		a = SacarPila( );
		MeterPila(a%b);
	}

}