package com.windyang.springdemo0201.test;

import cn.hutool.core.date.CalendarUtil;
import cn.hutool.core.date.DateUtil;
import com.windyang.springdemo0201.SpringDemo0201Application;
import com.windyang.springdemo0201.dto.MyDictionary;
import com.windyang.springdemo0201.prototype.ExcelHandlerInterface;
import com.windyang.springdemo0201.service.HomeService;
import com.windyang.springdemo0201.util.CompressUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.*;

@SpringBootTest(classes = SpringDemo0201Application.class)
@RunWith(SpringRunner.class)
public class MockTest extends SampleBaseTestCase{

    @Autowired
    @InjectMocks
    private ExcelHandlerInterface excelHandlerInterfaceAutowired;

    @Mock
    private HomeService homeServiceMock;

    @Spy
    private HomeService homeServiceSpy;

    @Test
    public void excelHandlerInterfaceMockTest(){
        excelHandlerInterfaceAutowired.fun1();

        Mockito.doReturn("spy").when(homeServiceSpy).getHome();
        excelHandlerInterfaceAutowired.fun1();
    }
    @InjectMocks
    MyDictionary spyDic = new MyDictionary();

    @Spy
    Map<String, String> wordMap;


    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        assertEquals("aMeaning", spyDic.getMeaning("aWord"));
    }



    @Test
    public void testMockStaticMethod(){

        Object o = new Object();
        boolean empty = ObjectUtils.isEmpty(o);
        System.out.println("empty = " + empty);
        try(MockedStatic<ObjectUtils> utilities = Mockito.mockStatic(ObjectUtils.class)){
            utilities.when(()-> ObjectUtils.isEmpty(o)).thenReturn(true);
            assertTrue(ObjectUtils.isEmpty(o));
        }
    }



}
