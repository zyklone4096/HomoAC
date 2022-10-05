package cn.afternode.homo.homoac.utils.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
public @interface SkidClass {
    String plugin();
    String clazz();

    boolean modified() default false;
}
