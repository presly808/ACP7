package ua.artcode.week8.ioc;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by serhii on 29.08.15.
 */
public class DependencyInjectorImpl implements DependencyInjector {

    private Map<String, Object> context = new HashMap<>();

    public DependencyInjectorImpl() {
        Properties prop = new Properties();
        try {
            //                                        // classpath
            prop.load(DependencyInjector.class.getResourceAsStream("/ioc/context.properties"));
            Set<String> names = prop.stringPropertyNames();
            for (String name : names) {
                String className = prop.getProperty(name);
                Class cl = Class.forName(className);
                Object instance = cl.newInstance();
                context.put(name,instance);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void inject(Object obj) {
        Class cl = obj.getClass();

        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            //if has annotation
            if(field.isAnnotationPresent(ForInject.class)){
                String key = field.getType().getName();
                Object forInject = context.get(key);
                if (forInject != null) {
                    try {
                        field.set(obj, forInject);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


    }
}
