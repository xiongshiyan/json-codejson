package top.jfunc.json.strategy;

import link.jfire.baseutil.collection.StringCache;
import link.jfire.codejson.function.WriterAdapter;

/**
 * @author xiongshiyan at 2018/10/8 , contact me with email yanshixiong@126.com or phone 15208384257
 */
public class BigDecimalWriter extends WriterAdapter {
    @Override
    public void write(Object field, StringCache cache, Object entity) {
        cache.append(field);
    }
}
