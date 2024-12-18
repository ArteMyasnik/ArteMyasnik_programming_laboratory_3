package itmo.proga.interfaces.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Refreshable {
}
