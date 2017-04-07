float restar (int i, int j){
	if (i > 0)then {
		return restar(i - 1, j + 1);
	} else {
		return j;
	}
}

void main (int args){
	int vara;
	int varb;
	vara = 5;
	varb = 10;
	int varc;
	varc = restar(vara, varb);
	printf(varc);
}