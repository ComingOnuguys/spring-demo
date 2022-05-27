package com.windyang.springdemo0201.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class ExampleTest {

     @Mock
     private List list;

     @Test
     public void shouldDoSomething() {
         list.add(100);
     }
 }