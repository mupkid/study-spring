package org.ohx.springbootfiledemo;

import io.swagger.annotations.*;
import org.ohx.springbootfiledemo.utils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 门面统一接口
 * @author ouhaoxian
 * @date 2020-05-09
 */
@RestController
@RequestMapping("/facade")
@Api("门面控制器") //@Api：用在类上，说明该类的作用
public class FacadeController {

    /**
     * @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
     * @ApiModelProperty：描述一个model的属性
     * @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
     * paramType：参数放在哪个地方
     *     header-->请求参数的获取：@RequestHeader
     *     query-->请求参数的获取：@RequestParam
     *     path（用于restful接口）-->请求参数的获取：@PathVariable
     *     body（不常用）
     *     form（不常用）
     * name：参数名
     * dataType：参数类型
     * required：参数是否必须传
     * value：参数的意思
     * defaultValue：参数的默认值
     *
     * @ApiResponses：用于表示一组响应
     * @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
     * code：数字，例如400
     * message：信息，例如"请求参数没填好"
     * response：抛出异常的类
     */
    @ApiOperation("门面Controller")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "form", name = "modulename", dataType = "string", required = true, value = "模块名称和动作"),
            @ApiImplicitParam(paramType = "form", name = "params", dataType = "string", required = true, value = "参数"),
            @ApiImplicitParam(paramType = "form", name = "file", dataType = "file", required = false, value = "文件")
    })
    @ApiResponses({
    })
    @PostMapping("/")
    public R facade(){

        return R.error();
    }
}
