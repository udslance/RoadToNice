package cn.udslance.knowledge.example;

import cn.udslance.beans.ListNode;
import cn.udslance.mytools.LeetCodeUtils;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @program: RoadToNice
 * @description:
 * @author: Udslance
 * @create: 2022-08-26 22:41
 **/
public class SlowFastNodeTest {
    ListNode listNode12 = LeetCodeUtils.makeListNodeByArr(new int[]{1, 2});
    ListNode listNode13 = LeetCodeUtils.makeListNodeByArr(new int[]{1, 2, 3});
    ListNode listNode14 = LeetCodeUtils.makeListNodeByArr(new int[]{1, 2, 3, 4});
    ListNode listNode15 = LeetCodeUtils.makeListNodeByArr(new int[]{1, 2, 3, 4, 5});

    ListNode listNode16 = LeetCodeUtils.makeListNodeByArr(new int[]{1, 2, 3, 4, 5, 6});


    private static final Logger LOGGER = Logger.getLogger("");

    /**
     * 基础1：奇数个节点，快指针到末尾的时候慢指针在中点
     */
    @Test
    public void test1() {
        ListNode fast = listNode13;
        ListNode slow = listNode13;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        LOGGER.info("快指针：" + fast);
        LOGGER.info("慢指针：" + slow);
    }

    /**
     * 基础2：偶数个节点，快指针到末尾的时候慢指针在对称轴的左侧一个
     */
    @Test
    public void test2() {
        ListNode fast = listNode12;
        ListNode slow = listNode12;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        LOGGER.info("快指针：" + fast);
        LOGGER.info("慢指针：" + slow);
    }

    /**
     * 基础3：偶数个节点，快指针到末尾的时候慢指针在对称轴的右侧一个
     */
    @Test
    public void test3() {
        ListNode fast = listNode14;
        ListNode slow = listNode14;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        LOGGER.info("快指针：" + fast);
        LOGGER.info("慢指针：" + slow);
    }
}
