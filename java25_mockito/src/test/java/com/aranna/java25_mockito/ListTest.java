package com.aranna.java25_mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {
    @Test
    void test(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size());
        assertEquals(0, listMock.size());
    }



    @Test
    void multipleValue(){
        List listMock=mock(List.class);
        when(listMock.size()).thenReturn(3).thenReturn(10);
        assertEquals(3, listMock.size());
        assertEquals(10, listMock.size());
    }

    @Test
    void specificParam(){
        List listMock=mock(List.class);
        when(listMock.get(0)).thenReturn("Some string");
        assertEquals("Some string", listMock.get(0));
        assertEquals(listMock, listMock);
    }


    @Test
    void genericParam(){
        List listMock=mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("Some string");
        assertEquals("Some string", listMock.get(0));
        assertEquals(listMock, listMock);
    }
}
