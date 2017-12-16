
/**
 * Created with Hehel
 * . . . . . . . . . . . ._oo0oo_
 * . . . . . . . . . . . o8888888o
 * . . . . . . . . . . . 88" . "88
 * . . . . . . . . . . . (| -_- |)
 * . . . . . . . . . . . 0\  =  /0
 * . . . . . . . . . . ___/`---'\___
 * . . . . . . . . ..' \\|     |// '.
 * . . . . . . . . / \\|||  :  |||// \
 * . . . . . . . ./ _||||| -:- |||||- \
 * . . . . . . . |   | \\\  -  /// |   |
 * . . . . . . . | \_|  ''\---/''  |_/ |
 * . . . . . . . \  .-\__  '-'  ___/-. /
 * . . . . . . . . .___'. .'  /--.--\  `. .'___
 * . . . . . . .."" '<  `.___\_<|>_/___.' >' "".
 * . . . . | | :  `- \`.;`\ _ /`;.`/ - ` : | |
 * . . . . \  \ `_.   \_ __\ /__ _/   .-` /  /
 * . .=====`-.____`.___ \_____/___.-`___.-'=====
 * `=---='
 * <p>
 * <p>
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * 佛祖保佑         永无BUG
 * Description:
 * User: Hehel
 * Date: 2017-12-11
 * Time: 15:51
 */
public class Solution203 {
    public static void main(String[] args) {
        Solution203 solution203 = new Solution203();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        solution203.removeElements(node,6);
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode helpHead = new ListNode(0);
        helpHead.next = head;
        ListNode cursor = helpHead;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }
        return helpHead.next;


    }
     static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
