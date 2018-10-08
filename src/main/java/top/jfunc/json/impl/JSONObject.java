package top.jfunc.json.impl;

import link.jfire.codejson.JsonTool;
import link.jfire.codejson.function.ReaderContext;
import link.jfire.codejson.function.WriterContext;
import link.jfire.codejson.strategy.WriteStrategy;
import top.jfunc.json.JsonArray;
import top.jfunc.json.JsonObject;
import top.jfunc.json.strategy.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @author xiongshiyan at 2018/6/10
 */
@SuppressWarnings("unchecked")
public class JSONObject extends BaseMapJSONObject {

    static {
        ReaderContext.putReader(BigInteger.class , new BigIntegerReader());
        ReaderContext.putReader(BigDecimal.class , new BigDecimalReader());

        WriterContext.putwriter(BigInteger.class , new BigIntegerWriter());
        WriterContext.putwriter(BigDecimal.class , new BigDecimalWriter());
    }

    public JSONObject(Map<String , Object> map){
        super(map);
    }
    public JSONObject(){
        super();
    }
    public JSONObject(String jsonString){
        super(jsonString);
    }

    @Override
    protected Map<String, Object> str2Map(String jsonString) {
        return (link.jfire.codejson.JsonObject)JsonTool.fromString(jsonString);
    }

    @Override
    protected String map2Str(Map<String, Object> map) {
        return JsonTool.write(map);
    }

    @Override
    public JsonObject getJsonObject(String key) {
        assertKey(key);
        //这里不能使用getJSONObject，因为每一种Json实现不一样，给出的JsonObject类型是不一致的。
        //这里就是各种JsonObject不能混用的原因
        Object temp = this.map.get(key);
        Object t = checkNullValue(key, temp);

        if(t instanceof Map){
            return new JSONObject((Map<String, Object>) t);
        }

        return (JsonObject) t;
    }

    @Override
    public JsonArray getJsonArray(String key) {
        assertKey(key);
        //这里不能使用getJSONObject，因为每一种Json实现不一样，给出的JsonObject类型是不一致的。
        //这里就是各种JsonObject不能混用的原因
        Object temp = this.map.get(key);
        Object t = checkNullValue(key, temp);

        if(t instanceof List){
            return new JSONArray((List<Object>)t);
        }
        return (JsonArray) t;
    }


    @Override
    public JsonObject parse(String jsonString) {
        this.map = (link.jfire.codejson.JsonObject)JsonTool.fromString(jsonString);
        return this;
    }

    @Override
    public <T> String serialize(T javaBean, boolean nullHold, String... ignoreFields) {
        WriteStrategy strategy = IgnoreRenameStrategy.strategy(javaBean.getClass(), ignoreFields);

        strategy.addTypeStrategy(BigInteger.class , new BigIntegerWriter());
        strategy.addTypeStrategy(BigDecimal.class , new BigDecimalWriter());

        return strategy.write(javaBean);
        //return JsonTool.write(javaBean);
    }

    @Override
    public <T> T deserialize(String jsonString, Class<T> clazz) {
        CompatibleJsonObject value = CompatibleJsonObject.from((link.jfire.codejson.JsonObject) JsonTool.fromString(jsonString));
        return (T) ReaderContext.getReader(clazz).read(clazz, value);
        //return JsonTool.read(clazz, jsonString);
    }

    @Override
    public JsonObject fromMap(Map<String, Object> map) {
        return new JSONObject(map);
    }
}
