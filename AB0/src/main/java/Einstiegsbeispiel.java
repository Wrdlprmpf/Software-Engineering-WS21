//Nicolas Wetscher 11845621

public class Einstiegsbeispiel {

    public static int getHammingDistance(boolean[] array1, boolean[] array2) {
        if (array1.length == 0 || array2.length == 0) {
            throw new IllegalArgumentException("Mindestens ein zu überprüfendes Array ist leer");
        }
        if (array1.length < array2.length) {
            throw new IllegalArgumentException("Arrays unterschiedlich lang");
        }
        int distance = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                distance += 1;
            }
        }

        return distance;
    }
}
