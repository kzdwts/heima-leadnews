package com.heima.model.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * http响应code枚举
 *
 * @author Kang Yong
 * @date 2024/4/19
 * @since 1.0.0
 */
@Getter
@AllArgsConstructor
public enum AppHttpCodeEnum {

    // 成功段固定为200
    SUCCESS(200, "操作成功"),

    // 登录段1~50
    NEED_LOGIN(1, "需要登录后操作"),
    LOGIN_PASSWORD_ERROR(2, "密码错误"),

    // TOKEN50~100
    TOKEN_INVALID(50, "无效的TOKEN"),
    TOKEN_EXPIRE(51, "TOKEN已过期"),
    TOKEN_REQUIRE(52, "TOKEN是必须的"),

    // SIGN验签 100~120
    SIGN_INVALID(100, "无效的SIGN"),
    SIG_TIMEOUT(101, "SIGN已过期"),

    // 参数错误 500~1000
    PARAM_REQUIRE(500, "缺少参数"),
    PARAM_INVALID(501, "无效参数"),
    PARAM_IMAGE_FORMAT_ERROR(502, "图片格式有误"),
    SERVER_ERROR(503, "服务器内部错误"),

    // 数据错误 1000~2000
    DATA_EXIST(1000, "数据已经存在"),
    AP_USER_DATA_NOT_EXIST(1001, "ApUser数据不存在"),
    DATA_NOT_EXIST(1002, "数据不存在"),

    // 数据错误 3000~3500
    NO_OPERATOR_AUTH(3000, "无权限操作"),
    NEED_ADMIND(3001, "需要管理员权限"),

    // 自媒体文章错误 3501~3600
    MATERIASL_REFERENCE_FAIL(3501, "素材引用失效"),

    ;

    private Integer code;
    private String desc;


    /**
     * 枚举转成Map
     */
    private static final Map<Integer, AppHttpCodeEnum> map = Arrays.stream(values()).collect(Collectors.toMap(AppHttpCodeEnum::getCode, Function.identity()));

    /**
     * 功能: 根据Code获取描述信息.
     *
     * @param code {@link Integer}
     * @return {@link String}
     * @author Kang Yong
     * @date 2024/4/19
     */
    private static String getDescByCode(Integer code) {
        return of(code).map(AppHttpCodeEnum::getDesc).orElse("");
    }

    /**
     * 功能:根据Code 获取枚举对象 .
     *
     * @param code {@link Integer}
     * @return {@link AppHttpCodeEnum}
     * @author Kang Yong
     * @date 2024/4/19
     */
    public static AppHttpCodeEnum getEnumByCode(Integer code) {
        return of(code).orElse(null);
    }

    /**
     * 功能: Optional 转换.
     *
     * @param code {@link Integer}
     * @return {@link Optional<AppHttpCodeEnum>}
     * @author Kang Yong
     * @date 2024/4/19
     */
    private static Optional<AppHttpCodeEnum> of(Integer code) {
        return Optional.ofNullable(map.get(code));
    }

}
