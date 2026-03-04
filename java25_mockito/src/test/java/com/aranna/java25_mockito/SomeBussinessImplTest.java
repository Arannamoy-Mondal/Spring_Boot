// package com.aranna.java25_mockito;


// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;

// import org.junit.jupiter.api.Test;

// public class SomeBussinessImplTest {
//     @Test
//     void test(){
//         DataService dataService=mock(DataService.class);
//         when(dataService.retrieveAllData()).thenReturn(new int []{15,25,20});
//         SomeBussinessImpl someBussinessImpl=new SomeBussinessImpl(dataService);
//         int res=someBussinessImpl.findTheGreatestFromAllData();
//         assertEquals(25,res);
//     }
// }


package com.aranna.java25_mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SomeBussinessImplTest {
    @Mock
    private DataService dataService;
    @InjectMocks
    private SomeBussinessImpl someBussinessImpl;

    @Test
    public void test(){ 
        when(dataService.retrieveAllData()).thenReturn(new int[]{10,15,20});
        assertEquals(20, someBussinessImpl.findTheGreatestFromAllData());
    }
}

