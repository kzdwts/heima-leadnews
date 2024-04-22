package com.heima.common.exception;

import com.heima.model.common.dtos.R;
import com.heima.model.common.enums.AppHttpCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器增强类
 *
 * @author Kang Yong
 * @date 2024/4/19
 * @since 1.0.0
 */
@Slf4j
@ControllerAdvice
public class ExceptionCatch {

    /**
     * 功能: 处理不可控异常
     *
     * @param e {@link Exception}
     * @return {@link R}
     * @author Kang Yong
     * @date 2024/4/22
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R exception(Exception e) {
        e.printStackTrace();
        log.error("catch exception:{}", e.getMessage());

        return R.errorResult(AppHttpCodeEnum.SERVER_ERROR);
    }


    /**
     * 功能: 处理可控异常 自定义异常
     *
     * @param e {@link Exception}
     * @return {@link R}
     * @author Kang Yong
     * @date 2024/4/22
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public R exception(CustomException e) {
        e.printStackTrace();
        log.error("catch exception:", e);

        return R.errorResult(e.getAppHttpCodeEnum());
    }


}
