package cn.dblearn.blog.common.util;

import cn.dblearn.blog.common.exception.enums.ErrorEnum;
import cn.dblearn.blog.common.exception.enums.ExceptionEnum;

import java.util.HashMap;

/**
 * Result
 *
 * @author bobbi
 * @date 2018/10/07 13:28
 * @email 571002217@qq.com
 * @description 通用返回类
 */
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", 0);
        put("msg", "success");
    }

    public static Result ok() {
        return new Result();
    }

    public static Result error() {
        return error(ErrorEnum.UNKNOWN);
    }

    public static Result error(ErrorEnum eEnum) {
        return new Result().put("code", eEnum.getCode()).put("msg", eEnum.getMsg());
    }

    public static Result exception() {
        return exception(ExceptionEnum.UNKNOWN);
    }

    public static Result exception(ExceptionEnum eEnum) {
        return new Result().put("code", eEnum.getCode()).put("msg", eEnum.getMsg());
    }



    /**
     * 封装业务数据
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        //将HashMap对象本身返回
        return this;
    }
}