
public class Main {

	public static void main(String[] args) {
		float[][] A = {{1,2,3,1},{1,2,3,1},{1,2,3,1}};
        Matrice M = new Matrice(A);
        M.afficher();
        System.out.println("============");
//        A = M.iter_gj(A, 0, 0);
        A = M.iter_gj(A, 1,1);
//        A = M.iter_gj(A, 2,2);
        Matrice AA = new Matrice(A);
        AA.afficher();
	}

}
