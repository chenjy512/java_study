package com.cjy.anno.test;

import com.cjy.anno.api.Column;
import com.cjy.anno.api.Id;
import com.cjy.anno.api.TableRef;
import com.cjy.anno.bean.Person;

import java.lang.reflect.Field;

public class MainTest {

    public static void main(String[] args) throws IllegalAccessException {
        Person ps = new Person(101, "zhangsan", "zhangsan@163.com");
        //反射使用，获取类实例
        Class<? extends Person> cls = ps.getClass();
        //获取表注解
        TableRef tableRef = cls.getAnnotation(TableRef.class);
        //获取注解值
        System.out.println(tableRef.value());
        //获取所有属性对象
        Field[] fields = cls.getDeclaredFields();
        Integer id = 0 ;
        for (Field field : fields) {
            Id rowKeyAnno = field.getAnnotation(Id.class);
            if(rowKeyAnno != null){
                //属性由于是私有的所以需要权限
                field.setAccessible(true);
                //获取属性值
                id = (Integer)field.get(ps);
                break;
            }
        }
        System.out.println(id);

        //其他注解值
        for (Field field : fields) {
            //判断此数据是否为column注解标注
            Column column = field.getAnnotation(Column.class);
            if(column != null){
                //是，则取其列族
                String family = column.family();
                //取列名，判断为空则使用属性名
                String cn = column.column();
                if("".equals(cn) || cn == null){
                    //获取属性名
                    cn = field.getName();
                }
                //获取值
                field.setAccessible(true);
                String value = (String) field.get(ps);
                System.out.println("column:"+value +"  cn:"+cn + " family:"+family);
            }
        }
    }
}
