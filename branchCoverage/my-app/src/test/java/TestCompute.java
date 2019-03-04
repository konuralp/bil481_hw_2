import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Matchers;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testEmptyMQ() { //test for message queue size of 0
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    int exp = -1;

    //simple tests
    assertEquals(exp, c.countNumberOfOccurrences("Test1"));
    assertEquals(exp, c.countNumberOfOccurrences("Test2 Test2 test2 test2."));
    //Empty string test
    assertEquals(exp, c.countNumberOfOccurrences(""));
    //Long text test
    assertEquals(exp, c.countNumberOfOccurrences("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Volutpat lacus laoreet non curabitur gravida arcu ac tortor. Proin sagittis nisl rhoncus mattis rhoncus urna. Purus sit amet luctus venenatis lectus magna. Consequat nisl vel pretium lectus. Facilisi nullam vehicula ipsum a arcu. Massa massa ultricies mi quis hendrerit dolor magna. Varius duis at consectetur lorem donec massa. Ultricies integer quis auctor elit sed vulputate mi sit amet. Ac tincidunt vitae semper quis. Orci a scelerisque purus semper eget. Aliquet risus feugiat in ante metus dictum at tempor commodo. Netus et malesuada fames ac turpis egestas integer. Quis enim lobortis scelerisque fermentum dui faucibus. Sit amet porttitor eget dolor morbi non. Turpis massa tincidunt dui ut ornare lectus sit amet. Semper auctor neque vitae tempus quam pellentesque nec. Amet nisl purus in mollis nunc sed.\n" +
            "\n" +
            "Suspendisse ultrices gravida dictum fusce ut placerat orci nulla. Dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in. Ipsum nunc aliquet bibendum enim facilisis gravida neque convallis. Maecenas ultricies mi eget mauris pharetra. Justo donec enim diam vulputate ut pharetra sit amet aliquam. Quam viverra orci sagittis eu volutpat. Tempus quam pellentesque nec nam aliquam sem et tortor consequat. In fermentum et sollicitudin ac orci phasellus egestas. Etiam non quam lacus suspendisse faucibus interdum posuere. Lacus suspendisse faucibus interdum posuere. Purus sit amet luctus venenatis lectus magna fringilla urna. Sed velit dignissim sodales ut. Curabitur gravida arcu ac tortor dignissim convallis aenean et. Mauris vitae ultricies leo integer malesuada nunc vel. Cras tincidunt lobortis feugiat vivamus at augue eget arcu. Nullam non nisi est sit amet facilisis magna etiam. Tempus urna et pharetra pharetra massa. Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus. Lectus arcu bibendum at varius vel pharetra.\n" +
            "\n" +
            "Purus non enim praesent elementum facilisis leo vel fringilla. Massa enim nec dui nunc mattis enim ut. Nascetur ridiculus mus mauris vitae ultricies leo integer malesuada. Donec enim diam vulputate ut pharetra sit amet. Sit amet consectetur adipiscing elit ut aliquam purus sit amet. Enim eu turpis egestas pretium aenean pharetra. Ac ut consequat semper viverra nam libero justo laoreet sit. Diam maecenas sed enim ut. Enim sed faucibus turpis in eu mi bibendum neque egestas. Commodo quis imperdiet massa tincidunt.\n" +
            "\n" +
            "Lorem ipsum dolor sit amet consectetur adipiscing. Pellentesque dignissim enim sit amet venenatis urna cursus. Urna id volutpat lacus laoreet non curabitur gravida. Nullam ac tortor vitae purus faucibus ornare suspendisse sed. Leo integer malesuada nunc vel risus. Bibendum at varius vel pharetra vel turpis. Morbi tincidunt augue interdum velit euismod. Elementum nisi quis eleifend quam adipiscing vitae proin. Et egestas quis ipsum suspendisse ultrices gravida. Amet risus nullam eget felis eget nunc. Dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu. Ipsum suspendisse ultrices gravida dictum fusce ut placerat orci. Leo a diam sollicitudin tempor id eu nisl nunc mi. Aliquam nulla facilisi cras fermentum odio eu feugiat pretium nibh. Metus dictum at tempor commodo ullamcorper. Elementum pulvinar etiam non quam lacus suspendisse faucibus interdum. Sed felis eget velit aliquet. Faucibus in ornare quam viverra orci sagittis. Scelerisque mauris pellentesque pulvinar pellentesque habitant.\n" +
            "\n" +
            "Luctus venenatis lectus magna fringilla urna. Sagittis purus sit amet volutpat consequat mauris nunc congue. Euismod nisi porta lorem mollis. Sapien eget mi proin sed libero. Justo nec ultrices dui sapien eget mi. Sit amet nisl purus in mollis nunc sed id semper. Vitae proin sagittis nisl rhoncus mattis rhoncus. Donec massa sapien faucibus et molestie ac feugiat sed. Consectetur a erat nam at lectus urna duis convallis convallis. Diam volutpat commodo sed egestas egestas. Semper quis lectus nulla at volutpat diam. Enim nulla aliquet porttitor lacus luctus accumsan tortor. Ac odio tempor orci dapibus. Feugiat vivamus at augue eget arcu dictum. A diam sollicitudin tempor id eu nisl. Commodo odio aenean sed adipiscing diam donec adipiscing."));
  }

  @Test
  public void testMqNotContainsElement() {  //Test for message queue not containing element and has size 100
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.contains(anyString())).thenReturn(false);
    when(mq.size()).thenReturn(100);
    c = new Compute(mq);
    int exp = 0;
    //simple tests
    assertEquals(exp, c.countNumberOfOccurrences("Test1"));
    assertEquals(exp, c.countNumberOfOccurrences("Test2 Test2 test2 test2."));
    //Empty string test
    assertEquals(exp, c.countNumberOfOccurrences(""));
    //Long text test
    assertEquals(exp, c.countNumberOfOccurrences("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Volutpat lacus laoreet non curabitur gravida arcu ac tortor. Proin sagittis nisl rhoncus mattis rhoncus urna. Purus sit amet luctus venenatis lectus magna. Consequat nisl vel pretium lectus. Facilisi nullam vehicula ipsum a arcu. Massa massa ultricies mi quis hendrerit dolor magna. Varius duis at consectetur lorem donec massa. Ultricies integer quis auctor elit sed vulputate mi sit amet. Ac tincidunt vitae semper quis. Orci a scelerisque purus semper eget. Aliquet risus feugiat in ante metus dictum at tempor commodo. Netus et malesuada fames ac turpis egestas integer. Quis enim lobortis scelerisque fermentum dui faucibus. Sit amet porttitor eget dolor morbi non. Turpis massa tincidunt dui ut ornare lectus sit amet. Semper auctor neque vitae tempus quam pellentesque nec. Amet nisl purus in mollis nunc sed.\n" +
            "\n" +
            "Suspendisse ultrices gravida dictum fusce ut placerat orci nulla. Dignissim diam quis enim lobortis scelerisque fermentum dui faucibus in. Ipsum nunc aliquet bibendum enim facilisis gravida neque convallis. Maecenas ultricies mi eget mauris pharetra. Justo donec enim diam vulputate ut pharetra sit amet aliquam. Quam viverra orci sagittis eu volutpat. Tempus quam pellentesque nec nam aliquam sem et tortor consequat. In fermentum et sollicitudin ac orci phasellus egestas. Etiam non quam lacus suspendisse faucibus interdum posuere. Lacus suspendisse faucibus interdum posuere. Purus sit amet luctus venenatis lectus magna fringilla urna. Sed velit dignissim sodales ut. Curabitur gravida arcu ac tortor dignissim convallis aenean et. Mauris vitae ultricies leo integer malesuada nunc vel. Cras tincidunt lobortis feugiat vivamus at augue eget arcu. Nullam non nisi est sit amet facilisis magna etiam. Tempus urna et pharetra pharetra massa. Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus. Lectus arcu bibendum at varius vel pharetra.\n" +
            "\n" +
            "Purus non enim praesent elementum facilisis leo vel fringilla. Massa enim nec dui nunc mattis enim ut. Nascetur ridiculus mus mauris vitae ultricies leo integer malesuada. Donec enim diam vulputate ut pharetra sit amet. Sit amet consectetur adipiscing elit ut aliquam purus sit amet. Enim eu turpis egestas pretium aenean pharetra. Ac ut consequat semper viverra nam libero justo laoreet sit. Diam maecenas sed enim ut. Enim sed faucibus turpis in eu mi bibendum neque egestas. Commodo quis imperdiet massa tincidunt.\n" +
            "\n" +
            "Lorem ipsum dolor sit amet consectetur adipiscing. Pellentesque dignissim enim sit amet venenatis urna cursus. Urna id volutpat lacus laoreet non curabitur gravida. Nullam ac tortor vitae purus faucibus ornare suspendisse sed. Leo integer malesuada nunc vel risus. Bibendum at varius vel pharetra vel turpis. Morbi tincidunt augue interdum velit euismod. Elementum nisi quis eleifend quam adipiscing vitae proin. Et egestas quis ipsum suspendisse ultrices gravida. Amet risus nullam eget felis eget nunc. Dignissim cras tincidunt lobortis feugiat vivamus at augue eget arcu. Ipsum suspendisse ultrices gravida dictum fusce ut placerat orci. Leo a diam sollicitudin tempor id eu nisl nunc mi. Aliquam nulla facilisi cras fermentum odio eu feugiat pretium nibh. Metus dictum at tempor commodo ullamcorper. Elementum pulvinar etiam non quam lacus suspendisse faucibus interdum. Sed felis eget velit aliquet. Faucibus in ornare quam viverra orci sagittis. Scelerisque mauris pellentesque pulvinar pellentesque habitant.\n" +
            "\n" +
            "Luctus venenatis lectus magna fringilla urna. Sagittis purus sit amet volutpat consequat mauris nunc congue. Euismod nisi porta lorem mollis. Sapien eget mi proin sed libero. Justo nec ultrices dui sapien eget mi. Sit amet nisl purus in mollis nunc sed id semper. Vitae proin sagittis nisl rhoncus mattis rhoncus. Donec massa sapien faucibus et molestie ac feugiat sed. Consectetur a erat nam at lectus urna duis convallis convallis. Diam volutpat commodo sed egestas egestas. Semper quis lectus nulla at volutpat diam. Enim nulla aliquet porttitor lacus luctus accumsan tortor. Ac odio tempor orci dapibus. Feugiat vivamus at augue eget arcu dictum. A diam sollicitudin tempor id eu nisl. Commodo odio aenean sed adipiscing diam donec adipiscing."));
  }

  @Test
  public void testMqContains() {  //Test for message queue containing element.
    MessageQueue mq = mock(MessageQueue.class);
    String testStr = "test";
    when(mq.getAt(0)).thenReturn("test");
    when(mq.getAt(1)).thenReturn("test");
    when(mq.getAt(2)).thenReturn("test");
    when(mq.getAt(3)).thenReturn("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"); //random String
    when(mq.getAt(4)).thenReturn("test");
    when(mq.getAt(5)).thenReturn(""); //empty String
    when(mq.contains("test")).thenReturn(true);
    when(mq.size()).thenReturn(6);
    c = new Compute(mq);
    int exp = 4;
    //simple test
    assertEquals(exp, c.countNumberOfOccurrences("test"));
  }
}