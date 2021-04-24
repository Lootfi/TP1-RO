public class Main {

	public static void main(String[] args) throws Exception {
		//Question 4-1
		float [][]Q41 = {{2,1,4,16},{3,2,1,10},{1,3,3,16}};
		Matrice M4 = new Matrice(Q41);
		M4.gaussJordanSolveEquations();
		System.out.println("Solution de système d'équations:");
		M4.afficher();
		
		//Question 4-2
		float[][]B = {{2,1},{3,1}};

		Matrice MB = new Matrice(B);
		MB.gaussJordanInverse();
		System.out.println("Inverse de B:");
		MB.afficher();
		
		float [][]A = {{2,-1,0},{-1,2,-1},{0,-1,2}};
		Matrice MA = new Matrice(A);
		MA.gaussJordanInverse();
		System.out.println("Inverse de A:");
		MA.afficher();
		
		
		//Question 3
		
		float [][]A2 = {{2,-1,0,10},{-1,2,-1,-4},{0,-1,2,2}};
		Matrice MA2 = new Matrice(A2);
		MA2.gaussJordanSolveEquations();
		System.out.println("Solution de A*x=b:");
		MA2.afficher();
		
		
		// Question 4
		MA = new Matrice(A);
		MB = new Matrice(B);
		Matrice R1 = MA.multiply(MA.transpose());
		Matrice R2 = MB.multiply(MB.transpose());
		System.out.println("A*A^(-1) :");
		R1.afficher();
		System.out.println("B*B^(-1) :");
		R2.afficher();
		

        
	}

}
