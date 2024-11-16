import java.util.HashMap;
import java.util.TreeSet;

public class Test {
    public static void displayBooksWith200pg(HashMap<Integer, CartiPentruCopii> cartiPg){
        for(CartiPentruCopii carte : cartiPg.values()){
            if( carte.getNoPagini()<200){
                System.out.println(carte);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("---");
        int[] capitole ={1,2,3,4,5};
        CartiPentruCopii carteaPrincipala=new CartiPentruCopii("Corint",2014,38.5f,EGenCarte.AVENTURA,true,"Gellu Neum",capitole,142,"Pinguinul Apolodor",false);
        carteaPrincipala.setAnLansare(2020);
        carteaPrincipala.calculeazaReducerea();

        CartiPentruCopii copieCarte = null;
        if(carteaPrincipala instanceof Cloneable){
            try {
                copieCarte=(CartiPentruCopii)carteaPrincipala.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        copieCarte.setTitlu("Cartea este copiata");
        copieCarte.setAreMuzica(true);
        copieCarte.compareTo(carteaPrincipala);

        System.out.println("Cartea Copiata");
        System.out.println(copieCarte.toString());
        System.out.println("Cartea Originala");
        System.out.println(carteaPrincipala.toString());


        CartiPentruCopii c1=new CartiPentruCopii("Corint",2021,38.5f,EGenCarte.AVENTURA,true,"Gel",capitole,140,"Carte 1",false);
        CartiPentruCopii c2=new CartiPentruCopii("Aro",2018,68.5f,EGenCarte.COMEDIE,true,"G Neum",capitole,314,"Carte 2",false);
        CartiPentruCopii c3=new CartiPentruCopii("Humanitas",2004,68.5f,EGenCarte.ROMANTIC,false,"G Nem",capitole,92,"carte 3",false);
        CartiPentruCopii c4=new CartiPentruCopii("Exlibris",2021,98.13f,EGenCarte.COMEDIE,true,"Geum",capitole,42,"carte4",false);
        CartiPentruCopii c5=new CartiPentruCopii("Corint",2013,240.5f,EGenCarte.POVESTE_COPII,true,"Gel",capitole,78,"carte 5",true);

        HashMap<Integer,CartiPentruCopii> mapC = new HashMap<>();
        mapC.put(1,c1);
        mapC.put(2,c2);
        mapC.put(3,c3);
        mapC.put(4,c4);
        mapC.put(5,c5);

        System.out.println("----------Test afisare hashMap------");
        for(Integer key : mapC.keySet()){
            System.out.println("Cheia:" +key +"   " + "Cartea: "+ mapC.get(key).toString());
        }


        System.out.println("----------Test functie------");
        displayBooksWith200pg(mapC);

        System.out.println("----------Test tree------");

        TreeSet<CartiPentruCopii> cartiSet = new TreeSet<>();
        cartiSet.add(c1);
        cartiSet.add(c2);
        cartiSet.add(c3);
        cartiSet.add(c4);
        cartiSet.add(c5);

        //System.out.println("-----SET DE CARTI-----");
        for(CartiPentruCopii cartiS : cartiSet){
            System.out.println(cartiS);
        }
        System.out.println("\nMetode verificate:");
        for (CartiPentruCopii carte : cartiSet) {
            carte.calculeazaReducerea();
            carte.personalizeaza("verde", 30);
        }
    }
}