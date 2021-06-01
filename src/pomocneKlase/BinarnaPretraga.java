package pomocneKlase;

import collections.list.DoublyLinkedList;
import entiteti.Automobil;
import entiteti.Voznja;
import korisnici.Osoba;

public class BinarnaPretraga {

    public  Osoba pronadjiOsobuBinarySearch(DoublyLinkedList<Osoba> array, int target){ // Ukloniti static
        return binarySearchOsoba(array, target, 0, array.size());
    }

    public  Osoba binarySearchOsoba(DoublyLinkedList<Osoba> array, int target, int low, int high){ // Ukloniti static

        if(low > high){
            return null;
        }
        int mid = (low + high) / 2;

        if (array.getElement(mid).getIdKorisnika() == target){
            return array.getElement(mid);
        } else if (array.getElement(mid).getIdKorisnika() > target){
            return  binarySearchOsoba(array, target, low, mid-1);
        } else {
            return binarySearchOsoba(array, target, mid + 1, high);
        }
    }


    public  Automobil pronadjiAutomobilBinarySearch(DoublyLinkedList<Automobil> array, int target){ // Ukloniti static
        return binarySearchAutomobil(array, target, 0, array.size());
    }

    public  Automobil binarySearchAutomobil(DoublyLinkedList<Automobil> array, int target, int low, int high){ // Ukloniti static

        if(low > high){
            return null;
        }
        int mid = (low + high) / 2;

        if (array.getElement(mid).getAutomobilID() == target){
            return array.getElement(mid);
        } else if (array.getElement(mid).getAutomobilID() > target){
            return  binarySearchAutomobil(array, target, low, mid-1);
        } else {
            return binarySearchAutomobil(array, target, mid + 1, high);
        }
    }

    public Voznja pronadjiVoznjaBinarySearch(DoublyLinkedList<Voznja> array, int target){ // Ukloniti static
        return binarySearchVoznja(array, target, 0, array.size());
    }

    public  Voznja binarySearchVoznja(DoublyLinkedList<Voznja> array, int target, int low, int high){ // Ukloniti static

        if(low > high){
            return null;
        }
        int mid = (low + high) / 2;

        if (array.getElement(mid).getIdVoznje() == target){
            return array.getElement(mid);
        } else if (array.getElement(mid).getIdVoznje() > target){
            return  binarySearchVoznja(array, target, low, mid-1);
        } else {
            return binarySearchVoznja(array, target, mid + 1, high);
        }
    }

}
