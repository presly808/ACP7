package ua.artcode.week8.ioc;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by serhii on 29.08.15.
 */
public class DependencyInjectorImpl implements DependencyInjector {

    private Map<String, Object> context = new HashMap<>();

    public DependencyInjectorImpl() {
        // load prop file and inti context
        context.put("ua.artcode.week8.ioc.IService", new IServiceAImpl());
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
