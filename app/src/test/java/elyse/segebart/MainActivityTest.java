package elyse.segebart;

import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertEquals;

public class MainActivityTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(6, 3+3);
    }

    @Test
    public void subtraction_isCorrect() throws Exception {
        assertEquals(2, 4-2);
    }

    @Test
    public void multiplication_isCorrect() throws Exception {
        assertEquals(4, 2*2);
    }

    @Test
    public void division_isCorrect() throws Exception {
        assertEquals(2, 4/2);
    }

}