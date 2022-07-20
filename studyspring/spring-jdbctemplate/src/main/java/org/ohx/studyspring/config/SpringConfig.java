package org.ohx.studyspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * {@link Configuration}相当于&lt;beans&gt;标签，{@link Configuration}自身也是一个{@link Component}
 * <p>
 * {@link ComponentScan}相当于&lt;context:component-scan base-package=”com.*.*”/&gt;
 *
 * @author mudkip
 * @date 2022/7/20
 */
@Configuration
@ComponentScan("org.ohx.studyspring")
public class SpringConfig {
}
