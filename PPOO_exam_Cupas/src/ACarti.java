import java.util.Arrays;

public abstract class ACarti extends APriceMonitor implements IPersonalizabil{
    private String autor;
    private int[] noCapitole;
    private int noPagini;


    private final static char ISBN = 11002;

    public ACarti() {
        super();
        autor="Necunoscut";
        noCapitole=null;
        noPagini=0;
        System.out.println("ISBN for this class is: " + ISBN);
    }


    public ACarti(String editura, int anLansare, float pret, EGenCarte genCarte, boolean inStock, String autor, int[] noCapitole, int noPagini) {
        super(editura, anLansare, pret, genCarte, inStock);
        this.autor = autor;
        this.noCapitole = new int[noCapitole.length];
        for(int i = 0; i<noCapitole.length; i++){
            this.noCapitole[i]=noCapitole[i];
        }
        this.noPagini = noPagini;

    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int[] getNoCapitole() {
        if(this.noCapitole!=null){
            this.noCapitole = new int[noCapitole.length];
            for(int i = 0; i<noCapitole.length; i++){
                this.noCapitole[i]=noCapitole[i];
            }
            return this.noCapitole=null;
        }
        return null;
    }

    public void setNoCapitole(int[] noCapitole) {
        if(noCapitole!=null){
            int[] copy = new int[noCapitole.length];
            for(int i = 0; i<noCapitole.length; i++){
                copy[i]=noCapitole[i];
            }
        }
    }

    public int getNoPagini() {
        return noPagini;
    }

    public void setNoPagini(int noPagini) {
        this.noPagini = noPagini;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(super.toString()).append('\'');
        sb.append("autor='").append(autor).append('\'');
        sb.append(", noCapitole=").append(Arrays.toString(noCapitole));
        sb.append(", noPagini=").append(noPagini);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void calculeazaReducerea() {
        if(getAnLansare()>2015){
            float pretR = 0;
            pretR=getPret()/0.25f;
        }
    }

    @Override
    public void crestePretul() {
        if(getAnLansare()<2020){
            float pretC=0;
            pretC=getPret()*0.13f;
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ACarti copy=(ACarti)super.clone();
        this.autor=autor;
        this.noPagini=noPagini;
        for(int i = 0; i<noCapitole.length; i++){
            copy.noCapitole[i]=noCapitole[i];
        }
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ACarti that = (ACarti) o;
        return getAnLansare() == that.getAnLansare() && Float.compare(that.getPret(),this.getPret() ) == 0 &&  getNoPagini() == that.getNoPagini();
    }

    @Override
    public int hashCode() {
        return 31 * Float.hashCode(getPret()) + 17*Integer.hashCode(getAnLansare())+ 7*Integer.hashCode(getNoPagini()) ;
    }

   @Override
    public int compareTo(ACarti o) {
        if(this.getPret() !=o.getPret() && this.noPagini !=o.noPagini){
            return Float.compare(this.getPret(),o.getPret());
        } else  {
            System.out.println("Cartea a fost comparata");
            return Integer.compare(this.getAnLansare(),o.getAnLansare());
        }
    }

    public abstract int compareTo(CartiPentruCopii o);
}
