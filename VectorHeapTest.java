import org.junit.Test;
import static org.junit.Assert.*;


public class VectorHeapTest {

    @Test
    public void testAddAndRemove() {
        VectorHeap<Patient> heap = new VectorHeap<>();

        heap.add(new Patient("Paola", "alergia", 'C'));
        heap.add(new Patient("Keven", "Hueso roto", 'A'));
        heap.add(new Patient("Ale", "Quemadura", 'B'));

        assertEquals("Keven", heap.remove().getName());
        assertEquals("Ale", heap.remove().getName());
        assertEquals("Paola", heap.remove().getName());

    }

    @Test
    public void testPeek() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        heap.add(new Patient("Keven", "Hueso roto", 'A'));
        heap.add(new Patient("Paola", "alergia", 'C'));

        assertEquals("Keven", heap.peek().getName());


    }

    @Test
    public void testIsEmpty() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        assertTrue(heap.isEmpty());

        heap.add(new Patient("Sofia", "fiebre", 'B'));
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testSize() {
        VectorHeap<Patient> heap = new VectorHeap<>();
        assertEquals(0, heap.size());

        heap.add(new Patient("Keven", "Hueso roto", 'A'));
        heap.add(new Patient("Paola", "alergia", 'C'));

        assertEquals(2, heap.size());
    
    }


    
}
