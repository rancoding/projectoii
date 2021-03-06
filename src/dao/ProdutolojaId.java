package dao;
// Generated May 23, 2018 12:39:58 PM by Hibernate Tools 4.3.1



/**
 * ProdutolojaId generated by hbm2java
 */
public class ProdutolojaId  implements java.io.Serializable {


     private long codbarras;
     private byte idloja;

    public ProdutolojaId() {
    }

    public ProdutolojaId(long codbarras, byte idloja) {
       this.codbarras = codbarras;
       this.idloja = idloja;
    }
   
    public long getCodbarras() {
        return this.codbarras;
    }
    
    public void setCodbarras(long codbarras) {
        this.codbarras = codbarras;
    }
    public byte getIdloja() {
        return this.idloja;
    }
    
    public void setIdloja(byte idloja) {
        this.idloja = idloja;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ProdutolojaId) ) return false;
		 ProdutolojaId castOther = ( ProdutolojaId ) other; 
         
		 return (this.getCodbarras()==castOther.getCodbarras())
 && (this.getIdloja()==castOther.getIdloja());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getCodbarras();
         result = 37 * result + this.getIdloja();
         return result;
   }   


}


