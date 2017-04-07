float restar (int i, int j){
	if (i > 0)then {
		returnn restar(i-1, j+1);
	} else {
		return j;
	}
}

/* En este caso el error está en la línea 3, los errores
exactamente son returnn (tiene 2 n) y i-1, j-1 ya que al
no tener espacios a los dos lados del menos y el mas no detecta
los símbolos, sino que detecta un identificador y una constante
integer (el menos forma parte del integer en este caso) */

void main (int args){
	int vara;
	int varb;
	vara = 5;
	varb = 10;
	int varc;
	varc = restar(vara, varb);
	printf(varc);
}