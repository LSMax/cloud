package ${packageStr};

import java.io.Serializable;
${importStr}

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
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
${tableMessage}
public class ${className} implements Serializable {
    private static final long serialVersionUID = 1L;
    
${propertiesStr}
${methodStr}
}