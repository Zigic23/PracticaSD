int multiplicar (int v1, int v2){
	int auxiliar = 0;
	for (int i = 0; i < v1; i = i + 1) {
		auxiliar = auxiliar + v2;
	}
	return auxiliar;
}

void main (int args){
	int v1 = 6;
	int v2 = 10;
	int v3;
	v3 = multiplicar(v1, v2);
	v3 = multiplicar(v2, v3);
	printf(v3);
}

//En �ste caso el error lo encontramos en cada declaraci�n e inicializaci�n de variable, ya que
//nuestro analizador sint�ctico no permite que se declare y a la vez inicialice una variable.