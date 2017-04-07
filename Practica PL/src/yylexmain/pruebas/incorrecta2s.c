int sumaM (int m1,int m2){ //Tomamos m1 y m2 como matrices
	int suma;
	suma = 0;
	int i;
	for (i = 0; i < m1.length; i = i + 1){
		suma = suma + m1[i] + m2[i];	//El error está aqui ya que no se permite acceder a matrices con variables
	}
	return suma;
}

void main (int args){
	int m1[5];
	int m2[5];
	int suma;
	suma = sumaM(m1, m2);
	printf(suma);
}