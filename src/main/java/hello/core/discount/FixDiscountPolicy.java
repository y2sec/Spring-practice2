package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy{

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP)
            return 1000;
        else
            return 0;
    }
}
