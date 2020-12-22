package com.netcracker.utils.reflection;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.*;

@Configuration(packages = {"netcracker/utils/sort", "netcracker/utils/validator"})
/**
 * class makes dependency injection
 */
public class Injector {

    /**
     * Field contain list of classes from specified package from configuration
     */
    private static List<Object> classList;

    /**
     * constructor without parameters
     */
    public Injector() {
        classList = new ArrayList<>();
        if (this.getClass().isAnnotationPresent(Configuration.class)) {
            Configuration configuration = this.getClass().getAnnotation(Configuration.class);

            for (String packages : configuration.packages()) {
                packages = packages.replace(".", "/");
                try (DataInputStream dataInputStream = new DataInputStream((InputStream) Objects.requireNonNull(
                        this.getClass().getClassLoader().getResource(packages)).getContent())) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        if (line.endsWith(".class")) {
                            String className = packages.replace("/", ".") + "."
                                    + line.substring(0, line.length() - 6);
                            classList.add(Class.forName(className).getConstructor().newInstance());
                        }
                    }
                } catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException
                        | ClassNotFoundException | IllegalAccessException e) {
                }
            }
        }
    }

    /**
     * Method for making dependency injection
     * @param o is an object for injection
     * @param <T> - is a generic for injection
     * @return - an object with injection
     * @throws IllegalAccessException
     */

    public static <T> T inject(final T o) throws IllegalAccessException {

        List<Object> classes = new ArrayList<>();
        for (Field field : o.getClass().getDeclaredFields()) {

            if (field.isAnnotationPresent(AutoInjectable.class)) {
                field.setAccessible(true);

                if (field.getType().getName().contains("java.util.List")) {
                    ParameterizedType fieldListType = (ParameterizedType) field.getGenericType();
                    Class<?> fieldGenericType = (Class<?>) fieldListType.getActualTypeArguments()[0];

                    for (Object object : classList) {
                        if (object != null && fieldGenericType.isAssignableFrom(object.getClass())) {
                            classes.add(object);
                        }
                        field.set(o, classes);
                    }

                } else {
                    for (Object object : classList) {
                        if (object != null && field.getType().isAssignableFrom(object.getClass())) {
                            classes.add(object);
                        }

                        if (classes.size() == 1) {
                            field.set(o, classes.get(0));
                        } else {
                            throw new RuntimeException("Find more than 1 or less than 1 classes for inject");
                        }
                    }
                }
            }
        }

        return o;
    }
}
