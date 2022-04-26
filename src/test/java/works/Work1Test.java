package works;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Work1Test {

    @Test
    void onePart() {
        // Первое условие выполняется при a=2.83
        // Второе при a=-2.83, x1 = это 1 и 2 условие
        // x2 = Это 3 условие

        double x1 = 0.1, x2 = -3;
        Work1.One testOne = Work1.One.builder().a(-2.83).b(2.05)
                .from(x1).to(x1).dx(0.5).build();
        Assertions.assertNotEquals(testOne.f1(x1), testOne.f(x1));

        Work1.One testTwo = testOne.toBuilder().a(2.83).build();
        Assertions.assertNotEquals(testTwo.f3(x1), testTwo.f(x1));

        Work1.One testThree = testTwo.toBuilder().from(x2).to(x2).build();
        Assertions.assertNotEquals(testThree.f2(x2), testThree.f(x2));
    }
}
