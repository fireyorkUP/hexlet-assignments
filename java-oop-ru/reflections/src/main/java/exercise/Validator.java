package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Object obj) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if(field.get(obj) == null)
                        notValidFields.add(field.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }


    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == null)
                        notValidFields.computeIfAbsent(field.getName(), k -> new ArrayList<>()).add("can not be null");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                try {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    String fieldValue = (String) field.get(obj);
                    if (fieldValue != null && fieldValue.length() < minLength)
                        notValidFields.computeIfAbsent(field.getName(), k -> new ArrayList<>()).add("length less than " + minLength);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return notValidFields;
    }
}


// END
