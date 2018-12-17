package Inject;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * Created by Кирилл on 17.12.2018.
 */
public class Injector {
    /** Поле Логера*/
    private static final Logger log = Logger.getLogger(Injector.class);
    /**
     * Функция, которая устанавивает сортер из файла config.properties
     */
    public void dosomething(Object obj) {
        log.info("set field with annotation @inject new value");
        Properties prop = new Properties();
        InputStream is;
        try {
            is = new FileInputStream("src/main/resources/config.properties");
            try {
                prop.load(is);
                Class<?> value;
                try {
                    Class r = obj.getClass();
                    Field[] field = r.getDeclaredFields();
                    value = Class.forName(prop.getProperty("Sorter.Sorter"));
                    for (int i=0; i< field.length; i++) {
                        Annotation[] an = field[i].getAnnotations();
                        for(int j=0; j< an.length; j++) {
                            if (an[j].toString().equals("@Inject.Inject()")) {
                                field[i].setAccessible(true);
                                try {
                                    field[i].set(obj, value.newInstance());
                                    log.info("field " + field[i] + " setted");
                                } catch (Exception e) {
                                    log.error("can't set field " + field[i].getName() + " at " + value.getSimpleName());
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    log.error("class by name not found");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                log.error("can't load file");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            log.error("config property not found");
            e.printStackTrace();
        }
    }
}
