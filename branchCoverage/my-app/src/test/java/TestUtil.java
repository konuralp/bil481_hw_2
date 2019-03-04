import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Rule
  public final ExpectedException exception = ExpectedException.none();  //for exception checking

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void testArgsLengthOne(){  //Test for single arguments
    int any1 = 32934;
    int any2 = -12;
    int any3 = 0;
    int any4 = 50;
    int any5 = 329521;
    assertFalse(c.compute(any1));
    assertFalse(c.compute(any2));
    assertFalse(c.compute(any3));
    assertFalse(c.compute(any4));
    assertFalse(c.compute(any5));
  }

  @Test
  public void testArgsLengthEven(){ //Testing even arguments
    int any[] = {32934,-12,0,50,329521};
    for (int i = 0; i < any.length; i++) {
      for(int j=0; j < any.length; j++){
        assertFalse(c.compute(any[i],any[j]));
      }
    }
    for (int i = 0; i < any.length; i++) {
      for(int j=0; j < any.length; j++){
        assertFalse(c.compute(any[j],any[i],any[j],any[i]));
      }
    }
    assertFalse(c.compute());
    assertFalse(c.compute(1,2,3,4,5,6,7,8,9,10));
  }

  @Test
  public void testOddArgContainingZero(){  //Test for odd arg containing zero
    exception.expect(RuntimeException.class); //compute method must throw RuntimeException
    c.compute(12,4,5,-1203,412,4,0);
  }

  @Test
  public void testOddArgs(){  //Test for odd arguments
    assertTrue(c.compute(1,2,3,4,5,6,7));
    assertTrue(c.compute(2,4,6,8,10));
    assertTrue(c.compute(8,10,6));
    assertTrue(c.compute(-5,100,30));
    assertFalse(c.compute(4,6,11));
    assertFalse(c.compute(2,4,6,5,2));
    assertFalse(c.compute(8,10,5));
    assertFalse(c.compute(-5,-4,-10));

  }

}