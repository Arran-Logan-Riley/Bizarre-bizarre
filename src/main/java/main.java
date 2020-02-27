import java.sql.Array;
import java.util.*;
import java.util.List;
import java.util.Collections;

public class main {
    public static void main(String... args) {
        System.out.println("Bizarre Bizarre ");
        List<String> objects = new ArrayList<>(); //array for storing the objects
        List<String> colors = new ArrayList<>(); //array for storing the color variables
        List<Integer> UniqueNumberStorage = new ArrayList<>(); //array to compare unique numbers

        for (int i=0; i<4; i++) {       //adding the numbers 0-4 to the Integer array
            UniqueNumberStorage.add(i);
        }

        Collections.shuffle(UniqueNumberStorage); //shuffling the numbers 1-4 so there are no copies of the same number, also randomizing their order

        int[] intIntergetArray = UniqueNumberStorage.stream() //converting the Inter array to ints as the code dose'nt work with objects
                .mapToInt(Integer::intValue)
                .toArray(); //pushing the converted Inters to the array of "intIntergetArray"

        Map<Integer, Integer> eachItem = new HashMap<>(); //initializing the hash map. giving it the name "eachItem"
        eachItem.put(1, 2); //adding the values to the hash map, this is so we know which objects are provided values.
        //chair
        eachItem.put(4, 0);
        //book
        eachItem.put(2, 3);
        //ghost
        eachItem.put(3, 1);
        //bottle
        eachItem.put(0, 4);

        //in this case, a hash map stores the index of the keys(name of object) and values(color) of the important objects

        colors.add("green"); //adding the colors to be used in the hash map and arrays
        colors.add("grey");
        colors.add("blue");
        colors.add("white");
        colors.add("red");

        objects.add("chair"); //adding the objects to be used in the hash map and arrays
        objects.add("Ghost");
        objects.add("mouse");
        objects.add("book");
        objects.add("bottle");


        int firstColor = intIntergetArray[0]; //setting the objects and colors to the randomly generated int array.
        int firstObject = intIntergetArray[1];
        int secondCOlor = intIntergetArray[2];
        int secondObject = intIntergetArray[3];




        System.out.println("Random card:" + colors.get(firstColor) + " " + objects.get(firstObject)); //prints the random card that has been generated
        System.out.println("Random card:" + colors.get(secondCOlor) + " " + objects.get(secondObject));



            if(eachItem.containsKey(firstColor) && eachItem.get(firstColor) == firstObject){ //uses the stored indexes from the hash map and checks that against the randomly generated card.

                System.out.println("Found object:" + colors.get(firstColor) + " " + objects.get(firstObject)); //Prints a message if there is an object that relates to the random cards

            }else if(eachItem.containsKey(secondCOlor) && eachItem.get(secondCOlor) == secondObject){      //if not the first object on the card, check the second card
                System.out.println("Found object:" + colors.get(secondCOlor) + " " + objects.get(secondObject));
            }else{
                for (Map.Entry<Integer,Integer> seclectedmap2 : eachItem.entrySet()){ //if the two objects on the card dont match the objects, look for the object that dosnt match the random colors and objects

                    if(seclectedmap2.getKey() != firstColor &&   //looking for an a toy we don't have
                            seclectedmap2.getValue() != firstObject &&
                            seclectedmap2.getKey() != secondCOlor &&
                            seclectedmap2.getValue() != secondObject
                        ) {

                        System.out.println("Found object that has no card properties:" +colors.get(seclectedmap2.getKey())+" " + objects.get(seclectedmap2.getValue()));
                        break;
                    }
                }

        }
    }
}
