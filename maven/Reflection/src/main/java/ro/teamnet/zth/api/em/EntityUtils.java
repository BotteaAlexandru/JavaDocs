package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 7/7/2016.
 */
public class EntityUtils {

    public EntityUtils() throws UnsupportedOperationException {
    }

    public static String getTableName(Class entity) {
        Table annotation = (Table) entity.getAnnotation(Table.class);
        return annotation.name();
    }

    public static ArrayList<ColumnInfo> getColumns(Class entity) {
        ArrayList<ColumnInfo> r = new ArrayList<ColumnInfo>();

        for (Field a : entity.getDeclaredFields()) {

            ColumnInfo newColumnInfo = new ColumnInfo();

            newColumnInfo.setColumnName(a.getName());
            newColumnInfo.setColumnType(a.getType());

            Column c = (Column) a.getAnnotation(Column.class);

            if (c != null)
                newColumnInfo.setDbName(c.name());
            else {
                Id i = (Id) a.getAnnotation(Id.class);
                newColumnInfo.setId(true);
                newColumnInfo.setDbName(i.name());
            }

            r.add(newColumnInfo);
        }

        return r;
    }

    public static Object castFromSqlType(Object value, Class wantedType) {
        if (value.getClass() == BigDecimal.class && wantedType == Integer.class){
            return ((BigDecimal)value).intValue();
        }
        if (value.getClass() == BigDecimal.class && wantedType == Long.class){
            return ((BigDecimal)value).longValue();
        }
        if (value.getClass() == BigDecimal.class && wantedType == Float.class){
            return ((BigDecimal)value).floatValue();

        }
        if (value.getClass() == BigDecimal.class && wantedType == Double.class){
            return ((BigDecimal)value).doubleValue();
        }
        return value;
    }

    public static ArrayList<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        ArrayList<Field> fields = new ArrayList<Field>();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(annotation)) {
                fields.add(field);
            }
        }

        return fields;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if (object.getClass().isAnnotationPresent(Table.class)){
            for (Field field : object.getClass().getDeclaredFields()) {
                if(field.isAnnotationPresent(Id.class)){
                    field.setAccessible(true);
                    return field.get(object);
                }
            }

        }

        return object;
    }
}
