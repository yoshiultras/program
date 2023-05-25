import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleClassTest {
    @Test(timeout = 10) //Максимальное время выполнения теста -- 10 миллисекунд.
    public void testMin(){ //Тестирование метода класса.
        assertEquals(3, SimpleClass.min(3, 5, 4));
        //assertEquals("Тесе не пройден.", 30, SimpleClass.min(3, 5, 4));
        assertEquals(5, SimpleClass.min(5, 5, 5));
        assertEquals(2, SimpleClass.min(2, 2, 2));
    }
    @Test
    public void testConstructor(){ //Тестирование конструктора.
        SimpleClass obj = new SimpleClass(100);
        assertEquals(100, obj.getAttr());
    }
    @Test(expected = Exception.class) //Тип (один) ожидаемого исключения - Exception.
    public void testDivExcept(){ //Тестирование метода экземпляра класса.
        new SimpleClass(100).div(0);
    }
}