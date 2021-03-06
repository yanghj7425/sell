package com.self.sell.common.util;

import com.self.sell.common.pojo.vo.ResultVo;

public class ResultVoUtils {

    private ResultVoUtils() {

    }


    public static <T> ResultVo<T> success(T data) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setData(data);
        resultVo.setCode(1);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo();

        resultVo.setMsg(msg);
        resultVo.setCode(code);

        return resultVo;
    }


}
