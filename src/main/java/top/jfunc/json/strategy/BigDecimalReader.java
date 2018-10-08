package top.jfunc.json.strategy;

import link.jfire.codejson.function.JsonReader;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * @author xiongshiyan at 2018/10/8 , contact me with email yanshixiong@126.com or phone 15208384257
 */
public class BigDecimalReader implements JsonReader{
    @Override
    public Object read(Type entityType, Object value) {
        return new BigDecimal(value.toString());
    }
}
