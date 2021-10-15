import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EinstiegsbeispielTest {

	@Test
	public void WhenInputArrayOneAndArrayTwo_ThenExpectDistanceThree(){
		boolean[] array1 = new boolean[]{true, true, true};
		boolean[] array2 = new boolean[]{false, false, false};

		assertEquals(3,Einstiegsbeispiel.getHammingDistance(array1,array2));
	}

	@Test
	public void WhenInputArrayThreeAndArrayFour_ThenExpectDistanceOne(){
		boolean[] array3 = new boolean[]{true, false, false};
		boolean[] array4= new boolean[]{true, false, true};

		assertEquals(1,Einstiegsbeispiel.getHammingDistance(array3,array4));
	}

	@Test
	public void WhenInputTwoDifferentArrayLengths_ThenExpectException(){
		boolean[] array1 = new boolean[]{true, true, true};
		boolean[] array2 = new boolean[]{true, true, true, true};
		assertThrows(Exception.class,()->Einstiegsbeispiel.getHammingDistance(array1,array2));
	}

	@Test
	public void WhenInputEmptyArray_ThenExpectException(){
		boolean[] array1 = new boolean[]{};
		boolean[] array2 = new boolean[]{true, true, true};

		assertThrows(Exception.class,()->Einstiegsbeispiel.getHammingDistance(array1,array2));
	}


}
