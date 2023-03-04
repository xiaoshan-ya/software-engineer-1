import org.junit.Test;

import static org.junit.Assert.*;

public class SpellTest {
    private final Spell spell = new Spell();

    @Test
    public void test1(){
        assertTrue(spell.spell(2,3));
    }

    @Test
    public void test2(){
        assertTrue(spell.spell(6,8));
    }

    @Test
    public void test3(){
        assertFalse(spell.spell(3,6));
    }

    @Test
    public void test4(){
        assertTrue(spell.spell(4,1));
    }
}
