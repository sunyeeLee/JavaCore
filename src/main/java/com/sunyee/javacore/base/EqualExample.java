package com.sunyee.javacore.base;

/**
 * 检查是否为同一个对象的引用，如果是直接返回 true；
 * 检查是否是同一个类型，如果不是，直接返回 false；
 * 将 Object 对象进行转型；
 * 判断每个关键域是否相等。
 * Created by lishunyi on 2019/5/20
 */
public class EqualExample {
    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualExample that = (EqualExample) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }

    /**
     * 理想的散列函数应当具有均匀性，即不相等的对象应当均匀分布到所有可能的散列值上。
     * 这就要求了散列函数要把所有域的值都考虑进来。可以将每个域都当成 R 进制的某一位，
     * 然后组成一个 R 进制的整数。R 一般取 31，因为它是一个奇素数，如果是偶数的话，当出现乘法溢出，
     * 信息就会丢失，因为与 2 相乘相当于向左移一位。
     *
     * 一个数与 31 相乘可以转换成移位和减法：31*x == (x<<5)-x，编译器会自动进行这个优化。
     * @return
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

}
