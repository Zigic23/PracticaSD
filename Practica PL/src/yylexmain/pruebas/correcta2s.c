struct registro {
	int campo_a;
	float campo_b;
};

int sumaM (int m1,int m2){ //Tomamos m1 y m2 como matrices
	int suma;
	suma = 0;
	int i;
	for (i = 0; i < m1.length; i = i + 1){
		suma = suma + m1[0] + m2[0];
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