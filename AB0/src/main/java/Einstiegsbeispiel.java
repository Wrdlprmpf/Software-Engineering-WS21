public class Einstiegsbeispiel {
	public static void main(String[] args) {

		boolean[] array1 = new boolean[]{true, false, false};
		boolean[] array2 = new boolean[]{true, false, false};

		System.out.println(getHammingDistance(array1, array2));

	}


	public static int getHammingDistance(boolean[] array1, boolean[] array2){
		if(array1.length == 0 || array2.length == 0){
			throw new IllegalArgumentException("Mindestens ein zu überprüfendes Array ist leer");
		}
		int distance = 0;
		if(array1.length<array2.length){
			throw new IllegalArgumentException("Arrays unterschiedlich lang");
		}

		for (int i = 0; i < array1.length; i++) {
			if(array1[i]!=array2[i]){
				distance+=1;
			}
		}

		return distance;
	}
}
