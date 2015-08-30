package ua.artcode.week8;

import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pikolo on 29.08.15.
 */
public class DependencyInjectorImpl implements DependencyInjector {
    private Map<String, Object> context = new HashMap<>();

    public DependencyInjectorImpl() {
        // load prop file and inti context

        context.put("resources.ioc.context.properties", new IServiceAImpl());
    }

    @Override
    public void inject(Object obj) {
        Class cl = obj.getClass();

        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ForInject.class)) {
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
