package com.jack.endroid.core.javabasic.annotation.intdef;

import com.jack.endroid.annotationtester.R;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import androidx.annotation.DrawableRes;
import androidx.annotation.IntDef;

public class Test {
    private static WeekDay mCurrentDay;
    @WekDay
    private static int mCurrentIntDay;

    // 枚举方式限定入参：枚举的每一个成员就是一个WeekDay对象（但对象占用更大的内存）
    enum WeekDay {
        SUNDAY, MONDAY
    }

    /* 为了优化内存，可以使用 int 替代 enum */
    private static final int SUNDAY = 0;
    private static final int MONDAY = 1;
    // 注解方式限定入参：IntDef 限定此注解标记的 int 只能在 {SUNDAY, MONDAY} 中选
    @IntDef({SUNDAY, MONDAY})
	// FIELD：指定 WekDay 可以作用于成员变量 mCurrentIntDay
	// PARAMETER：指定 WekDay 可以作用于成员方法的参数 setCurrentDay(@WekDay int currentDay)
    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    @interface WekDay {  //注解

    }

    // 枚举方式限定入参：限定输入参数必须为枚举类型 WeekDay
    public static void setCurrentDay(WeekDay currentDay) {
        mCurrentDay = currentDay;
    }

    // 注解方式限定入参：对参数 int 添加 @WekDay 注解，此 int 的取值范围就由 @WekDay 约定了
    public static void setCurrentDay(@WekDay int currentDay) {
        mCurrentIntDay = currentDay;
    }

    /*
     * 添加系统提供的 @DrawableRes 注解，就会自动检查输入值，
     * 若输入为非法的int时，就会提示开发者"Expected resource of type drawable"
     */
    public static void setDrawable(@DrawableRes int id) {

    }

    public static void main(String... args) {
    	// 编译器提示：Expected resource of type drawable（但编译能通过）
//        setDrawable(1);
		setDrawable(R.drawable.ic_launcher_background);	// OK
		// 枚举方式限定入参：调用时必须输入 WeekDay 类型
        setCurrentDay(WeekDay.SUNDAY);
        // 编译器提示：Must be one of: Test.SUNDAY, Test.MONDAY（但编译能通过）
		// 该语法检查是由 IDE 的插件完成的，就和编码过程中的各种语法提示、语法检查一样
//		setCurrentDay(111);
//		mCurrentIntDay = 1;
		// 注解方式限定入参：调用时 int 值只能在 {SUNDAY, MONDAY} 中选
		setCurrentDay(SUNDAY);	// OK
//		Test.mCurrentIntDay = 2;
//		System.out.println("Test.mCurrentIntDay = " + Test.mCurrentIntDay);
    }
}
