package com.wanfeng.divSpring.ioc;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class divApplicationContext {
    public divApplicationContext(String BeanXmlFile) {
        String path = this.getClass().getResource("/"+BeanXmlFile).getPath();
        SAXReader saxReader = new SAXReader();
        try {
            Document read = saxReader.read(new File(path));
            Element rootElement = read.getRootElement();

            Element element = (Element) rootElement.elements("bean").get(0);

            String id = element.attribute("id").getValue();
            String aClass = element.attribute("class").getValue();

            List<Element> property = element.elements("property");


            //创建对象
            Class<?> aClass1 = Class.forName(aClass);
            Object o = aClass1.newInstance();
            //属性赋值
            Method[] declaredMethods = aClass1.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.getName().startsWith("set")) {
                    String methodName = method.getName().substring(3).toLowerCase();
                    property.forEach(item->{
                        String name = item.attribute("name").getValue();
                        if (name.equals(methodName)) {
                            String value = item.attribute("value").getValue();
                            try {
                                method.invoke(o,value);
                            } catch (IllegalAccessException e) {
                                throw new RuntimeException(e);
                            } catch (InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            }
            //实例对象存储
            singletonObjects.put(id,o);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Object getBean(String id) {
        return singletonObjects.get(id);
    }
    ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
}
