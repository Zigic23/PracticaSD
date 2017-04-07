void Main (int args){
	int suma;
	suma = 0;
	int ii;
	int jj;
	for (ii = 0; ii < 10; ii = ii + 1){
		for (jj = 0; jj < 10; jj = jj + 1){
			suma = suma + ii + jj;
		}
	}
	printf(suma);
}