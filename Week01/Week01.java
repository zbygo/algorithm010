package week01;

import java.util.Deque;
import java.util.LinkedList;

public class Week01 {
    //用 add first 或 add last 这套新的 API 改写 Deque 的代码
    public static void modifyQue(){
        Deque<String> que =new LinkedList<String>();
        que.addLast("a");
        que.addLast("b");
        que.addLast("c");
        System.out.println(que);
        
        String str = que.peek();
        System.out.println(str);
        System.out.println(que);
        while(!que.isEmpty()){
            System.out.println(que.pop());
        }
        System.out.println(que);
    }
    public static void main(String[] args) {
        modifyQue();
         
    }
    /**
     * 功能描述:  删除排序数组中的重复项
     * 
     * @param nums
     * @return int
     * @version 2.0.0
     * @author 18047722
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        //储存上一个重复的值
        int start =nums[0];
        //存储不同个数的长度  相当于指针
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(start!=nums[i]){
                start = nums[i];
                nums[j++]=nums[i];
            }
        }
        
        return j;
                    
    }
    /**
     * 功能描述: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 
     * @param nums
     * @param k void
     * @version 2.0.0
     * @author 18047722
     */
    public void rotate(int[] nums, int k) {
        //k大于nums的长度是需要特殊处理
        if(k>nums.length){
            k=k%nums.length;
        }
        //1.新建一个数组保存后k个元素
        
        int[] newArray = new int[nums.length];
        for(int i=0;i<k;i++){
            newArray[i]=nums[nums.length-k+i];
        }
        //2.将原数组的钱 n-k位添加到新数组中
        for(int j=0;j<nums.length-k;j++){
            newArray[j+k]=nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newArray[i];
        }
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    /**
     * 功能描述: 合并两个有序链表
     * 
     * @param l1
     * @param l2
     * @return ListNode
     * @version 2.0.0
     * @author 18047722
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        //新的链表头 后面需要去除掉
        ListNode head=new ListNode(-1);
        ListNode pre = head;
        while(l1 != null && l2 != null){
            if(l1.val<l2.val){
                //1.需要将该节点放到pre的后面
                pre.next=l1;
                //2.将当前节点变为pre节点
                pre = l1;
                //继续遍历下一个节点
                l1 = l1.next;
                        
            }else{
               //1.需要将该节点放到pre的后面
                pre.next=l2;
                //2.将当前节点变为pre节点
                pre = l2;
                //继续遍历下一个节点
                l2 = l2.next;
            }
        }
        //处理剩余节点
        if(l1!=null){
            pre.next=l1;
        }else{
            pre.next=l2;
        }
        
        
        return head.next;
    }
    
   
}
