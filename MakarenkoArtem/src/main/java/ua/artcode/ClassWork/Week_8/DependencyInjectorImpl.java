package ua.artcode.ClassWork.Week_8;

import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by serhii on 29.08.15.
 */
public class DependencyInjectorImpl implements DependencyInjector {

    private Map<String, Object> context = new HashMap<>();
    File prop = new File("ioc/context.properties");
    String text = prop.toString();

    


    public DependencyInjectorImpl() {
       /* // load prop file and inti context
        context.put(text,);*/
    }

    @Override
    public void inject(Object obj) {
        Class cl = obj.getClass();

        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            //if has annotation
            String key = field.getType().getName();
            Object forInject = context.get(key);
            if(forInject != null){
                try {
                    field.set(obj, forInject);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
