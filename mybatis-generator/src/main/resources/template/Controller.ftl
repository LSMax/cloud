package ${packageStr};

import com.xpand.dispatcher.controller.BaseController;

import org.springframework.web.bind.annotation.*;
${importStr}

/**
*
* ${entityDesc}
*
* @version
* <pre>
 * Author    liusu
 * Version   1.0
 * Date      ${time}
 * </pre>
* @since 1.0
*/
@RestController
public class ${className} extends BaseController{

${propertiesStr}
${methodStr}
}