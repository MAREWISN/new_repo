package Library;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Ksiegarnia {

    private ArrayList<Ksiazka> zbior;
    private ArrayList<Ksiazka> wypozyczoneKsiazki;

    public Ksiegarnia()
    {
        zbior = new ArrayList<>();
        wypozyczoneKsiazki = new ArrayList<>();
    }
    public void dodajKsiazke(String nazwa, String rodzaj, int rok_wydania)
    {
        zbior.add(new Ksiazka(nazwa, rodzaj, rok_wydania));
    }

    public void dodajKsiazke(Ksiazka ksiazka)
    {
        zbior.add(new Ksiazka(ksiazka.getNazwa(), ksiazka.getRodzaj(), ksiazka.getRok_wydania()));
    }

    public void wypozyczKsiazke(String nazwa)
    {
        boolean istnieje = false;
        for (int i = 0; i < zbior.size(); i++) {
            if (zbior.get(i).getNazwa().equals(nazwa)) {
                System.out.println("Wypożyczono książkę: " + zbior.get(i).getNazwa());
                wypozyczoneKsiazki.add(zbior.get(i));
                zbior.remove(i);
                istnieje = true;
                break;
            }
        }
        if (!istnieje) System.out.println("Nie posiadamy tej książki");
        
    }

    public void oddajKsiazke(String nazwa)
    {
        boolean istnieje = false;
        for (int i = 0; i < wypozyczoneKsiazki.size(); i++) {
            if (wypozyczoneKsiazki.get(i).getNazwa().equals(nazwa)) {
                System.out.println("Oddano książkę: " + wypozyczoneKsiazki.get(i).getNazwa());
                zbior.add(wypozyczoneKsiazki.get(i));
                wypozyczoneKsiazki.remove(i);
                istnieje = true;
                break;
            }
        }
        if (!istnieje) System.out.println("Nie wypożyczaliśmy tej ksiązki");
    }


    public void getZbior() {
        if (zbior.size() == 0) System.out.println("Aktualnie nie mamy dostępnej żadnej książki");
        else {
            System.out.println("W naszej księgarni mamy następujące książki:");
            for (int i = 0; i < zbior.size(); ) {
                if (i > 0 && zbior.get(i).getNazwa().equals(zbior.get(i - 1).getNazwa())) i += 1;
                else {
                    System.out.println(zbior.get(i));
                    i += 1;
                }
            }
        }
    }

    public void getZbior(String rodzaj) {
        System.out.println("W naszej księgarni mamy następujące książki rodzaju " + rodzaj);
        for (int i = 0; i < zbior.size();) {
            if (i > 0 &&  zbior.get(i).getNazwa().equals(zbior.get(i-1).getNazwa())) i +=1;
            else if (zbior.get(i).getRodzaj().equals(rodzaj)){System.out.println(zbior.get(i)); i+=1;}
            else i+=1;
        }
    }

    public void getWypozyczoneKsiazki()
    {
        System.out.println("Aktualnie niedostępne ksiązki to: ");
        for (int i = 0; i < wypozyczoneKsiazki.size();) {
            if (i > 0 && wypozyczoneKsiazki.get(i).getNazwa().equals(wypozyczoneKsiazki.get(i-1).getNazwa())) {
            }
            else {System.out.println(wypozyczoneKsiazki.get(i));
            }
            i +=1;
        }
    }

    @Override
    public String toString() {
        return "Ksiegarnia{" +
                "zbior=" + zbior +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ksiegarnia that = (Ksiegarnia) o;
        return Objects.equals(zbior, that.zbior);
    }



}
