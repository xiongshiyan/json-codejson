package top.jfunc.json.strategy;

import link.jfire.codejson.JsonObject;
import top.jfunc.json.impl.ValueCompatible;

import java.util.Map;

/**
 * codejson 的 JsonObject的类型处理不太好，强转会出问题，兼容化处理
 * @author xiongshiyan at 2018/10/8 , contact me with email yanshixiong@126.com or phone 15208384257
 */
public class CompatibleJsonObject extends JsonObject{

    public static final CompatibleJsonObject from(Map<String , Object> map){

        return new CompatibleJsonObject(map);
    }
    public CompatibleJsonObject(Map<String , Object> map){
        map.forEach(super::put);
    }
    @Override
    public String getWString(String key) {
        return ValueCompatible.compatibleValue(get(key) , String.class);
        //return (String) get(key);
    }
    @Override
    public Long getWLong(String key) {
        return ValueCompatible.compatibleValue(get(key) , Long.class);
        //return ((Long) get(key));
    }
    @Override
    public Integer getWInteger(String key) {
        return ValueCompatible.compatibleValue(get(key) , Integer.class);
        //return ((Long) get(key)).intValue();
    }
    @Override
    public Double getWDouble(String key) {
        return ValueCompatible.compatibleValue(get(key) , Double.class);
        //return ((Double) get(key));
    }
    @Override
    public Boolean getWBoolean(String key) {
        return ValueCompatible.compatibleValue(get(key) , Boolean.class);
        //return (Boolean) get(key);
    }
    @Override
    public Float getWFloat(String key) {
        return ValueCompatible.compatibleValue(get(key) , Float.class);
        //return ((Double) get(key)).floatValue();
    }
    @Override
    public Byte getWByte(String key) {
        return ValueCompatible.compatibleValue(get(key) , Byte.class);
        //return ((Long) get(key)).byteValue();
    }
    @Override
    public Short getWShort(String key) {
        return ValueCompatible.compatibleValue(get(key) , Short.class);
        //return ((Long) get(key)).shortValue();
    }
    @Override
    public Character getWCharacter(String key) {
        return ValueCompatible.compatibleValue(get(key) , Character.class);
        // return ((String) get(key)).charAt(0);
    }
    @Override
    public int getInt(String key) {
        return ValueCompatible.compatibleValue(get(key) , int.class);
        //return ((Long) get(key)).intValue();
    }
    @Override
    public float getFloat(String key) {
        return ValueCompatible.compatibleValue(get(key) , float.class);
        //return ((Double) get(key)).floatValue();
    }
    @Override
    public byte getByte(String key) {
        return ValueCompatible.compatibleValue(get(key) , byte.class);
        //return ((Long) get(key)).byteValue();
    }
    @Override
    public char getChar(String key) {
        return ValueCompatible.compatibleValue(get(key) , char.class);
        //return ((String) get(key)).charAt(0);
    }
    @Override
    public boolean getBoolean(String key) {
        return ValueCompatible.compatibleValue(get(key) , boolean.class);
        //return ((Boolean) get(key)).booleanValue();
    }
    @Override
    public double getDouble(String key) {
        return ValueCompatible.compatibleValue(get(key) , double.class);
        //return ((Double) get(key)).doubleValue();
    }
    @Override
    public long getLong(String key) {
        return ValueCompatible.compatibleValue(get(key) , long.class);
        //return ((Long) get(key)).longValue();
    }
    @Override
    public short getShort(String key) {
        return ValueCompatible.compatibleValue(get(key) , short.class);
        //return ((Long) get(key)).shortValue();
    }
}
