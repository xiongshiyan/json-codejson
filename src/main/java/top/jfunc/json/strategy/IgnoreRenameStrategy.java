package top.jfunc.json.strategy;

import link.jfire.codejson.strategy.WriteStrategy;
import top.jfunc.json.annotation.JsonField;

import java.lang.reflect.Field;

/**
 * @author xiongshiyan at 2018/9/25 , contact me with email yanshixiong@126.com or phone 15208384257
 */
public class IgnoreRenameStrategy {
    public static WriteStrategy strategy(Class<?> javaBeanClass, String[] ignoreFields) {
        WriteStrategy strategy = new WriteStrategy();
        //明确指定忽略的
        if(null != ignoreFields && 0 != ignoreFields.length){
            for (String field : ignoreFields) {
                strategy.addIgnoreField(javaBeanClass.getName() + "." + field);
            }
        }

        Field[] fields = javaBeanClass.getDeclaredFields();
        if(null != fields && 0 != fields.length){
            for (Field field : fields) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                if(null == annotation){
                    continue;
                }

                //标注JsonField忽略的
                if(!annotation.serialize()){
                    strategy.addIgnoreField(javaBeanClass.getName() + "." + field.getName());
                    //需要改名的
                }else if(!"".equals(annotation.value())){
                    strategy.addRenameField(javaBeanClass.getName() + "." + field.getName() , annotation.value());
                }

            }
        }
        return strategy;
    }
}
