package ${packageStr};

import java.io.Serializable;
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
* @since 1.
 */
public class ${className} implements Serializable {
    private static final long serialVersionUID = 1L;
    
${propertiesStr}
${methodStr}
}