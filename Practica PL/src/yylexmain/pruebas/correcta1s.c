int multiplicar (int v1, int v2){
	int auxiliar;

	auxiliar = 0;
	int i;
	for (i = 0; i < v1; i = i + 1) {
		auxiliar = auxiliar + v2;
	}
	return auxiliar;
}

void main (int args){
	int v1;
	v1 = 6;
	int v2;
	v2 = 10;
	int v3;
	v3 = multiplicar(v1, v2);
	v3 = multiplicar(v2, v3);
	printf(v3);
}