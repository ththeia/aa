import java.util.Objects;

public abstract class APriceMonitor implements Cloneable, Comparable<APriceMonitor>{
    private String editura;
    private int anLansare;
    private float pret;
    private EGenCarte genCarte;
    private boolean inStock;

    public APriceMonitor() {
        editura="Default";
        anLansare=1800;
        pret=0;
        genCarte=EGenCarte.COMEDIE;
        inStock=true;
    }

    public APriceMonitor(String editura, int anLansare, float pret, EGenCarte genCarte, boolean inStock) {
        this.editura = editura;
        this.anLansare = anLansare;
        this.pret = pret;
        this.genCarte = genCarte;
        this.inStock = inStock;
    }

    public String getEditura() {
        return editura;
    }

    public void setEditura(String editura) {
        this.editura = editura;
    }

    public int getAnLansare() {
        return anLansare;
    }

    public void setAnLansare(int anLansare) {
        this.anLansare = anLansare;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        if(pret !=0)
        {
        this.pret = pret;
        }
    }

    public EGenCarte getGenCarte() {
        return genCarte;
    }

    public void setGenCarte(EGenCarte genCarte) {
        this.genCarte = genCarte;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public abstract void calculeazaReducerea();
    public abstract void crestePretul();

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("Editura '").append(editura).append('\'');
        sb.append(", An lansare ").append(anLansare);
        sb.append(", Pret ").append(pret);
        sb.append(", Tipul de Carte ").append(genCarte);
        sb.append(", Este in stock ").append(inStock);
        sb.append('.');
        return sb.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
         APriceMonitor copy= (APriceMonitor)super.clone();
         copy.editura=editura;
         copy.anLansare=anLansare;
         copy.pret=pret;
         copy.genCarte=genCarte;
         copy.inStock=inStock;
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APriceMonitor that = (APriceMonitor) o;
        return anLansare == that.anLansare && Float.compare(that.pret, pret) == 0 && Objects.equals(editura, that.editura);
    }

    @Override
    public int hashCode() {
        return 31 * Float.hashCode(pret) + 17*Integer.hashCode(anLansare)+ editura.hashCode()  ;
    }

    @Override
    public int compareTo(APriceMonitor o) {
        if(this.pret !=o.pret){
            return Float.compare(this.pret,o.pret);
        } else {
            return Integer.compare(this.anLansare,o.anLansare);
        }
    }


    public abstract int compareTo(ACarti o);
}
