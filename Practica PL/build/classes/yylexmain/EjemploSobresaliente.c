struct registro {
	int campo_a;
	float campo_b;
};

void intercambio (int v1, int v2){
	int auxiliar;

	auxiliar = v1;
	v1 = v2;
	v2 = auxiliar;
}

float formula (float p1, int p2){
	float auxiliar;

	intercambio( p1 * 10, p2);
	while(p1 == 10.5 * p2){
		if( auxiliar < 10.5 and auxiliar >= 8.6 or not auxiliar == 9) then { 
			auxiliar = auxiliar + -3 + p2 % 045 * 0-3 / 0+67;
			auxiliar = auxiliar  - (+98 - p1 * 0x+ABD % 0xFC4D);
		} else {
			auxiliar = -3.98 + p2 % 045.27 * 0-3.11 / 0+67.34;
		}
		auxiliar = auxiliar - (+98.5 - p1 * 0x+ABD.EE % 0xFC4D.F4);
	}
	return auxiliar * 0x-FF;
}

void Main (int args){
	int entero1, entero2;
	float real1[10][20], real2;

	for( entero1 = 1 ; entero1 < 21 ; entero1 = entero1 + 1){
		entero2 = 1;
		do {
			real1[2][2] = 1.0;
			entero2 = entero2 + 1;
		} until (entero2 == 11)
	}
	printf('Esto es el programa \'principal\'...');
	{
		intercambio(entero2, entero1);
		real1[1][1] = formula(real2,entero1 + registro.campo_a);	
	}
	registro.campo_b = real1[3][1];
}
