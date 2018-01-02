package ${packageStr};

import org.springframework.data.jpa.repository.JpaRepository;

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

public interface ${className} extends JpaRepository<${entityClassName}, String> {

}