package com.springboot.config;

/**
 * 每个线程的数据源管理
 */
public class DynamicDatasourceContextHolder {
    private static final ThreadLocal<AreaKeyId> currentDatasource = new ThreadLocal<>();

    /**
     * 设置当前数据源
     * @param areaKeyId
     */
    public static void set(AreaKeyId areaKeyId) {
        currentDatasource.set(areaKeyId);
    }

    /**
     * 清除当前数据源
     */
    public static void clear() {
        currentDatasource.remove();
    }

    /**
     * 获取当前数据源
     * @return
     */
    public static AreaKeyId get() {
        return currentDatasource.get();
    }

}
