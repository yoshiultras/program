import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleClassTest {
    @Test(timeout = 10) //������������ ����� ���������� ����� -- 10 �����������.
    public void testMin(){ //������������ ������ ������.
        assertEquals(3, SimpleClass.min(3, 5, 4));
        //assertEquals("���� �� �������.", 30, SimpleClass.min(3, 5, 4));
        assertEquals(5, SimpleClass.min(5, 5, 5));
        assertEquals(2, SimpleClass.min(2, 2, 2));
    }
    @Test
    public void testConstructor(){ //������������ ������������.
        SimpleClass obj = new SimpleClass(100);
        assertEquals(100, obj.getAttr());
    }
    @Test(expected = Exception.class) //��� (����) ���������� ���������� - Exception.
    public void testDivExcept(){ //������������ ������ ���������� ������.
        new SimpleClass(100).div(0);
    }
}