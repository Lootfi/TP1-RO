public class Matrice {
	public float matrice[][];
    public int lignes;
    public int colonnes;
    
    
    
    public Matrice(int lignes, int colonnes) {
    	this.lignes = lignes;
    	this.colonnes = colonnes;
    	this.matrice = new float[lignes][colonnes];
    }

    
    
    public Matrice(float [][]matrice) {
    	this.lignes = matrice.length;
    	this.colonnes = matrice[0].length;
		this.matrice = new float[lignes][colonnes];
		for (int i = 0; i < this.lignes; i++)
			for (int j = 0; j < this.colonnes; j++)
				this.matrice[i][j] = matrice[i][j];
    }
    
    
    
    public void afficher()
    {
    	System.out.println("==========================\n");
        for (int i = 0; i < this.matrice.length; i++) {
            for (int j = 0; j < this.matrice[0].length; j++) {
            	System.out.print(this.matrice[i][j] + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("==========================\n");
    }
    
    public void afficher(float [][]A)
    {
    	for (int i = 0; i < A.length; i++) {
    		for (int j = 0; j < A[0].length; j++) {
            	System.out.print(A[i][j] + "\t");
            }
            System.out.println("\n");
        }
    	System.out.println("===============\n");
        return;
    }
    
    public Matrice transpose() {
		Matrice A = new Matrice(this.colonnes, this.lignes);
		for (int i = 0; i < this.lignes; i++)
			for (int j = 0; j < this.colonnes; j++)
				A.matrice[j][i] = this.matrice[i][j];
		return A;
	}
	
	
    
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
 	    
	    return temp;
	}

	
    public float[][] iter_gj(float [][]A, int r, int s) throws Exception {
    	
        float pivot = A[r][s];
        
        if(pivot == 0) {
        	throw new Exception("Solution Impossible");
        }
        
        for(int j = 0; j < A[0].length; j++) {
            A[r][j] = A[r][j] / pivot;
        }
        

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
    
    public void gaussJordanSolveEquations() throws Exception {
    	for(int i = 0; i < this.matrice.length; i++) {
    		this.matrice = this.iter_gj(this.matrice, i, i);
    	}
    }
    
    public void gaussJordanInverse() throws Exception {
    	Matrice M = new Matrice(this.matrice);
    	M = M.augmente();
    	for(int i = 0; i < M.matrice.length; i++) {
    		M.matrice = this.iter_gj(M.matrice, i, i);
    	}
    	this.matrice = M.matrice;
    }
    
    public Matrice multiply(Matrice B) throws Exception {
		if (this.colonnes != B.lignes) {
			throw new Exception("A.colonnes doit etre égale à B.lignes");
		}
		
		Matrice resultat = new Matrice(this.lignes, B.colonnes);
		
		for (int i = 0; i < this.lignes; i++) {
			for (int j = 0; j < B.colonnes; j++) {
				float sum = 0;
				for (int k = 0; k < this.colonnes; k++)
					sum += this.matrice[i][k] * B.matrice[k][j];
				resultat.matrice[i][j] = sum;
			}
		}
		return resultat;
	}
}
