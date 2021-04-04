/**
 * @author Abdallah Lotfi
 *
 */
public class Matrice {
	public float matrice[][];
    public int lignes;
    public int colonnes;
    
    
    /**
     * @param lignes
     * @param colonnes
     */
    public Matrice(int lignes, int colonnes) {
    	this.lignes = lignes;
    	this.colonnes = colonnes;
    	this.matrice = new float[lignes][colonnes];
    }

    /**
     * @param matrice
     * 
     */
    public Matrice(float [][]matrice) {
    	this.lignes = matrice.length;
    	this.colonnes = matrice[0].length;
		this.matrice = new float[lignes][colonnes];
		for (int i = 0; i < this.lignes; i++)
			for (int j = 0; j < this.colonnes; j++)
				this.matrice[i][j] = matrice[i][j];
    }
    
    /**
     * 
     */
    public void afficher()
    {
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.colonnes; j++) {
            	System.out.printf(this.matrice[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return;
    }
    
    public Matrice transpose() {
		Matrice A = new Matrice(this.lignes, this.colonnes);
		for (int i = 0; i < this.lignes; i++)
			for (int j = 0; j < this.colonnes; j++)
				A.matrice[j][i] = this.matrice[i][j];
		return A;
	}
	
	/**
	 * @param size
	 * @return
	 */
	public Matrice identite(int size) {
		Matrice identite = new Matrice(size, size);
		for (int j = 0; j < size; j++)
			identite.matrice[j][j] = 1;
		return identite;
	}
	
	public Matrice augmente(){
	    Matrice temp = new Matrice(this.lignes, this.colonnes * 2);
	    
 	    for (int i = 0; i < this.lignes; i++) {
 			for (int j = 0; j < this.colonnes; j++) {
 				temp.matrice[i][j] = this.matrice[i][j];
 				temp.matrice[i][j + this.colonnes] =  i == j ? 1 : 0;
 			}
 		}
 	    
 	    temp.afficher();
	    return temp;
	}
	
	/**
	 * @param l1
	 * @param l2
	 */
	public void swap_ligne(int l1, int l2) {
		if(l1 > this.lignes || l2 > this.lignes || l1 == l2 || l1 < 0 || l2 < 0) {
			throw new IndexOutOfBoundsException("Erreur de swap");
		} else {
			float []temp = this.matrice[l1];
			this.matrice[l1] = this.matrice[l2];
			this.matrice[l2] = temp;
			
		}
	}
	
	/**
	 * @param l_dest
	 * @param facteur
	 * @param l_source
	 */
	public void add_ligne(int l_dest, float facteur, int l_source) {
		if(l_source > this.lignes || l_dest > this.lignes || l_source == l_dest || facteur == 0 || l_source < 0 || l_dest < 0) {
			throw new IndexOutOfBoundsException("Erreur d'addition des lignes");
		}
		for(int i = 0; i < this.colonnes; i++) {
			this.matrice[l_dest][i] = this.matrice[l_dest][i] + facteur * this.matrice[l_source][i];
		}
		
	}
    
    /**
     * @param A
     * @param r
     * @param s
     * @return
     */
    public float[][] iter_gj(float [][]A, int r, int s){
    	
        float pivot = A[r][s];
        
        /**
         * divides pivot line by pivot
         */
        for(int j = 0; j < A[0].length; j++) {
            A[r][j] = A[r][j] / pivot;
        }
        
        /**
         * for each line
         * 	  if line != pivot line
         * 	  Ais = element in current line and same column as pivot
         * 	  		for each column in current line
         * 				multiply Ais by element in pivot line and subtract it from element in current line	
         */
        for(int i = 0; i < A.length; i++) {
            if(i != r) {
                float Ais = A[i][s];
                for(int j = 0; j < A[0].length; j++) {
                	float Arj = A[r][j];
                    A[i][j] = A[i][j] - Ais * Arj;
                }
            }
        }
    
        return A;
    }
}
