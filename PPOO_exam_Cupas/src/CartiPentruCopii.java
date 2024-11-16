public class CartiPentruCopii extends ACarti{
    private String titlu;
    private final int MIN_AGE = 3;
    boolean areMuzica;

    public CartiPentruCopii() {
        super();
        titlu ="Necunoscut";
        System.out.println("Varsta minima: " + MIN_AGE);
        areMuzica=false;
    }

    public CartiPentruCopii(String editura, int anLansare, float pret, EGenCarte genCarte, boolean inStock, String autor, int[] noCapitole, int noPagini, String titlu, boolean areMuzica) {
        super(editura, anLansare, pret, genCarte, inStock, autor, noCapitole, noPagini);
        this.titlu = titlu;
        this.areMuzica = areMuzica;
        //System.out.println("Varsta minima: " + MIN_AGE);
    }

    public CartiPentruCopii(CartiPentruCopii copy){
        super(copy.getEditura(), copy.getAnLansare(), copy.getPret(), copy.getGenCarte(), copy.isInStock(),copy.getAutor(), copy.getNoCapitole(), copy.getNoPagini());
        copy.titlu=titlu;
        copy.areMuzica=areMuzica;
        //System.out.println("Varsta minima: " + MIN_AGE);

    }


    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public int getMIN_AGE() {
        return MIN_AGE;
    }

    public boolean isAreMuzica() {
        return areMuzica;
    }

    public void setAreMuzica(boolean areMuzica) {
        this.areMuzica = areMuzica;
    }

    @Override
    public void personalizeaza(String s, int puncteBonus) {
        System.out.println("Cartea ta va avea fi " + s + " vei primi " + puncteBonus);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(super.toString()).append('\'');
        sb.append("Titlul '").append(titlu).append('\'');
        sb.append(", Varsta minima ").append(MIN_AGE);
        sb.append(", Are muzica ").append(areMuzica);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(CartiPentruCopii o) {
            if (this.getAnLansare() != o.getAnLansare()) {
                return Integer.compare(this.getAnLansare(), o.getAnLansare());
            }
            return Float.compare(this.getPret(), o.getPret());
        }

    @Override
    public void calculeazaReducerea() {
        float pretR = 0;
        if(getAnLansare()>2015){
            pretR=getPret()/0.25f;
            System.out.println("Pretul redus este:" +pretR);
        } else {
            System.out.println("Pretul nu se va schimba.");
        }
    }
}
